/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv30_project_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.jv30_project_final.entities.AccountEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.service.ProductService;

/**
 *
 * @author AnhLe
 */
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String viewHome(Model model) {  
   
    	if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
    		AccountEntity user = (AccountEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		if (!ObjectUtils.isEmpty(user)) {
				model.addAttribute("username", user.getEmail());
			}
    	}
    	model.addAttribute("topselling1", productService.getRandomProductLimit(0, 4));
    	model.addAttribute("topselling2", productService.getRandomProductLimit(1, 5));
    	model.addAttribute("newproducts", productService.getNewProducts());
    	ProductEntity a = new ProductEntity();
        return "home";
    }

    @RequestMapping("/login")
    public String viewLogin(Model model,
            @RequestParam(value = "isError", required = false) 
                    boolean isError) {
        if (isError) {
            model.addAttribute("message", "login fail.");
        }
           return "login";
    }
    @RequestMapping(value = "/product-detail", method = RequestMethod.GET)
    public String viewProductDetails() {
    	return "product";
    }
}
