
<%@page import="com.petmet.web.entity.Notice"%>
<%@page import="com.petmet.web.service.NoticeService"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 공지사항 관리</title>

    <link rel="stylesheet" href="../../css/reset.css" type="text/css">

    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <link rel="stylesheet" href="../../../css/style.css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">


    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>

</head>

<body>
 <div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
   <jsp:include page="../../../inc/admin-header.jsp"></jsp:include>

    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">

            <aside class="aside">
                <h1 class="d-none">Aside 메뉴</h1>

                <nav>
                    <h1 class= "d-none">세부 메뉴 목록</h1>

                    <ul>
                        <li>
                          
                            <a href="../notice/list">공지사항관리</a>
                        </li>

                        <li>
                            
                            <a href="../QnA/list">QnA 관리</a>
                        </li>

                        <li>
                         
                            <a href="../category/list">카테고리 관리</a>
                        </li>

                        <li>
                            
                            <a href="../board/list">게시글 관리</a>
                        </li>

                        <li>
                            
                            <a href="../board/reported">신고된 게시글 관리</a>
                        </li>

                        <li>
                          
                            <a href="../comment/list">댓글 관리</a>
                        </li>

                        <li>
                           
                            <a href="../comment/reported">신고된 댓글 관리</a>
                        </li>
                    </ul>
                </nav>


            </aside>

            <main class="main">
                <h1 class="d-none">Main Content</h1>

                <section>
                    <h1 class="d-none">검색폼</h1>
                   <form class="search__container search__form" action="list">
                        
                        <label class="search__title">제목</label>
                        <input class="search__input" type="text" name= "q" value="${param.q}">
                        

                  

                         <label class="search__title" >일자</label>
                         <input class="search__input" type="date"name ="sd" value="${param.sd}">~<input class="search__input" type="date" name="ed"  value="${param.ed}">
                         <input class="button" type="submit" value="검색">
     
                    </form>
                </section>

                <section>
                    <h1>공지사항 관리</h1>
                    <form method="post" action="list">

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>조회수</td>
                                
                                <td>삭제</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="n" items="${list}" varStatus="st">
                          <tr ${st.count % 2==0?"class='even'":""}>
                                <td>${n.id}</td>
                  <td><a href="detail?id=${n.id}">${n.title}</a></td>

                                <td>${n.writerId}</td>
                                <td> ${n.regdate}</td>
                                <td>${n.hit}</td>
                         
                         
                                <td><input name="del-id" value ="${n.id}" type="checkbox"></td>
                                
                            </tr>
                                 </c:forEach>
                        </tbody>
                    </table>
                </form>
                </section>

                <section>
                    <h1 class="d-none">이벤트 버튼</h1>
                  
                   <input class="button" type="submit" value="모두 삭제">
                    
                    <a href="reg"><input class="button" type="button" value="게시글 작성"></a>
                </section>
                
          
            
  
              <c:set var="page" value="${(empty param.p)? 1:param.p }"/>
              <c:set var="startNum" value="${ page-(page-1)%5}"/>
              <c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"/>
              
              <div class="pager">
              
              	<c:if test="${startNum >= 1 }">
	                <div>
	                  <a href="?p=1&f=${param.f}&q=${param.q}""><i class="fas fa-angle-double-left"></i></a>
	                </div>
                </c:if>
                
                <c:if test="${startNum >= 1 }">
                <div>
                  <a href="?p=${(startNum<6)? startNum:(startNum-5)}&f=${param.f}&q=${param.q}"><i class="fas fa-angle-left"></i></a>
                </div>
                </c:if>
                
                <ul>
              <c:forEach var="i" begin="0" end="4">	
              	<c:if test="${(startNum+i)<=lastNum }">
                	<li><a class="${(page==(startNum+i))? 'page-point' : ''}" href="?p=${startNum + i}&f=${param.f}&q=${param.q}">${startNum + i}</a></li>
              	</c:if>
              </c:forEach>
                </ul>
                
                <div>
                  <a href="?p=${(startNum+4 < lastNum)? (startNum+5):lastNum}&f=${param.f}&q=${param.q}"><i class="fas fa-angle-right"></i></a>
                </div>
                
                <div>
                  <a href="?p=${lastNum }&f=${param.f}&q=${param.q}"><i class="fas fa-angle-double-right"></i></a>
                </div>
              </div>
				
            </main>
				 
        </div>
    </section>

    <footer class="footer">
        <div class="container">
            <h1></h1>
        </div>
    </footer>

</body>

</html>