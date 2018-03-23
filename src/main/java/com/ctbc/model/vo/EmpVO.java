package com.ctbc.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "EmpVO")
//@Table(name = "emp_TB15")
@Table(name = "z40180_empTB") // For ITOA
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

	@Column(name = "deptno", nullable = false)
	private Integer deptno;

	public EmpVO() {
		super();
	}

	public EmpVO(String empName, String empJob, Date empHiredate, int deptno) {
		this.empName = empName;
		this.empJob = empJob;
		this.empHiredate = empHiredate;
		this.deptno = deptno;
	}

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

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		boolean outputTransients = false;
		boolean outputStatics = false;
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE, outputTransients, outputStatics);
	}

}
