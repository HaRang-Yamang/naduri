package com.harang.naduri.jdbc.heritage.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.heritage.model.dao.HeritageDAO;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class HeritageService {

	private Connection con;
	private HeritageDAO dao = new HeritageDAO();
	
	
	// ¸ñ·Ï Á¶È¸ ½Ã ÇÊ¿äÇÑ Á¾¸ñÄÚµå ÃßÃâ
	public ArrayList<Heritage> selectName(String spotName) {
		
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectName(con, spotName);
		
		close(con);
		
		return list;
	}

	
	
	
	
	// ¸ñ·Ï Á¶È¸
	public ArrayList<Heritage> selectList(String spotName) {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	
	
	
	// °ø°øµ¥ÀÌÅÍ DB ÀúÀå
	public int insertHeritage(Heritage heri) {
		con = getConnection();
	
		
		// 1. LOCATION Å×ÀÌºí µ¥ÀÌÅÍ »ı¼º
		int result1 = dao.insertLocation(con, heri);
		
		// Ã³¸®µÈ Çà °³¼ö°¡ ¾Æ´Ï¶ó Æ¯Á¤ °á°ú °ªÀÌ ³ª¿À°Ô ÇÏ·Á¸é?

		
		// Debug
		System.out.println("location id »ı¼º ¼º°ø ¿©ºÎ : " + result1);
		
		
		// Location VO »ı¼º
		// Location location = new Location();
		
		
		if( result1 > 0 ) {
			commit(con);
			
			
			// 2. Locaiton ID °ª °¡Á®¿À±â
			int l_no = dao.selectLno(con);
			
			// Debug
			System.out.println("location id Á¶È¸ ¼º°ø ¿©ºÎ : " + l_no);

			// l_no¸¦ °¡Á®¿Â °ªÀÌ ÀÖ´Ù¸é commit
			if ( l_no < 0) {
				rollback(con);
			} else {
				commit(con);
				int result2 = 0;
				
				// Debug
				System.out.println("location id °á°ú°ª È®ÀÎ : " + l_no);
				
				// 3. À§¿¡¼­ Ã£Àº l_no¿Í Heritage °´Ã¼¸¦ ÇÔ²² insert Heritage
				result2 = dao.insertHeritage(con, l_no, heri);
				
			
				// result2ÀÇ °á°ú°ªÀÌ 0ÀÌ¶ó¸é rollback
				if( result2 > 0) commit(con);
				else rollback(con);
				} // ¾ÈÂÊ if¹® end
				commit(con);
			
		} // else end

		close(con);
		
		return result1;

	}

	// ê´€ë¦¬ìí˜ì´ì§€ ë¬¸í™”ì¬ ë¦¬ìŠ¤íŠ¸
	public ArrayList<Heritage> heritageList() {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.heritageList(con);
		
		close(con);
		
		return list;
	}








}
