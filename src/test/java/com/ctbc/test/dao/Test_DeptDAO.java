package com.ctbc.test.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.model.dao.DeptDAO;
import com.ctbc.model.vo.DeptVO;
import com.ctbc.model.vo.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
//@ActiveProfiles(value = "CTBC")
@ActiveProfiles(value = "HOME")
public class Test_DeptDAO {

	@Autowired
	private DeptDAO deptDao;

	@Test
//	@Ignore
	@Transactional(propagation = Propagation.SUPPORTS) //  (1) 支援現在的交易，如果沒有的話就以非交易的方式執行(延長session)
									                    //  (2) 為了解決junit test中解决 could not initialize proxy - no Session
	public void test_001() throws SQLException {
		System.out.println("================== 【START test_001】查一筆 ====================");
		DeptVO deptVO = deptDao.getDeptById(10);
		System.out.println(" >>>>>>>>>>>>> " + deptVO);
		
		Set<EmpVO> empSet = deptVO.getEmps();
		for (EmpVO empVO : empSet) {
			System.out.println(" →→→ " + empVO);
		}
		
		Assert.assertNotNull("查無DeptVO資料", deptVO);
	}

	@Test
//	@Ignore
	public void test_002() throws SQLException {
		System.out.println("================== 【START test_002】新增一筆 ====================");
		DeptVO deptVO = new DeptVO("@@個金部@@", "@@台北南港@@");
		System.out.println(deptDao.addDept(deptVO));
	}

	@Test
//	@Ignore
	public void test_003() throws SQLException {
		System.out.println("==================【START test_003】刪除一筆 ====================");
		System.out.println(deptDao.deleteDeptById(40));
	}

	@Test
//	@Ignore
	public void test_004() throws SQLException {
		System.out.println("================== 【START test_004】修改一筆 ====================");
		DeptVO deptVO = new DeptVO(10, "@@@國防部@@@", "@@@中正區@@@");
		System.out.println(deptDao.updateDept(deptVO));
	}
	
	@Test
//	@Ignore
	@Transactional(propagation = Propagation.SUPPORTS) //  (1) 支援現在的交易，如果沒有的話就以非交易的方式執行(延長session)
                                                         //  (2) 為了解決junit test中解决 could not initialize proxy - no Session
	public void test_005() throws SQLException {
		System.out.println("================== 【START test_005】查全部 ====================");
		List<DeptVO> dList = deptDao.getAllDept();
		for (DeptVO deptVO : dList) {
			System.err.println(deptVO);
			
			// 查部門下的員工
			Set<EmpVO> empSet = deptVO.getEmps();
			for (EmpVO empVO : empSet) {
				System.out.println(" →→→ " + empVO);
			}
		}
	}

}
