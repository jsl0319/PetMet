<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/style.css">
  <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
  <link rel="stylesheet" href="../../css/admin/components/form/default.css">
  <link rel="stylesheet" href="../../css/admin/components/feed.css">
  <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  <title>FEED-detail</title>
</head>
	
<div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
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
        <main id="main" class="main feed-list">
          <h1 class="d-none">Feed-list 관리자 페이지</h1>
          
          
         <form action="edit" method = "post">
	          <section>
	            <h1 class="d-none">신고 리스트</h1>
	            <table class="detail-table" border="1">
	                <tr>
	                  <th>번호</th>
	                  <td>${fr.id}</td>
	                </tr>
	                
	                <tr>
	                  <th>작성자</th>
	                  <td>${fr.memId}</td>
	                </tr>
	
	                <tr>
	                  <th>신고받은ID</th>
	                  <td>${fr.feedId}</td>
	                </tr>
	
	                <tr>
	                  <th>신고일</th>
	                  <td>${fr.repoDate}</td>
	                </tr>
	            </table>
	
	            <textarea class="detail-textarea" name="content" style="margin-top:20px">
	              ${fr.content}
	            </textarea>
	          </section>
	          
	          <section class="search__container">
	          
	          <input type="hidden" name="id" value="${fr.id }">
	           <input class="search__title button" type="submit" value="저장">
	           <a class="search__title button" href="detail?id=${fr.id }">취소</a>
	           
	          </section>
	          
          </form>

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