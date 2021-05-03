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
		ArrayList<Attach> list = new ArrayList();
		
		int result = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != null && list.get(i).getA_name() != null) {
				
				result = dao.insertProfileImg(con, list.get(i));
				
				if(result == 0) break;
				
			}else {
				result = 1;
			}
		}
		
		close(con);
		
		return result;
	}

}
