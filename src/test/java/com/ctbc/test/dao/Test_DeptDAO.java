package com.ctbc.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.model.dao.DeptDAO;
import com.ctbc.model.vo.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@ActiveProfiles(value = "CTBC")
public class Test_DeptDAO {

	@Autowired
	private DeptDAO deptDao;
	
	@Test
//	@Ignore
	public void test_001() throws SQLException {
		System.out.println("================== 【START test_001】 ====================");
	}

	@Test
//	@Ignore
	public void test_002() throws SQLException {
		System.out.println("================== 【START test_002】 ====================");
	}
	
	@Test
//	@Ignore
	public void test_003() throws SQLException {
		System.out.println("================== 【START test_003】 ====================");
	}
	
	@Test
//	@Ignore
	public void test_004() throws SQLException {
		System.out.println("================== 【START test_004】 ====================");
		DeptVO DeptVO = deptDao.getDeptById(20);
		System.out.println(" >>> " + DeptVO);
	}
	
	@Test
//	@Ignore
	public void test_005() throws SQLException {
		System.out.println("================== 【START test_005】 ====================");
		List<DeptVO> dList = deptDao.getAllDept();
		for (DeptVO deptVO : dList) {
			System.out.println(deptVO);
		}
	}

}
