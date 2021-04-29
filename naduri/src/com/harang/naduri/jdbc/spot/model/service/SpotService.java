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
	
	
}
