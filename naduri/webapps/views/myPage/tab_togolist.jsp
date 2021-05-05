<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.harang.naduri.jdbc.member.model.vo.*,
com.harang.naduri.jdbc.Thumbnail.model.vo.*, java.util.*,
com.harang.naduri.jdbc.attach.model.vo.*,
com.harang.naduri.jdbc.spot.model.vo.*,
com.harang.naduri.jdbc.heritage.model.vo.*"%>
<%
/*   
   HashMap<String, Object> map = (HashMap<String, Object>)request.getAttribute("map");
	ArrayList<Attach> lista = (ArrayList<Attach>)request.getAttribute("lista");
	ArrayList<Keyword> listk = (ArrayList<Keyword>)request.getAttribute("listk");
	ArrayList<Spot> lists = (ArrayList<Spot>)request.getAttribute("lists");
	ArrayList<Heritage> listh = (ArrayList<Heritage>)request.getAttribute("listh");
	*/
	
	List<Map<String, Object>> list = (ArrayList) request.getAttribute("list");
	//System.out.println(">>>>> 화면 list : " + list);
	%>


<div id="tab_togolist" class="tab-content current">
<%= list %>
	<div class="current_tab">
		<% for(int i=0 ; i < list .size(); i++) { 
		
		Map<String, Object> map = list.get(i);
		
		Integer lNo = (Integer) map.get("l_no");
		String aName = (String) map.get("a_name");
		String localName = (String) map.get("local_name");
		String keyword = (String) map.get("keyword");
		
		%>
		

 		<div class="hotSpot">
			<img src="/naduri/resources/thumb/<%= aName %>">

			<div class="spotInfo"> 
				<h4><%= localName %></h4>
				<%-- <div class="spotInfoKeyword"><% for(Keyword k : listk) { %><% if( lista.get(i).getL_no() == lists.get(i).getL_no() ) { %><p><%= k.getKeyword %></p><% } %><% } %></div> --%>
				<div class="spotInfoKeyword">
					<p><%= keyword %><p>
				</div>
			</div>
			<div class="markIcon">
				<i class="fas fa-star"></i>
			</div>
		</div> 

		<% } %>
	</div>
</div>