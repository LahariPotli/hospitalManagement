package com.demo.hospitalManagement.dto;

public class UserDto {
		private String userName;
	    private String password;
	    private String mobileNumber;
	    private String location;
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
	    public String getMobileNumber() {
	        return mobileNumber;
	    }
	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
	    
	}