<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/list.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="../../css/admin/components/feed.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <title>FEED</title>
  </head>
  <body>
  
  <div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
  
      <!----------------------------------header--------------------------------------->
      <jsp:include page="../../inc/admin-header.jsp"></jsp:include>
  
      <!----------------------------------body--------------------------------------->
      <div class="body feed-screen">
  
          <h1 class="d-none">Feed 관리자 페이지</h1>
          <div class="container">
      <!----------------------------------aside--------------------------------------->
            
          <aside class="aside">
            <h1 class="d-none">페이지 목록</h1>
            <ul>
              <li><a href="list"><i class="fas fa-poo"></i> Report</a></li>
            </ul>
          </aside>
      <!----------------------------------main--------------------------------------->
  
            <main id="main" class="main feed-index">
              <h1 class="d-none">Feed-list 관리자 페이지</h1>

              <section class="main-section">
                <h1 class="d-none">신고 리스트</h1>
                
                  <form class="search__container search__form">
                  
                    <select class="selectbox" name="f">
                      <option  value="reported_id">닉네임</option>
                    </select>
                    
                    <input type="text" class="search__input" name="q" value="${param.q}">
                    <input class="button search-button" type="submit" value="검색" />
                    
                   </form>
                    
                  <table class="list-table" border="1">
                    <thead>
                      <tr>
                        <td>번호</td>
                        <td>신고받은ID</td>
                        <td>신고수</td>
                        <td>조치여부</td>
                      </tr>
                    </thead>
  
                    <tbody>
                    
                    <c:forEach var = "rf" items="${list}">
                      <tr ${rf.num%2==0?"class='even'":""}>
                        <td>${rf.num}</td>
                        <td>${rf.reportedId}</td>
                        <td><a href="detail-list">${rf.repoCnt }</a></td>
                        <td>${rf.action}</td>
                      </tr>
                    </c:forEach>
                    
                    </tbody>
                  </table>
                  
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
      </div>
  
      <!----------------------------------footer--------------------------------------->
      <footer id="footer" class="footer">
        <div class="container">
          <h1 class="d-none"></h1>
        </div>
      </footer>
  
  </body>
  </html>