package com.jbk.NSpringBoot12api.entity;
// Generated 31 Oct, 2020 2:34:30 AM by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "sbootapi")
public class Country implements java.io.Serializable {

	private Integer cid;
	private String cname;
	private Set employees = new HashSet(0);

	public Country() {
	}

	public Country(String cname) {
		this.cname = cname;
	}

	public Country(String cname, Set employees) {
		this.cname = cname;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "cname", nullable = false, length = 45)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}
