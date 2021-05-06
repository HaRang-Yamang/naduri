<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.member.model.vo.*,com.harang.naduri.jdbc.Thumbnail.model.vo.*, java.util.*, com.harang.naduri.jdbc.member.model.vo.Keyword" %>
<%
   Member m = (Member)session.getAttribute("member");
	ArrayList<lo_key> list = (ArrayList<lo_key>)request.getAttribute("list"); //키워드
	
%>


    <div id="tab_togolist" class="tab-content current">
	            <div class="current_tab">
	             <% for(int i=0 ; i < list.size(); i++) { %>
	               <div class="hotSpot hotSpot<%=i%>">
	                        <img src="/naduri/resources/thumb/<%= list.get(i).getA_name() %>">
	
	                        <div class="spotInfo">
	                      
	                            <h4><%= list.get(i).getLocal_name() %></h4>
	                            
								<div class="spotInfoKeyword">
								<% for(String k : list.get(i).getKeyword()) { %>
	                            <p>#<%= k %> </p>
	                            <% } %>
	                            </div>
	                        </div>
	                        <div class="markIcon"><i class="fas fa-star"></i></div>
	                        <div class="markIcon"><i class="far fa-star"></i></div>
	                </div>
	                
	                <script>
	                $(function(){
	            		// 추천버튼 클릭시(추천 추가 또는 추천 제거)
	            		$(".markIcon").click(function(){
	            			$.ajax({
	            				url: "/naduri/bookmarkInsert.do",
	                            type: "get",
	                            data: { l_no : '<%= list.get(i).getL_no() %>', m_no : '<%= m.getM_no() %>'
	                            },
	                            success: function () {
	            			        recCount();
	                            },
	            			})
	            		})
	            		
					recCount();
	                
	                
	                $('.hotSpot<%=i%>').on('click', function(){
	                    location.href='/naduri/CallApiDetailSelectOneCollection.do?l_no=<%=list.get(i).getL_no()%>';
	               });
	                </script>
	               <% } %>
	            </div>
	        </div>