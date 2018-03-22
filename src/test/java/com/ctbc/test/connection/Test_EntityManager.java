package com.ctbc.test.connection;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.model.vo.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class Test_EntityManager {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;

	@Test
	@Ignore
	public void test_001() throws SQLException {
		// 測試連線是否成功
		org.hibernate.engine.spi.SessionImplementor sessionImp = (org.hibernate.engine.spi.SessionImplementor) em.getDelegate();
		JdbcConnectionAccess jdbcConnectionAccess = sessionImp.getJdbcConnectionAccess();
		Connection conn = jdbcConnectionAccess.obtainConnection();
		System.out.println(conn.getMetaData().getDatabaseProductName());
		assertEquals("Microsoft SQL Server", conn.getMetaData().getDatabaseProductName());
	}

	@Test
//	@Ignore
	public void test_002() throws SQLException {
		EmpVO vo = em.find(EmpVO.class, 7001);
		System.out.println(vo);
		Assert.assertNotNull(vo);
	}

}
