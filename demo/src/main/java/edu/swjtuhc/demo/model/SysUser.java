package edu.swjtuhc.demo.model;

public class SysUser {
         private int UId;
         private String username;
         private String password;
         private String name;
         private int age;
         private String  gender;
		/**
		 * @return the uId
		 */
		public int getUId() {
			return UId;
		}
		/**
		 * @param uId the uId to set
		 */
		public void setUId(int uId) {
			UId = uId;
		}
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "SysUser [UId=" + UId + ", username=" + username + ", password=" + password + ", name=" + name
					+ ", age=" + age + ", gender=" + gender + ", getUId()=" + getUId() + ", getUsername()="
					+ getUsername() + ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getAge()="
					+ getAge() + ", getGender()=" + getGender() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	
         
	
}
