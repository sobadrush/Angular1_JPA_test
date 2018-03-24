package com.ctbc.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctbc.model.dao.DeptDAO;
import com.ctbc.model.dao.EmpDAO;
import com.ctbc.model.vo.DeptVO;
import com.ctbc.model.vo.EmpVO;

@Controller
@Scope("prototype")
@RequestMapping("/QueryController")
public class QueryController {
	
	private static final String JSON_FORMAT = "application/json; charset=utf-8";
	
	@Autowired
	private DeptDAO deptDAO;
	
	@Autowired
	private EmpDAO empDAO;
	
	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllDepts
	 */
	@RequestMapping(value = "/query/getAllDepts", method = RequestMethod.GET , produces= JSON_FORMAT )
	public String getAllDepts() {
		System.out.println(" >>>>>>>> getAllDepts() <<<<<<<<<<< ");
		
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
		
		return "result";
	}
	
	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/QueryController/query/getAllemps
	 */
	@RequestMapping(value = "/query/getAllemps", method = RequestMethod.GET , produces= JSON_FORMAT )
	public String getAllemps() {
		System.out.println(" >>>>>>>> getAllemps() <<<<<<<<<<< ");
		
		List<EmpVO> eList = this.empDAO.getAllEmp();
		for (EmpVO empVO : eList) {
			DeptVO deptVO = empVO.getDeptVOGG();
			System.out.println(empVO + " >>>> 所屬部門 >>>> " + deptVO);
		}
		
		return "result";
	}
	
}
