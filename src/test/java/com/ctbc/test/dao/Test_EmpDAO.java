package com.ctbc.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.model.dao.EmpDAO;
import com.ctbc.model.vo.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class Test_EmpDAO {

	@Autowired
	private EmpDAO empDao;
	
	@Test
//	@Ignore
	public void test_001() throws SQLException {
		System.out.println("================== 【START test_001】 ====================");
		EmpVO empVO = empDao.getEmpById(7001);
		System.out.println(empVO);
		Assert.assertNotNull("查無empVO資料", empVO);
	}

	@Test
//	@Ignore
	public void test_002() throws SQLException {
		System.out.println("================== 【START test_002】 ====================");
		List<EmpVO> eList = empDao.getAllEmp();
		for (EmpVO empVO : eList) {
			System.out.println(empVO);
		}
	}

}
