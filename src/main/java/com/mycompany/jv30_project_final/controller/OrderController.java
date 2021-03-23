package com.mycompany.jv30_project_final.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.jv30_project_final.entities.CreditCardEntity;
import com.mycompany.jv30_project_final.model.AccountInfoModel;

@Controller
public class OrderController {

	@RequestMapping(value = "/confirmation", method = RequestMethod.POST)
	public String viewCheckOut(@ModelAttribute("accountInfo") AccountInfoModel accountInfo ,Model model, HttpSession sessio) {
		sessio.setAttribute("accountInfo", accountInfo);
		model.addAttribute("cardModel", new CreditCardEntity());
		return "payment";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String handlePayment(@ModelAttribute("cardModel") CreditCardEntity creditCardEntity ,Model model, HttpSession sessio) {

		System.out.println(creditCardEntity.getCardNumber() + " - " + creditCardEntity.getCvcCode());
		return "payment";
	}
	
	


}
