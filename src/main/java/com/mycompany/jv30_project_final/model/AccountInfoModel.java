package com.mycompany.jv30_project_final.model;

public class AccountInfoModel {


    private String email;
    private String name;
    private String address;
    private String phone;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    public AccountInfoModel() {
		// TODO Auto-generated constructor stub
	}
	public AccountInfoModel(String email, String name, String address, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
    
    

}
