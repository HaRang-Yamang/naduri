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
	public ArrayList<Spot> foodList(int currentPage) {
		
		con = getConnection();
		
		ArrayList<Spot> list = dao.foodList(con, currentPage);
		
		close(con);
		
		return list;
		
	}
	// 관리자페이지 여행지 리스트 부분
	public ArrayList<Spot> spotList(int currentPage) {
		con = getConnection();
		
		ArrayList<Spot> list = dao.spotList(con, currentPage);
		
		close(con);
		
		return list;
	
	}

	// 페이지네이션을 위한 서비스 생성
	public int getListCount() {
		con = getConnection();
		
		int result = dao.getListCount(con);
		
		close(con);
		
		return result;
	}
	
	//관리자페이지 맛집데이터 업데이트 부분
	public int FoodUpdateList(int s_id, String s_status) {
		con = getConnection();
		
		int result = 0;
		
		//만약 m_status가 y이면 n으로 바꾸고
		// else if m_status가 n이라면 y로 바꿔라
		if(s_status.equals("Y")) {
			s_status = "N";
		} else {
			s_status = "Y";
		}
		result = dao.foodUpdateList(con, s_id, s_status);
		
		 if(result > 0) commit(con);
		 else rollback(con);
		
		close(con);
		
		return result;
	}

	//관리자페이지 여행지 데이터 업데이트 부분
	public int SpotUpdateList(int s_id, String s_status) {
		con = getConnection();
		
		int result = 0;
		
		//만약 m_status가 y이면 n으로 바꾸고
		// else if m_status가 n이라면 y로 바꿔라
		if(s_status.equals("Y")) {
			s_status = "N";
		} else {
			s_status = "Y";
		}
		result = dao.foodUpdateList(con, s_id, s_status);
		
		 if(result > 0) commit(con);
		 else rollback(con);
		
		close(con);
		
		return result;
	}
	
}
