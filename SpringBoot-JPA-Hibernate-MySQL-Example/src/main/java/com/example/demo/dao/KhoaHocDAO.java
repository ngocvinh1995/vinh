package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.KhoaHoc;

@Repository(value = "khoahocDAO")
@Transactional(rollbackFor = Exception.class)
public class KhoaHocDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	  public void save(final KhoaHoc khoahoc) {
		    Session session = this.sessionFactory.getCurrentSession();
		    session.save(khoahoc);
		  }
	
	 public void update(final KhoaHoc khoahoc) {
		    Session session = this.sessionFactory.getCurrentSession();
		    session.update(khoahoc);
		  }
	 
	 public KhoaHoc findById(final int MaKH) {
		 Session session = this.sessionFactory.getCurrentSession();
		 return session.get(KhoaHoc.class, MaKH);
	 }
	 
	 public void delete(final KhoaHoc khoahoc) {
		 Session session = this.sessionFactory.getCurrentSession();
		 session.remove(khoahoc);
	 }
	 
	 public List<KhoaHoc> findAll(){
		 Session session = this.sessionFactory.getCurrentSession();
		 return session.createQuery("FROM KhoaHoc", KhoaHoc.class).getResultList();
				 
	 }
}
