package com.ctbc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ctbc.model.vo.DeptVO;

@Repository
public class DeptDAO {
	
	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
	
	public List<DeptVO> getAllDept(){
		Query nativeQuery = em.createNativeQuery("SELECT * FROM z40180_deptTB", DeptVO.class);
		return nativeQuery.getResultList();
	}
	
	public DeptVO getDeptById(int deptId){
	 	TypedQuery<DeptVO> query = em.createQuery("SELECT dd FROM DeptVO as dd WHERE dd.deptNo = :_deptNo ", DeptVO.class);
	 	query.setParameter("_deptNo", deptId);
	 	return query.getSingleResult();
	}
}
