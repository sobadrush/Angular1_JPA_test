package com.ctbc.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "EmpVO")
@Table(name = "emp_TB15")
public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno", nullable = false)
	private Integer empNo;

	@Column(name = "ename", nullable = false)
	private String empName;

	@Column(name = "job", nullable = false)
	private String empJob;

	@Column(name = "hiredate", nullable = false)
	private java.sql.Date empHiredate;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public java.sql.Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(java.sql.Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", empName=" + empName + ", empJob=" + empJob + ", empHiredate=" + empHiredate + "]";
	}

}
