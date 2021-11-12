package com.issa;

public abstract class User {

	public String username;
	public String password;
	public String firstname;
	public String lastname;
	public String email;
	public int age;
	public String phone;
	public String gender;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {

		return age;
	}

	protected String getAgeString() {

		if (age < 10) {

			return "00" + age;
		} else if (age < 100) {
			return "0" + age;
		} else {
			return "" + age;
		}
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return "User";
	}

	public abstract Boolean Login(String username, String password);

	public abstract String Register();

	protected boolean checkPassword(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetterOrDigit(s.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

}
