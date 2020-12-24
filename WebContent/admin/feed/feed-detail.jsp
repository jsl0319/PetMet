<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/style.css">
  <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  <title>FEED_detail</title>
</head>
<body>

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
          <li><a href="index.html">Report</a></li>
        </ul>
      </aside>

    <!----------------------------------main--------------------------------------->
      <main id="main" class="main feed-screen">
          <h1 class="d-none">Feed-detail 관리자 페이지</h1>

          <section class="reported-feed">
            <h1 class="d-none">신고받은 피드</h1>

            <input type="button" value="삭제">
            <iframe src="feed.html">
            </iframe>
          </section>

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