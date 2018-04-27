package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.KhoaHocDAO;
import com.example.demo.entities.KhoaHoc;

@Service
@Transactional
public class KhoaHocService {
	
	@Autowired
	private KhoaHocDAO khoahocDAO;
	
	public List<KhoaHoc> findAll(){
		return khoahocDAO.findAll();
	}
	
	public KhoaHoc findById(final int MaKH) {
		return  khoahocDAO.findById(MaKH);
	}
	
	public void delete(final int MaKH) {
		KhoaHoc khoahoc = khoahocDAO.findById(MaKH);
		if(khoahoc !=null) {
		khoahocDAO.delete(khoahoc);
		}
	}
	
	public void update(final KhoaHoc khoahoc) {
		khoahocDAO.update(khoahoc);
	}
	
	public void save(final KhoaHoc khoahoc)
	{
		khoahocDAO.save(khoahoc);
	}

}
