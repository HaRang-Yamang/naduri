package com.harang.naduri.jdbc.Thumbnail.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;

import com.harang.naduri.jdbc.Thumbnail.model.dao.ProfileImgDAO;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;

public class ProfileImg {
	
	private Connection con;
	private ProfileImgDAO dao = new ProfileImgDAO();

	public int insertProfileImg(Attach a) {
		con = getConnection();
		
		int result = 0;
		
		// 사진 저장
		int result1 = dao.insertProfileImg(con, a);
		
		return 0;
	}

}
