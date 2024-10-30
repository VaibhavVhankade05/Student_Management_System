	package com.system.management.student.entity;
	
	import jakarta.persistence.*;
	
	@Entity
	@Table(name="Student_Detail")
	public class Student 
	{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		private String email;
		private String position;
		private String contact_no;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getContact_no() {
			return contact_no;
		}
		public void setContact_no(String contact_no) {
			this.contact_no = contact_no;
		}
	
	}
