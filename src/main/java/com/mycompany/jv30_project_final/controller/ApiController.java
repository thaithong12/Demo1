package com.mycompany.jv30_project_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.entities.ProductColorEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.model.ProductColorModel;
import com.mycompany.jv30_project_final.service.ColorService;
import com.mycompany.jv30_project_final.service.ProductColorService;
import com.mycompany.jv30_project_final.service.ProductService;

@Controller
@RequestMapping("api")
public class ApiController {

	@Autowired
	private ProductColorService productColorService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ColorService colorService;

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
}
