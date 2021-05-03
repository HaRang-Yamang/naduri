package com.harang.naduri.jdbc.Thumbnail.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.Thumbnail.model.dao.ProfileImgDAO;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;

public class ProfileImg {
	
	private Connection con;
	private ProfileImgDAO dao = new ProfileImgDAO();

	public int insertProfileImg(Attach a) {
		con = getConnection();
		
		int result = dao.insertProfileImg(con, a);
				
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
