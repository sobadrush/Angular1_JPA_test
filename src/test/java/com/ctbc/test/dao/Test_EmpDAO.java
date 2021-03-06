package com.ctbc.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.model.dao.EmpDAO;
import com.ctbc.model.vo.DeptVO;
import com.ctbc.model.vo.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
//@ActiveProfiles(value = "CTBC")
@ActiveProfiles(value = "HOME")
public class Test_EmpDAO {

	@Autowired
	private EmpDAO empDao;

	@Test
//	@Ignore
	public void test_001() throws SQLException {
		System.out.println("================== 【START test_001】查一筆 ====================");
		EmpVO empVO = empDao.getEmpById(7001);
		System.out.println(" >>> " + empVO);
		System.out.println(" >>> " + empVO.getDeptVOGG());
		Assert.assertNotNull("查無empVO資料", empVO);
	}

	@Test
//	@Ignore
	public void test_002() throws SQLException {
		System.out.println("================== 【START test_002】新增一筆 ====================");
		//---------------------------
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptNo(10);
		//---------------------------
		EmpVO empVO = new EmpVO("淑Z","氣象主播", java.sql.Date.valueOf("2018-05-10") , deptVO/*部門編號*/);
		System.out.println(empDao.addEmp(empVO));
	}
	
	@Test
//	@Ignore
	public void test_003() throws SQLException {
		System.out.println("================== 【START test_003】刪除一筆 ====================");
		System.out.println(empDao.deleteEmpById(7001));
	}
	
	@Test
//	@Ignore
	public void test_004() throws SQLException {
		System.out.println("================== 【START test_004】修改一筆 ====================");
		//---------------------------
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptNo(10);
		//---------------------------
		EmpVO empVO = new EmpVO("史提芬柯瑞","BOSS", java.sql.Date.valueOf("2018-09-27") , deptVO/*部門編號*/);
		empVO.setEmpNo(7002);
		System.out.println(empDao.updateEmp(empVO));
	}
	
	@Test
//	@Ignore
	public void test_005() throws SQLException {
		System.out.println("================== 【START test_005】查全部 ====================");
		List<EmpVO> eList = empDao.getAllEmp();
		for (EmpVO empVO : eList) {
			DeptVO deptVO = empVO.getDeptVOGG();
			System.out.println(empVO + " >>>> 所屬部門 >>>> " + deptVO);
		}
	}

}
