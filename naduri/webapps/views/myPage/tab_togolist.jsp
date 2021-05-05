<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.member.model.vo.*,com.harang.naduri.jdbc.Thumbnail.model.vo.*, java.util.*, com.harang.naduri.jdbc.member.model.vo.Keyword;" %>
<%
   Member m = (Member)session.getAttribute("member");
	ArrayList<Keyword> list = (ArrayList<Keyword>)request.getAttribute("list"); //키워드
	ArrayList<lo_key> list2 = (ArrayList<lo_key>)request.getAttribute("list2"); //나머지
	
%>


    <div id="tab_togolist" class="tab-content current">
	            <div class="current_tab">
	             <% for(int i=0 ; i < list2.size(); i++) { %>
	               <div class="hotSpot">
	                        <img src="/naduri/resources/thumb/<%= list2.get(i).getA_name() %>">
	
	                        <div class="spotInfo">
	                      
	                            <h4><%= list2.get(i).getLocal_name() %></h4>
	                            
								<div class="spotInfoKeyword">
								<% for(Keyword k : list) { %>
	                            <p><%= k.getKeyword() %></p>
	                            <% } %>
	                            </div>
	                        </div>
	                        <div class="markIcon"><i class="fas fa-star"></i></div>
	                </div>
	               <% } %>
	            </div>
	        </div>