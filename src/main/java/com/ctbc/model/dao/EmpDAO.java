package com.ctbc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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

	
	
}
