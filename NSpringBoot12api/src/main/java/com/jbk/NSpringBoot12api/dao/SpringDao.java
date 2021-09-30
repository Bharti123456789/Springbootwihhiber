package com.jbk.NSpringBoot12api.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.NSpringBoot12api.entity.Admin;
import com.jbk.NSpringBoot12api.entity.Country;
import com.jbk.NSpringBoot12api.entity.Employee;


@Repository
public class SpringDao {
	@Autowired
	SessionFactory sessionfactory;
	
	//Admin Registration
public String AdminRegistration(Admin admin) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(admin);
		transaction.commit();
		System.out.println(admin.getName()+"");
		return "Register successfully!";
	}
public List<Admin> getAlladminlist() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Admin.class);
		List<Admin> list=(List<Admin>)criteria.list();
		System.out.println(list);
		return list;
	}
	
//login api	
	
public Admin CheckLogin(Admin admin) {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("emailid", admin.getEmailid()));
		criteria.add(Restrictions.eq("password", admin.getPassword()));
		
		Admin user=(Admin) criteria.uniqueResult();
		System.out.println("user---"+user);
		
			return  user;
		}
		
	
	
//API1 Show all employee
	public List<Employee> getAllemployee() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> listemp=( List<Employee>)criteria.list();

		System.out.println(listemp);
		return listemp;
}
	
//Api 2...get all employee by name 
			public List<Employee> getemployeetablebyname(String name) {
				
				
				Session session=sessionfactory.openSession();
				session.beginTransaction();
				Criteria criteria=session.createCriteria(Employee.class);
				criteria.add(Restrictions.eq("name", name));
				
				List<Employee> listemp=criteria.list();
				
				System.out.println(listemp);
				
				return listemp;
				
			}
			
//api3... getemployee by id
			
			public List<Employee> getemployeetablebyid(int id) {
				
				Session session=sessionfactory.openSession();
				session.beginTransaction();
				Criteria criteria=session.createCriteria(Employee.class);
				criteria.add(Restrictions.eq("id", id));
				List<Employee> listemp=criteria.list();
				return listemp;
			}
			
//api 4 ...getemployee by status active & inactive

			public List<Employee> getemployeetablebystatus(String status) {
				Session session=sessionfactory.openSession();
				session.beginTransaction();
				Criteria criteria=session.createCriteria(Employee.class);
				criteria.add(Restrictions.eq("status", status));
				List<Employee> listemp=criteria.list();
				return listemp;
			}
			
//api 5.... add employee

			public String addemployee(Employee emptable) {
				System.out.println("addemployeetable");
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				Country ctr=new Country();
				ctr.setCid(emptable.getCountry().getCid());
				ctr.setCname(emptable.getCountry().getCname());
				
				Employee emp=new Employee();
				emp.setId(emptable.getId());
				emp.setName(emptable.getName());
				emp.setPhoneno(emptable.getPhoneno());
				emp.setStatus(emptable.getStatus());
				emp.setDepartmentit(emptable.getDepartmentit());
				emp.setCreatedby(emptable.getCreatedby());
				emp.setCreateddtm(emptable.getCreateddtm());
				emp.setUpdatedby(emptable.getUpdatedby());
				emp.setUpdateddtm(emptable.getUpdateddtm());
				emp.setCountry(ctr);
				session.save(emp);
				
				transaction.commit();
				
				System.out.println(emp);
				
				return "Employee inserted successfully"; 
			}
			
		
//api 6 add country
			public String addCountry(Country country) {
	       System.out.println("Add country method");
				System.out.println(country);
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				System.out.println(country.getCid());
				System.out.println(country.getCname());
				
				//String cname=country.getCname();

				Country country1=new Country();
				country1.setCname(country.getCname());
				//country1.setCid(country.getCid());
				session.save(country1);
				transaction.commit();
				System.out.println("Data inserted successfully!");
				return "Data inserted successfully!";
				
				
			}
			
		
					
			
//api 7... update country
			public String updateCountry(Country country) {
				
				System.out.println("connection by controller");
				Session session=sessionfactory.openSession();
				Transaction tr= session.beginTransaction();
				
				//update Country set cname='China' where cid=3;
				Query query = session.createQuery("update Country set cname=:name where cid=:id");
				query.setParameter("name", country.getCname());
				query.setParameter("id", country.getCid());
				query.executeUpdate();
				tr.commit();
				System.out.println("record updated");
				return "Country Updated Successfully!";
			}
			
//api 8..... delete country by cname

			public String updateCountry(String cname) {
				
				System.out.println(cname);
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				Country country=new Country();
				country=session.get(Country.class,cname);
			
				session.delete(country);
				transaction.commit();
				return "Country deleted successfully!";
				}

//api 9.... delete employee by id
			     public String deleteemployeetablebyid(int id) {
	              Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query query=session.createQuery("delete from Employee where id=:id ");
				query.setParameter("id", id);
				int i=query.executeUpdate();
				transaction.commit();
				return "employee deleted successfully!";
				}
			
//api 10 ..delete country by cid
	            public String deletecountrybyid(int cid) {
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				Query query=session.createQuery("delete from Country where cid=:cid ");
				query.setParameter("cid", cid);
				int i=query.executeUpdate();
				transaction.commit();
				
				return "country deleted successfully!";
				
				
			}

//api 11... get country by id
			public List<Country> getCountrybyid(int id) {
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				Criteria criteria=session.createCriteria(Country.class);
				criteria.add(Restrictions.eq("cid", id));
				List<Country> listcountry=criteria.list();
				transaction.commit();
				System.out.println("Data retrieved successfully!"+listcountry);
				return listcountry;
				
			}
			
			//API12 Show all Country
			public List<Country> getAllcountry() {
				Session session=sessionfactory.openSession();
				session.beginTransaction();
				Criteria criteria=session.createCriteria(Country.class);
				List<Country> list=( List<Country>)criteria.list();

				System.out.println(list);
				return list;
		}
			
			
	//Update Employee data		
			public String updateemployee(Employee emp) {
				Session session=sessionfactory.openSession();
				Transaction tr= session.beginTransaction();
				session.update(emp);
				tr.commit();
				System.out.println("record updated");
				return "Employee Updated Successfully!";
			}
			
			
	//Suspend ststus api
			
			public String employeestatussusend(int id) {
				Session session=sessionfactory.openSession();
				Transaction transaction=session.beginTransaction();
				String status="suspend";
				Query query=session.createQuery("Update Employee SET status=:status WHERE id IN (:id)");
				query.setParameter("status", status);
				query.setParameter("id", id);
				query.executeUpdate();
				transaction.commit();
				return "Suspend Employee Successfully";
			}
			
			
			public String getstatus(int id) {
				Session session=sessionfactory.openSession();
				Criteria criteria=session.createCriteria(Employee.class);
				criteria.add(Restrictions.eq("id", id));
				Employee employee=(Employee)criteria.uniqueResult();
				return employee.getStatus();
			}
			
			
			public String Changestatus(int id,String status) {
				Session session=sessionfactory.openSession();
				Criteria criteria=session.createCriteria(Employee.class);
				Transaction transaction=session.beginTransaction();
				
				if(status.equalsIgnoreCase("Active")) {
				Query query=session.createQuery("Update Employee SET status=:status WHERE id IN (:id)");
				query.setParameter("status", "Inactive");
				query.setParameter("id", id);
				query.executeUpdate();
				transaction.commit();
				
			}
			else {
				Query query=session.createQuery("Update Employee SET status=:status WHERE id IN (:id)");
				query.setParameter("status", "Active");
				query.setParameter("id", id);
				query.executeUpdate();
				transaction.commit();
				}
			     return "Employee Status is Changed";
				}
		
			

	
	
	

	}




