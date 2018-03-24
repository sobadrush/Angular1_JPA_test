package com.ctbc.model.vo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "DeptVO")
//@Table(name = "z40180_deptTB")// for ITOA
@Table(name = "dept_TB15") // HOME
public class DeptVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deptno", nullable = false)
	private Integer deptNo;

	@Column(name = "dname", nullable = false)
	private String deptName;

	@Column(name = "loc", nullable = false)
	private String deptLoc;

	@OneToMany(targetEntity = EmpVO.class, fetch = FetchType.LAZY, mappedBy = "deptVOGG",
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Set<EmpVO> emps;

	public DeptVO() {
		super();
	}

	public DeptVO(Integer deptNo, String deptName, String deptLoc) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public DeptVO(String deptName, String deptLoc) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Integer getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return this.deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public Set<EmpVO> getEmps() {
		return emps;
	}

	public void setEmps(Set<EmpVO> emps) {
		this.emps = emps;
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
		return "DeptVO [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
