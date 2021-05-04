package com.harang.naduri.jdbc.spot.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.harang.naduri.jdbc.spot.model.dao.SpotDAO;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class SpotService {
	
	private Connection con;
	private SpotDAO dao = new SpotDAO();

	public ArrayList<Spot> selectList() {

		con = getConnection();
		
		ArrayList<Spot> list = dao.selectList(con);
		
		close(con);
		
		return list;
		
		
	}

	public List<Spot> getlocation() {
		con = getConnection();
		
		List<Spot> result = dao.getlocation(con);
		
		close(con);
		
		return result;
	}
	
	// 관리자페이지 맛집 리스트 부분
	public ArrayList<Spot> foodList() {
		
		con = getConnection();
		
		ArrayList<Spot> list = dao.foodList(con);
		
		close(con);
		
		return list;
		
	}
	// 관리자페이지 여행지 리스트 부분
	public ArrayList<Spot> spotList() {
		con = getConnection();
		
		ArrayList<Spot> list = dao.spotList(con);
		
		close(con);
		
		return list;
	
	}
	
	
}
