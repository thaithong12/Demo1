package com.mycompany.jv30_project_final.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.entities.ProductColorEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.model.ProductColorModel;
import com.mycompany.jv30_project_final.model.ProductModel;
import com.mycompany.jv30_project_final.service.ColorService;
import com.mycompany.jv30_project_final.service.ProductColorService;
import com.mycompany.jv30_project_final.service.ProductService;

@Controller
@RequestMapping("api")
@SessionAttributes("cart")
public class ApiController {

	@Autowired
	private ProductColorService productColorService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ColorService colorService;

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/change-color", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProductColorModel> hanldeChangeColor(@RequestBody ProductColorModel productColorModel) {

		ProductEntity p = productService.getProductById(productColorModel.getProductId());

		ColorEntity c = colorService.findById(productColorModel.getColorId());
		
		ProductColorModel pModel = new ProductColorModel();

		if (!ObjectUtils.isEmpty(p) && !ObjectUtils.isEmpty(c)) {
			ProductColorEntity productColorEntity = productColorService.findByProductEntityAndColorEntity(p, c);
			if (!ObjectUtils.isEmpty(productColorEntity)) {
				pModel.setColorId(productColorEntity.getColorEntity().getId());
				pModel.setProductId(productColorEntity.getProductEntity().getId());
				pModel.setPrice(productColorEntity.getPrice());
				return new ResponseEntity<ProductColorModel>(HttpStatus.OK).ok(pModel);
			}
		}
		return new ResponseEntity<ProductColorModel>(HttpStatus.NO_CONTENT).ok(null);

	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/handle-add-cart", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProductModel> hanldeAddCart(@RequestBody ProductModel productModel, HttpSession session, Model model) {

		ProductEntity p = productService.getProductById(productModel.getProductId());

		ColorEntity c = colorService.findById(productModel.getColorId());
		
		ProductModel pModel = new ProductModel();
				
		
		if (!ObjectUtils.isEmpty(p) && !ObjectUtils.isEmpty(c)) {
			
			ProductColorEntity productColorEntity = productColorService.findByProductEntityAndColorEntity(p, c);			
			if (!ObjectUtils.isEmpty(productColorEntity)) {
				if (session.getAttribute("cart") == null) {
					List<ProductModel> carts = new ArrayList<ProductModel>(); 
					pModel.setColorId(productColorEntity.getColorEntity().getId());
					pModel.setProductId(productColorEntity.getProductEntity().getId());
					pModel.setPrice(productColorEntity.getPrice());
					pModel.setName(productColorEntity.getProductEntity().getName());
					pModel.setQuantity(1);
					pModel.setImage(productColorEntity.getProductEntity().getOneImage());
					carts.add(pModel);
					
					model.addAttribute("cart", carts);
				} else {
					List<ProductModel> carts = (List<ProductModel>) session.getAttribute("cart");
					if (!CollectionUtils.isEmpty(carts)) {
						int check = 0 ;
						for(ProductModel cart : carts) {
							if (cart.getProductId() ==  p.getId() && cart.getColorId() == c.getId()) {
								cart.setQuantity(cart.getQuantity() + 1);
								check = 1;
							}
						}
						if(check == 0) {
							pModel.setColorId(productColorEntity.getColorEntity().getId());
							pModel.setProductId(productColorEntity.getProductEntity().getId());
							pModel.setPrice(productColorEntity.getPrice());
							pModel.setName(productColorEntity.getProductEntity().getName());
							pModel.setQuantity(1);
							pModel.setImage(productColorEntity.getProductEntity().getOneImage());
							carts.add(pModel);
						}
						
					}
				}
				
				
				return new ResponseEntity<ProductColorModel>(HttpStatus.OK).ok(pModel);
			}
		}
		return new ResponseEntity<ProductModel>(HttpStatus.NO_CONTENT).ok(null);

	}
	
	
}
