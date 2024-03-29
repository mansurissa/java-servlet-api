package com.issa;

public class Admin extends User {

	@Override
	public String getRole() {

		return "Admin";
	}

	@Override
	public String Register() {

		if (!this.checkPassword(this.password) && this.password.length() != 10) {

			return "Password rule not met";

		}

		if (!VolatileDB.database.containsKey(this.username)) {

			String passwordEncrypted = "";

			for (int i = this.password.length(); i > 0; i--) {

				passwordEncrypted += this.password.substring(i - 1, i);
			}

			passwordEncrypted += this.getAgeString();
			passwordEncrypted = "**" + passwordEncrypted + "**";

			this.setPassword(passwordEncrypted);

			VolatileDB.insert(this.username, this);

			return "Registered Successfully";
		}
		return "User already exists";
	}

	@Override
	public Boolean Login(String username, String password) {

		if (VolatileDB.database.containsKey(username)) {

			User user = VolatileDB.fetch(username);

			String passwordEncrypted = user.getPassword();

			passwordEncrypted = passwordEncrypted.substring(2, passwordEncrypted.length() - 5);

			String passwordDecrypted = "";

			for (int i = passwordEncrypted.length(); i > 0; i--) {

				passwordDecrypted += passwordEncrypted.substring(i - 1, i);
			}

			if (passwordDecrypted.equals(password)) {

				return true;

			}

		}
		return false;
	}

}
