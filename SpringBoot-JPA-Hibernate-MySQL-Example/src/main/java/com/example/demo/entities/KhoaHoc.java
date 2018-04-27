package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaKH")
	private int MaKH;
	
	@Column(name="TenKH")
	private String TenKH;
	
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	
	
	
}
