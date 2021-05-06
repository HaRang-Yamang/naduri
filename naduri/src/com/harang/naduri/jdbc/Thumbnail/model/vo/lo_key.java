package com.harang.naduri.jdbc.Thumbnail.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class lo_key extends Spot implements Serializable {

	
	private int l_no;
	private int ls_code;
	private String local_name;
	private int count_all;
	private ArrayList<Keyword> keywords;
	private String keyword;
	private int a_no;
	private String a_name;
	private String a_status;
	private int r_no;
	private int m_no;
	private int n_no;
	private int s_id;
	private int flevel;

	
	



	public lo_key() {}






	public lo_key(int l_no, int ls_code, String local_name, int count_all, ArrayList<Keyword> keywords, String keyword,
			int a_no, String a_name, String a_status, int r_no, int m_no, int n_no, int s_id, int flevel) {
		super();
		this.l_no = l_no;
		this.ls_code = ls_code;
		this.local_name = local_name;
		this.count_all = count_all;
		this.keywords = keywords;
		this.keyword = keyword;
		this.a_no = a_no;
		this.a_name = a_name;
		this.a_status = a_status;
		this.r_no = r_no;
		this.m_no = m_no;
		this.n_no = n_no;
		this.s_id = s_id;
		this.flevel = flevel;
	}






	public int getL_no() {
		return l_no;
	}






	public void setL_no(int l_no) {
		this.l_no = l_no;
	}






	public int getLs_code() {
		return ls_code;
	}






	public void setLs_code(int ls_code) {
		this.ls_code = ls_code;
	}






	public String getLocal_name() {
		return local_name;
	}






	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}






	public int getCount_all() {
		return count_all;
	}






	public void setCount_all(int count_all) {
		this.count_all = count_all;
	}






	public ArrayList<Keyword> getKeywords() {
		return keywords;
	}






	public void setKeywords(ArrayList<Keyword> keywords) {
		this.keywords = keywords;
	}






	public String getKeyword() {
		return keyword;
	}






	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}






	public int getA_no() {
		return a_no;
	}






	public void setA_no(int a_no) {
		this.a_no = a_no;
	}






	public String getA_name() {
		return a_name;
	}






	public void setA_name(String a_name) {
		this.a_name = a_name;
	}






	public String getA_status() {
		return a_status;
	}






	public void setA_status(String a_status) {
		this.a_status = a_status;
	}






	public int getR_no() {
		return r_no;
	}






	public void setR_no(int r_no) {
		this.r_no = r_no;
	}






	public int getM_no() {
		return m_no;
	}






	public void setM_no(int m_no) {
		this.m_no = m_no;
	}






	public int getN_no() {
		return n_no;
	}






	public void setN_no(int n_no) {
		this.n_no = n_no;
	}






	public int getS_id() {
		return s_id;
	}






	public void setS_id(int s_id) {
		this.s_id = s_id;
	}






	public int getFlevel() {
		return flevel;
	}






	public void setFlevel(int flevel) {
		this.flevel = flevel;
	}




}