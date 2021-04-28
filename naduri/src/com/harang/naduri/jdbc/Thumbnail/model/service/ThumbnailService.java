package com.harang.naduri.jdbc.Thumbnail.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class ThumbnailService {

	private Connection con;
	private ThumbnailDAO dao = new ThumbnailDAO();
	
	public ArrayList<Thumbnail> selectList() {
		con = getConnection();
		
		ArrayList<Thumbnail> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}

}