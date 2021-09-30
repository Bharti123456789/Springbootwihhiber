package com.jbk.NSpringBoot12api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.NSpringBoot12api.dao.SpringDao;
import com.jbk.NSpringBoot12api.entity.Admin;
import com.jbk.NSpringBoot12api.entity.Country;
import com.jbk.NSpringBoot12api.entity.Employee;


@Service
public class SpringService {
	@Autowired
	SpringDao springdao;
	//Admin Registration
	public String AdminRegistration(Admin admin) {
		String msg=springdao.AdminRegistration(admin);
		return msg;
	}
	public List<Admin> getAlladminlist() {
		List<Admin> list=springdao.getAlladminlist();
		return list;
		}
	//login check api
	public Admin CheckLogin(Admin admin) {
		Admin user=springdao.CheckLogin(admin);
		return user;
	}	

	
//API 1.... show list of employee
	   public List<Employee> getAllemployee() {
		List<Employee> emplist=springdao.getAllemployee();
		return emplist;
	}
	
//Api 2...get all employee by name
			public List<Employee> getemployeetablebyname(String name) {
			List<Employee> listemp=springdao.getemployeetablebyname(name);
				return listemp;
			}
//Api 3.....get all employee by id 
			public List<Employee> getemployeetablebyid(int id) {
				List<Employee> listemp=springdao.getemployeetablebyid(id);
				return listemp;
			}
			
//Api 4.... all employee by status 
			public List<Employee> getemployeetablebystatus(String status) {
				List<Employee> listemp=springdao.getemployeetablebystatus(status);
				return listemp;
			}
			
			
//Api 5....add employee 
			public String addemployee(Employee emptable) {
				String msg=springdao.addemployee(emptable);
				return msg;
			}
			
//API 6--Add country			
			public String addCountry(Country country) {
				String msg=springdao.addCountry(country);
				return msg;
			}	
			
			

// Api 7....update country
	public String updateCountry(Country country) {
		String msg=springdao.updateCountry(country);
		return msg;
	}

	
// Api 8....delete country by cname
	public String updateCountry(String cname) {
		String msg=springdao.updateCountry(cname);
		return msg;
	}

//Api 9....delete employee by id
	public String deleteemployeetablebyid(int id) {
		String msg=springdao.deleteemployeetablebyid(id);
		return msg;
	}

	
//Api 10....delete country by cid
	public String deletecountrybyid(int cid) {
		String msg=springdao.deletecountrybyid(cid);
		return msg;
	}

//api 11... get country by id
	public List<Country> getCountrybyid(int id) {
		List<Country> listcountry=springdao.getCountrybyid(id);
		
		return listcountry;
	}
	
	//API 12.... show list of Country
	   public List<Country> getAllcountry() {
		List<Country> list=springdao.getAllcountry();
		return list;
	}
//Update employee	   
	public String updateemployee(Employee emp) {
		String msg=springdao.updateemployee(emp);
		return msg;
	}
//Suspend status employee
	public String employeestatussusend(int id) {
		String msg=springdao.employeestatussusend(id);
		return msg;
	}
//Change status employee	
	
	public String Changestatus(int id,String status) {
		String changestatus=springdao.Changestatus(id,status);
		return changestatus;
	}
	public String getstatus(int id) {
		String status=springdao.getstatus(id);
		return status;
	}

	
	


	
	
	



	


}
