package com.ctbc.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.model.dao.DeptDAO;
import com.ctbc.model.dao.EmpDAO;
import com.ctbc.model.vo.DeptVO;
import com.ctbc.model.vo.EmpVO;
import com.google.gson.Gson;

@Controller
@Scope("prototype")
@RequestMapping("/QueryController")
public class QueryController {

	private static final String JSON_FORMAT = "application/json; charset=utf-8";

	@Autowired
	private Gson gson;

	@Autowired
	private DeptDAO deptDAO;

	@Autowired
	private EmpDAO empDAO;

	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllDepts
	 */
	@RequestMapping(value = "/query/getAllDepts", method = RequestMethod.GET, produces = JSON_FORMAT)
	@ResponseBody
	public List<DeptVO> getAllDepts() {
		System.out.println(" >>>>>>>>>>> getAllDepts() <<<<<<<<<<< ");

		List<DeptVO> dList = this.deptDAO.getAllDept();
		for (DeptVO deptVO : dList) {
			System.err.println(deptVO);

			// Lazy-loading isssue!!! 解決：配置OpenEntityManagerInViewFilter延長Session關閉時間
			// 查部門下的員工
			Set<EmpVO> empSet = deptVO.getEmps();
			for (EmpVO empVO : empSet) {
				System.out.println(" →→→ " + empVO);
			}
		}
		return dList;
	}
	
	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllDeptsByGson
	 */
	@RequestMapping(value = "/query/getAllDeptsByGson", method = RequestMethod.GET, produces = JSON_FORMAT)
	@ResponseBody
	public String getAllDeptsByGson() {
		System.out.println(" >>>>>>>>>>> getAllDeptsByGson() <<<<<<<<<<< ");
		
		List<DeptVO> dList = this.deptDAO.getAllDept();
		for (DeptVO deptVO : dList) {
			System.err.println(deptVO);
			// 查部門下的員工
			Set<EmpVO> empSet = deptVO.getEmps();
			for (EmpVO empVO : empSet) {
				empVO.setDeptVOGG(null);// ※※※※※ For Gson 問題：若兩物件彼此有交互參照，toJson()會失敗
//				empVO.getClass();// 手動Eager(因為前一行有"動過"empVO了，故已經達到手動Eager的效果了)
				System.out.println(" →→→ " + empVO);
			}
		}
		
		String jsonString = this.gson.toJson(dList);
		System.out.println("Gson to Json >>> " + jsonString);
		return jsonString;
	}

	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllemps
	 */
	@RequestMapping(value = "/query/getAllemps", method = RequestMethod.GET, produces = JSON_FORMAT)
	@ResponseBody
	public List<EmpVO> getAllemps() {
		System.out.println(" >>>>>>>>>>> getAllemps() <<<<<<<<<<< ");
		List<EmpVO> eList = this.empDAO.getAllEmp();
		for (EmpVO empVO : eList) {
			DeptVO deptVO = empVO.getDeptVOGG();
			System.out.println(empVO + " >>>> 所屬部門 >>>> " + deptVO);
		}
		return eList;
	}
	
	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllempsByGson
	 */
	@RequestMapping(value = "/query/getAllempsByGson", method = RequestMethod.GET, produces = JSON_FORMAT)
	@ResponseBody
	public String getAllempsByGson() {
		System.out.println(" >>>>>>>>>>> getAllemps() <<<<<<<<<<< ");
		List<EmpVO> eList = this.empDAO.getAllEmp();
		for (EmpVO empVO : eList) {
			DeptVO deptVO = empVO.getDeptVOGG();
			deptVO.setEmps(null);// ※※※※※ For Gson 問題：若兩物件彼此有交互參照，toJson()會失敗
			System.out.println(empVO + " >>>> 所屬部門 >>>> " + deptVO);
		}
		
		String jsonString = this.gson.toJson(eList);
		System.out.println("Gson to Json >>> " + jsonString);
		return jsonString;
	}

}
