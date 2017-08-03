package com.eg.demo.controller;

import com.eg.demo.dao.LeadDAO;
import com.eg.demo.dao.LeadDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.eg.demo.model.Lead;
import com.eg.demo.validator.LeadValidator;

@Controller
@RequestMapping("/leads/addNew")
@SessionAttributes("leads")
public class LeadController
{
	
	@Autowired
	LeadValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
	{
		 Lead lead = new Lead();
		 model.addAttribute("lead", lead);
		 return "addLead";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("lead") Lead lead,
            				BindingResult result, SessionStatus status)
	{
		
		validator.validate(lead, result);

		if (result.hasErrors()) {
			return "addLead";
	}

		//below statements added to just show how to add error messages from this method
		/*boolean invalid_login = true;
		if(invalid_login==true)
		{
			//"firstName", "error.firstName", "First name is required."
			result.rejectValue("firstName", "invalid.firstName");
			return "addStudent";
		}*/

		//Mark Session Complete
		LeadDAOImpl d=new LeadDAOImpl();
		d.add_lead(lead);
		status.setComplete();
		return "addSuccess";
    }
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model) 
	{
		 return "addSuccess";
    }
}