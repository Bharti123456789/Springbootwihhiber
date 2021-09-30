package com.jbk.NSpringBoot12api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.NSpringBoot12api.entity.Admin;
import com.jbk.NSpringBoot12api.entity.Country;
import com.jbk.NSpringBoot12api.entity.Employee;
import com.jbk.NSpringBoot12api.service.SpringService;



@CrossOrigin
@RestController
public class SpringController {
	
	@Autowired
	SpringService springservice;
	
	@RequestMapping("/getstring")
	public String getstring() {
		return " Hellow Spring Boot Project";
		}
	@RequestMapping("/getArray")
	public ArrayList<String> getArray() {
		ArrayList<String> al=new ArrayList<>();
		al.add("ABC");
		al.add("PQR");
		al.add("GHJ");
		return al;
		}
	
//Admin Registration Api
	
	@PostMapping("/registeration")
	public String AdminRegistration(@RequestBody Admin admin){
		{
			System.out.println("username:-"+admin.getName());
			String msg=springservice.AdminRegistration(admin);
			return msg;
			}}
		
		@GetMapping("/getalladmin")
		public List<Admin> getAlladmin()
		{
			List<Admin> list=springservice.getAlladminlist();
			return list;
		}
		
//login api
		
		@RequestMapping(value="/logincheck", method=RequestMethod.POST)
		public HashMap CheckLogin(@RequestBody Admin admin){
		
			System.out.println("Emailid--"+admin.getEmailid()+"Password"+admin.getPassword());
			Admin user=springservice.CheckLogin(admin);
			System.out.println("controller user"+user);
			HashMap hm=new HashMap();
			if (user==null) {
				hm.put("msg","Invalid User");
			} else {
				user.setPassword("*******");
				hm.put("msg","Valid User");
				hm.put("userobj",user);
			}
		return hm;
		}
		
		
		
		
		
		
//API 1-- show list of employee	
	  @GetMapping("/getallemployee")
	  public List<Employee> getAllemployee()
	  {
		List<Employee> list=springservice.getAllemployee();
		return list;
	    }
	
//api2-- get all employee by name 
			 @GetMapping("/employeetablebyname/{name}")
			 public List<Employee> getemployeetablebyname(@PathVariable String name){
			List<Employee> listemp=springservice.getemployeetablebyname(name);
				return listemp;
				}
	
//api3-- all employee by id
				
				@GetMapping("/getemployeetablebyid/{id}")
				public List<Employee> getemployeetablebyid(@PathVariable("id") int id)
				{
					List<Employee> listemp=springservice.getemployeetablebyid(id);
					return listemp;
					}
				
//api 4--get employee by status
				@GetMapping("/getemployeetablebystatus/{status}")
				public List<Employee> getemployeetablebystatus(@PathVariable("status") String status)
				{
					List<Employee> listemp=springservice.getemployeetablebystatus(status);
					return listemp;
					}
				
				
//api 5-- add employee into table
				@PostMapping(value="/addemployeetable")
				public String addemployee(@RequestBody Employee emptable)
				{
					String msg=springservice.addemployee(emptable);
					return msg;
					}
				

				
//api 6 ...add country into table
			@PostMapping("/addcountry")
			public String addCountry(@RequestBody Country country)
			{
				String msg=springservice.addCountry(country);
				return msg;
				}
			
//api 7 ....update country name
			@PutMapping("/updatecountryname")
			public String updateCountry(@RequestBody Country country) {
				
				String msg=springservice.updateCountry(country);
				return msg;
			}
			
//api 8... delete country by name
			@RequestMapping(value="/deletecountrybyname/{cname}", method=RequestMethod.DELETE)
			public String deletecountrybyname(@PathVariable("cname") String cname)
			{

				String msg=springservice.updateCountry(cname);
				return msg;
				}
			
//api 9... delete employee by id
			@DeleteMapping("/deleteemployeetable/{id}")
			public String deleteemployeetablebyid(@PathVariable("id") int id)
			{
				String msg=springservice.deleteemployeetablebyid(id);
				return msg;
				}
			
			
//api 10.. delete country by id
			@RequestMapping(value="/deletecountrybyid/{cid}", method=RequestMethod.DELETE)
			public String deletecountrybyid(@PathVariable("cid") int cid)
			{
	           String msg=springservice.deletecountrybyid(cid);
				return msg;
				}
			
//api 11.. get country by id 
			@GetMapping("/getcountry/{id}")
			public List<Country> getCountrybyid(@PathVariable("id") int id)
			{
				List<Country> listcountry=springservice.getCountrybyid(id);
				return listcountry;
				}
//API 12-- show list of country	
			  @GetMapping("/getallcountry")
			  public List<Country> getAllcountry()
			  {
				List<Country> list=springservice.getAllcountry();
				return list;
			    }
// Update employee data
		 @PutMapping("/updateemployeedata")
				public String updateemployee(@RequestBody Employee emp) {
					
					String msg=springservice.updateemployee(emp);
					return msg;
				}	
//suspend status
		 @PutMapping("/employeestatussuspend/{id}")
		 public String employeestatussusend(@PathVariable int id){
			 String msg=springservice.employeestatussusend(id);
			 System.out.println(" controller employee suspended===="+msg);
			return "Suspend Successfully!";
			}
		 
		 
//Change Status 
		 @GetMapping("/Changeemployeestatus/{id}")
		 public String Changestatus(@PathVariable int id){
			 String msg1="Status Changed Successfully";
			 String msg2="Employee is Permanetly Suspended";
			 String status=springservice.getstatus(id);
			if(status.compareTo("Suspend")==0) {
			return msg2;
			}	else {
				String changestatus=springservice.Changestatus(id,status);
				return changestatus;
				}	 
			}
		 
			}	
			

	
	

	
	