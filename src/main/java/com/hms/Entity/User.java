package com.hms.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="Registration")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	  @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer userId;
	
       @Column(length=30)
	  private String userName;
	
	    @Column(length=30)
	   private String password;

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Integer userId, String userName, String password) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
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
	    
}
