package test.spring.model;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {
	@NotEmpty(message = "{name.not.empty}")
	private String name;
	
	@Range(min = 10, max = 150, message = "{age.not.inrange}")
	private int age;
	
	@DateTimeFormat(pattern="yy-MM-dd HH:mm")
	private Date date;
	
	
	private boolean sex;
	private List<String> roles;  
	   
    public List<String> getRoles() {  
       return roles;  
    }  
   
    public void setRoles(List<String> roles) {  
       this.roles = roles;  
    }  
	

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
