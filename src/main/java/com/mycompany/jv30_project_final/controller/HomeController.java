/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv30_project_final.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.jv30_project_final.entities.AccountEntity;
import com.mycompany.jv30_project_final.entities.CategoryEntity;
import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.entities.CommentEntity;
import com.mycompany.jv30_project_final.entities.ProductColorEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.entities.VoteEntity;
import com.mycompany.jv30_project_final.model.AccountInfoModel;
import com.mycompany.jv30_project_final.model.ProductModel;
import com.mycompany.jv30_project_final.service.CategoryService;
import com.mycompany.jv30_project_final.service.CommentService;
import com.mycompany.jv30_project_final.service.ProductColorService;
import com.mycompany.jv30_project_final.service.ProductService;
import com.mycompany.jv30_project_final.service.VoteService;

/**
 *
 * @author AnhLe
 */
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductColorService productColorService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String viewHome(Model model) {

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			AccountEntity user = (AccountEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (!ObjectUtils.isEmpty(user)) {
				model.addAttribute("username", user.getEmail());
			}
		}
		model.addAttribute("topselling", productService.getTopSellingProducts());
		model.addAttribute("topselling1", productService.getRandomProductLimit(0, 4));
		model.addAttribute("topselling2", productService.getRandomProductLimit(1, 5));
		model.addAttribute("newproducts", productService.getNewProducts());

		return "home";
	}

	@RequestMapping("/login")
	public String viewLogin(Model model, @RequestParam(value = "isError", required = false) boolean isError) {
		if (isError) {
			model.addAttribute("message", "login fail.");
		}
		return "login";
	}

	@RequestMapping(value = { "/product-detail" }, method = RequestMethod.GET)
	public String wiewProduct(Model model, @RequestParam("id") int id) {

		ProductEntity product = productService.getProductById(id);

		List<VoteEntity> voteEntities = voteService.findByProductEntity(product);
		List<CommentEntity> commentEntities = commentService.findByProductEntity(product);
		List<ProductColorEntity> colorProductEntities = productColorService.findByProductEntity(product);
		List<ColorEntity> colorEntities = new ArrayList<ColorEntity>();

		if (!CollectionUtils.isEmpty(voteEntities))
			model.addAttribute("votes", voteEntities);
		if (!CollectionUtils.isEmpty(commentEntities))
			model.addAttribute("comments", commentEntities);

		if (!CollectionUtils.isEmpty(colorProductEntities))
			for (ProductColorEntity p : colorProductEntities)
				colorEntities.add(p.getColorEntity());
		model.addAttribute("colors", colorEntities);
		model.addAttribute("product", product);
		return "product-detail";
	}

	@RequestMapping(value = { "/store" }, method = RequestMethod.GET)
	public String viewStore(Model model) {
		List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
		List<ProductEntity> productEntities = productService.getAllProducts();

		if (!CollectionUtils.isEmpty(productEntities))
			model.addAttribute("products", productEntities);
		if (!CollectionUtils.isEmpty(categoryEntities)) {
			model.addAttribute("categories", categoryEntities);
		}

		return "store";
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String viewSearchProduct(Model model, @RequestParam("search") String search) {
		List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
		List<ProductEntity> productEntities = categoryService.getListProductByCategoryName(search);

		if (!CollectionUtils.isEmpty(productEntities))
			model.addAttribute("products", productEntities);
		if (!CollectionUtils.isEmpty(categoryEntities)) {
			model.addAttribute("categories", categoryEntities);
		}

		return "store";
	}

	@RequestMapping(value = "/store-detail", method = RequestMethod.GET)
	public String viewDetailsCategory(@RequestParam("id") int id, Model model) {
		List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
		CategoryEntity categoryEntity = categoryService.findOne(id);
		List<ProductEntity> productEntities = productService.findByCategoryEntity(categoryEntity);

		if (!CollectionUtils.isEmpty(productEntities))
			model.addAttribute("products", productEntities);
		if (!CollectionUtils.isEmpty(categoryEntities)) {
			model.addAttribute("categories", categoryEntities);
		}
		return "store";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String viewCheckOut(Model model, HttpSession session) {
		AccountEntity user = (AccountEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ProductModel> carts = (List<ProductModel>) session.getAttribute("cart");
		if (!CollectionUtils.isEmpty(carts)) {
			model.addAttribute("ghs", carts);
			double total = 0;
			for (ProductModel p : carts) {
				total += p.getPrice() * p.getQuantity();
			}
			AccountInfoModel p =  new AccountInfoModel(user.getEmail(), user.getAddress(), user.getName(), user.getPhone());
			model.addAttribute("accountInfo",p);
			model.addAttribute("total", total);
		} else {
			return "redirect:/home";
		}
		return "check_out";
	}

	@RequestMapping(value = "/delete-cart", method = RequestMethod.GET)
	public String viewCheckOut(Model model, HttpSession session, @RequestParam("pId") int pId,
			@RequestParam("cId") int cId) {

		
		final int productId = pId;
		final int colorId = cId;
		List<ProductModel> carts = (List<ProductModel>) session.getAttribute("cart");
		if (!CollectionUtils.isEmpty(carts)) {
			ProductModel p = carts.stream()
					.filter(item -> item.getColorId() == colorId && productId == item.getProductId()).findFirst()
					.orElse(null);
			if (!ObjectUtils.isEmpty(p)) {
				carts.remove(p);
			}
			if (carts.size() == 0) {
				session.removeAttribute("cart");
			}

		} else {
			return "redirect:/home";
		}
		return viewCheckOut(model, session);
	}

}
