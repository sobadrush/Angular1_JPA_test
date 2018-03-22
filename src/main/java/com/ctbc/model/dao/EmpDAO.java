package com.ctbc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.model.vo.EmpVO;

@Repository
public class EmpDAO {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;

	public EmpVO getEmpById(int empNo) {
		EmpVO empVO = em.find(EmpVO.class, empNo);
		return empVO;
	}

	public List<EmpVO> getAllEmp() {
		TypedQuery<EmpVO> query = em.createQuery("SELECT ee FROM EmpVO AS ee", EmpVO.class);
		List<EmpVO> eList = query.getResultList();
		return eList;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
	public int addEmp(EmpVO empVO) {
		em.persist(empVO);
		return 1;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
	public int deleteEmpById(int empNo) {
		EmpVO empVO = em.find(EmpVO.class, empNo);
		em.remove(empVO);
		return 1;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
	public EmpVO updateEmp(EmpVO empVO) {
		return em.merge(empVO);
	}
}
