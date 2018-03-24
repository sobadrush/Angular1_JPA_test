package com.ctbc.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "EmpVO")
//@Table(name = "z40180_empTB") // For ITOA
@Table(name = "emp_TB15")// For ITOA
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id") // 在JSON中給一個屬性，KEY叫作 @id，當作識別碼，解決雙向關係時JSON死循環的問題
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empNo") // jackson 2.0+ 版本新注解，作用于类或属性上，被用来在序列化/反序列化时为该对象或字段添加一个对象识别码，通常是用来解决循环嵌套的问题
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

	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
	@Column(name = "hiredate", nullable = false)
	private java.sql.Date empHiredate;

	@ManyToOne(targetEntity = DeptVO.class, fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "deptno")
	private DeptVO deptVOGG;

	public EmpVO() {
		super();
	}

	public EmpVO(String empName, String empJob, Date empHiredate, DeptVO deptVOGG) {
		this.empName = empName;
		this.empJob = empJob;
		this.empHiredate = empHiredate;
		this.deptVOGG = deptVOGG;
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

	public DeptVO getDeptVOGG() {
		return deptVOGG;
	}

	public void setDeptVOGG(DeptVO deptVOGG) {
		this.deptVOGG = deptVOGG;
	}

	/**
	 * 用 ReflectionToStringBuilder 的話，print時會"用到"另一方，造成每次都EAGER查詢
	 */
//	@Override
//	public String toString() {
//		boolean outputTransients = false;
//		boolean outputStatics = false;
//		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE, outputTransients, outputStatics);
//	}

	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", empName=" + empName + ", empJob=" + empJob + ", empHiredate=" + empHiredate + "]";
	}

}
