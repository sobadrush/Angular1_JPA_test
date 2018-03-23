package com.ctbc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.model.vo.DeptVO;

@Repository
public class DeptDAO {
	
	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
	
	public List<DeptVO> getAllDept(){
		Query nativeQuery = em.createNativeQuery("SELECT * FROM dept_TB15", DeptVO.class);
		return nativeQuery.getResultList();
	}
	
	@Transactional
	public DeptVO getDeptById(int deptId){
	 	TypedQuery<DeptVO> query = em.createQuery("SELECT dd FROM DeptVO as dd WHERE dd.deptNo = :_deptNo ", DeptVO.class);
	 	query.setParameter("_deptNo", deptId);
	 	return query.getSingleResult();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
	public int addDept(DeptVO deptVO) {
		em.persist(deptVO);
		return 1;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
	public int updateDept(DeptVO deptVO) {
		DeptVO deptVoManaged = em.find(DeptVO.class, deptVO.getDeptNo());// 獲得管理狀態的deptVO
		deptVoManaged.setDeptName(deptVO.getDeptName());
		deptVoManaged.setDeptLoc(deptVO.getDeptLoc());
		return 1;
	}
	
}
