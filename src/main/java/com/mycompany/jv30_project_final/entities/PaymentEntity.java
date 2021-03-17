package com.mycompany.jv30_project_final.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.mycompany.jv30_project_final.enums.PaymentStatus;

@Entity
@Table(name = "payment")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double amount;

	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paymentDate;

	@ManyToOne
	@JoinColumn(name = "order_payment_id")
	private OrderEntity orderEntity;

	@ManyToOne
	@JoinColumn(name = "credit_card_id")
	private CreditCardEntity creditCardEntity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_payment")
	private PaymentStatus statusPayment = PaymentStatus.UNPAID;

	public PaymentEntity() {
		super();
	}

	public PaymentEntity(int id, double amount, Date paymentDate, OrderEntity orderEntity,
			CreditCardEntity creditCardEntity, PaymentStatus statusPayment) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.orderEntity = orderEntity;
		this.creditCardEntity = creditCardEntity;
		this.statusPayment = statusPayment;
	}

	public PaymentEntity(double amount, Date paymentDate, OrderEntity orderEntity, CreditCardEntity creditCardEntity,
			PaymentStatus statusPayment) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.orderEntity = orderEntity;
		this.creditCardEntity = creditCardEntity;
		this.statusPayment = statusPayment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public CreditCardEntity getCreditCardEntity() {
		return creditCardEntity;
	}

	public void setCreditCardEntity(CreditCardEntity creditCardEntity) {
		this.creditCardEntity = creditCardEntity;
	}

	public PaymentStatus getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(PaymentStatus statusPayment) {
		this.statusPayment = statusPayment;
	}

}
