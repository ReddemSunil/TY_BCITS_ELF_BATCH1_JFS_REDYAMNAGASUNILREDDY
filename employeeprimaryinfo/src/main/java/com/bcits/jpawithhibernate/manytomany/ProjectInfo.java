package com.bcits.jpawithhibernate.manytomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="project_info")
public class ProjectInfo implements Serializable{
	@Id
	@Column
	private int pid;
	@Column
	private String projectName;
	@Column
	private String technology;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String location;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="emp_project",joinColumns = @JoinColumn(name="pid"),inverseJoinColumns = @JoinColumn(name="empid"))
	private List<EmployeePrimaryInfo> primaryInfo;
}
