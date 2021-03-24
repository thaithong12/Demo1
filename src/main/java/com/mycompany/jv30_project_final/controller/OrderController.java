package com.mycompany.jv30_project_final.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.jv30_project_final.entities.AccountEntity;
import com.mycompany.jv30_project_final.entities.CreditCardEntity;
import com.mycompany.jv30_project_final.entities.OrderDetailEntity;
import com.mycompany.jv30_project_final.entities.OrderEntity;
import com.mycompany.jv30_project_final.entities.PaymentEntity;
import com.mycompany.jv30_project_final.enums.OrderStatus;
import com.mycompany.jv30_project_final.enums.PaymentStatus;
import com.mycompany.jv30_project_final.model.AccountInfoModel;
import com.mycompany.jv30_project_final.model.ProductModel;
import com.mycompany.jv30_project_final.service.AccountService;
import com.mycompany.jv30_project_final.service.CreditCardService;
import com.mycompany.jv30_project_final.service.OrderService;
import com.mycompany.jv30_project_final.service.PaymentService;
import com.mycompany.jv30_project_final.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/confirmation", method = RequestMethod.POST)
	public String viewCheckOut(@ModelAttribute("accountInfo") AccountInfoModel accountInfo ,Model model, HttpSession sessio) {
		if(sessio.getAttribute("accountInfo") == null)
			sessio.setAttribute("accountInfo", accountInfo);
		model.addAttribute("cardModel", new CreditCardEntity());
		return "payment";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String handlePayment( @ModelAttribute("cardModel")  @Valid CreditCardEntity creditCardEntity ,BindingResult binding, Model model, HttpSession sessio) {
		if (binding.hasErrors()) {
			model.addAttribute("messages", "Input Error");
			model.addAttribute("cardModel", new CreditCardEntity());
			return "payment";
		}
		CreditCardEntity cardEntity = creditCardService.findByCardNumber(creditCardEntity.getCardNumber());
		OrderEntity orderEntity = new OrderEntity();
		PaymentEntity paymentEntity = new PaymentEntity();		
		List<OrderDetailEntity> orderDetailEntities = new ArrayList<OrderDetailEntity>();
		List<PaymentEntity> paymentEntities = new ArrayList<PaymentEntity>();
		try {
			AccountInfoModel accountInfoModel = (AccountInfoModel) sessio.getAttribute("accountInfo");
			List<ProductModel> carts = (List<ProductModel>) sessio.getAttribute("cart");
			if (!ObjectUtils.isEmpty(cardEntity)) {
				if (cardEntity.getCvcCode().equals(creditCardEntity.getCvcCode())
						&& cardEntity.getName().equals(creditCardEntity.getName())) {
					double total = 0 ;
					for(ProductModel p : carts)
						total += p.getPrice() * p.getQuantity();
					if (cardEntity.getBalance() >= total) {
						// payment
						paymentEntity.setAmount(total);
						paymentEntity.setPaymentDate(new Date());
						paymentEntity.setStatusPayment(PaymentStatus.COMPLETED);
						paymentEntity.setCreditCardEntity(cardEntity);
											
						// order
						orderEntity.setDateOfPurchse(new Date());
						orderEntity.setOrderStatus(OrderStatus.COMPLETE);
						orderEntity.setTotal(total);
					
						// payment 
						paymentEntity.setOrderEntity(orderEntity);
						paymentEntities.add(paymentEntity);
						
						// order detail
						OrderDetailEntity o;
						for(ProductModel p : carts) {
							o  = new OrderDetailEntity();
							o.setQuantity(p.getQuantity());
							o.setPrice(p.getPrice());
							o.setProductEntity(productService.getProductById(p.getProductId()));
							o.setOrderEntity(orderEntity);
							orderDetailEntities.add(o);
						}
						
						//order
						orderEntity.setOrderDetailEntities(orderDetailEntities);
						orderEntity.setPaymentEntities(paymentEntities);
						
						// account
						AccountEntity  accountEntity = accountService.findByEmail(accountInfoModel.getEmail());
						accountEntity.setAddress(accountInfoModel.getAddress());
						accountEntity.setPhone(accountInfoModel.getPhone());
						accountEntity.setName(accountInfoModel.getName());
						
						// order
						orderEntity.setAccountEntity(accountEntity);
						
						
						// cap nhat thong tin
						accountService.saveAccountEntity(accountEntity);
						
						// save Order 
						orderService.saveOrder(orderEntity);
						
						// tru tien
						cardEntity.setBalance(cardEntity.getBalance() - total);
						creditCardService.saveCreditCard(cardEntity);
						
						// remove session gio hang / info 
						sessio.removeAttribute("cart");
						sessio.removeAttribute("accountInfo");
						
					} else {
						model.addAttribute("messages", "Khong du tien trong tai khoan, de nghi ban nap them");
					}
				} else {
					model.addAttribute("messages", "Thong tin khong dung");
				}
			} else {
				model.addAttribute("messages", "The Khong ton tai");
			}
			
		} catch (Exception e) {
			return "error";
		}
		return "redirect:/home";
	}

}
