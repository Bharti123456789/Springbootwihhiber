package com.jbk.NSpringBoot12api.entity;
// Generated 31 Oct, 2020 2:34:30 AM by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "sbootapi")
public class Employee implements java.io.Serializable {

	private Integer id;
	private Country country;
	private String name;
	private String phoneno;
	private String departmentit;
	private String status;
	private String createddtm;
	private String updateddtm;
	private String updatedby;

	public Employee() {
	}

	public Employee(Country country, String name, String phoneno, String departmentit, String status, String createddtm,
			String updateddtm, String updatedby) {
		this.country = country;
		this.name = name;
		this.phoneno = phoneno;
		this.departmentit = departmentit;
		this.status = status;
		this.createddtm = createddtm;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneno", nullable = false, length = 45)
	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Column(name = "departmentit", nullable = false, length = 45)
	public String getDepartmentit() {
		return this.departmentit;
	}

	public void setDepartmentit(String departmentit) {
		this.departmentit = departmentit;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "createddtm", nullable = false, length = 45)
	public String getCreateddtm() {
		return this.createddtm;
	}

	public void setCreateddtm(String createddtm) {
		this.createddtm = createddtm;
	}

	@Column(name = "updateddtm", nullable = false, length = 45)
	public String getUpdateddtm() {
		return this.updateddtm;
	}

	public void setUpdateddtm(String updateddtm) {
		this.updateddtm = updateddtm;
	}

	@Column(name = "updatedby", nullable = false, length = 45)
	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

}
