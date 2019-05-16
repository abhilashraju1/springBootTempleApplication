package com.example.demo.entity;

	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="REGISTERINFO")
	public class RegisterEntity implements Serializable{
		
		private static final long serialVersionUID = 6166096818461545091L;

		@Id
		@Column(name="USER_ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="USER_NAME")
		private String userName;
		
		@Column(name="PASSWORD")
		private String password;
		
		@Column(name="CONFIRM_PASSWORD")
		private String confirmPassword;
		
		@Column(name="EMAIL")
		private String email;
		
		@Column(name="PHONE_NUMBER")
		private Integer phoneNumber;


		public RegisterEntity() {
		
		}

		public RegisterEntity(Integer id, String userName, String password, String confirmPassword, String email, Integer phoneNumber ) {
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.confirmPassword = confirmPassword;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Integer phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	}
