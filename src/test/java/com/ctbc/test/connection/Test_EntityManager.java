package com.ctbc.test.connection;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-beans.xml" })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class Test_EntityManager {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
//	@Ignore
	public void test_001() throws SQLException {
		// 測試連線是否成功
		org.hibernate.engine.spi.SessionImplementor sessionImp = 
			     (org.hibernate.engine.spi.SessionImplementor) entityManager.getDelegate();
		JdbcConnectionAccess jdbcConnectionAccess = sessionImp.getJdbcConnectionAccess();
		Connection conn = jdbcConnectionAccess.obtainConnection();
		System.out.println(conn.getMetaData().getDatabaseProductName());
		assertEquals("Microsoft SQL Server", conn.getMetaData().getDatabaseProductName());
	}

}
