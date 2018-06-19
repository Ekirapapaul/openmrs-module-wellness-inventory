package org.openmrs.module.wellnessinventory.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AddItemController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "module/wellnessinventory/wellnessinventory.form", method = RequestMethod.GET)
	public void items(ModelMap model) throws IOException {
		InventoryItemService itemService = Context.getService(InventoryItemService.class);
		List<InventoryItem> inventoryItems = itemService.getAllInventoryItems();
		model.addAttribute("modelBase", "openhmis.inventory.item");
	}
	
	@RequestMapping(value = "module/wellnessinventory/wellnessinventory.form", method = RequestMethod.POST)
	public String submitDepartment(WebRequest request, HttpSession httpSession, ModelMap model,
	        @RequestParam(required = false, value = "action") String action,
	        @ModelAttribute("inventoryitem") InventoryItem inventoryItem, BindingResult errors) {
		
		MessageSourceService mss = Context.getMessageSourceService();
		InventoryItemService itemService = Context.getService(InventoryItemService.class);
		if (!Context.isAuthenticated()) {
			errors.reject("inventory.auth.required");
		} else if (mss.getMessage("inventory.purgeDepartment").equals(action)) {
			try {
				itemService.purgeInventoryItem(inventoryItem);
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.delete.success");
				return "redirect:departmentList.list";
			}
			catch (Exception ex) {
				httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "department.delete.failure");
				log.error("Failed to delete department", ex);
				return "redirect:departmentForm.form?departmentId=" + request.getParameter("departmentId");
			}
		} else {
			itemService.saveInventoryItem(inventoryItem);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.saved");
		}
		return "redirect:departmentList.list";
	}
}
