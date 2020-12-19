<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/style.css">
  <link rel="stylesheet" href="../../css/admin/components/table/list.css">
  <link rel="stylesheet" href="../../css/admin/components/form/default.css">
  <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  <title>FEED_detail-list</title>
</head>
<body>

    <!----------------------------------header--------------------------------------->
  <header id="header" class="header">
      <div class="container">
        
        <div class="logo">
          <a href="../index">
            <i class="fas fa-dog fa-3x"></i>
            <h1>PetMet</h1>
          </a>
        </div>

        <nav>
          <h1 class="d-none">헤더 목록</h1>
          <ul>
            <li>
              <a href="../member/list">
                <i class="fas fa-users fa-2x"></i>
                <span>USER</span>
              </a>
            </li>
            <li>
              <a href="list">
                <i class="fas fa-camera-retro fa-2x"></i>
                <span>FEED</span>
              </a>
            </li>
            <li>
              <a href="../community/notice/list">
                <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                <span>COMMUNITY</span>
              </a>
            </li>
            <li>
              <a href="../petplace/list">
                <i class="fas fa-map-marked-alt fa-2x"></i>
                <span>PLACE</span>
              </a>
            </li>
          </ul>
        </nav>
      </div>
    </header>

    <!----------------------------------body--------------------------------------->
    <div class="body feed-screen">

      <h1 class="d-none">Feed 관리자 페이지</h1>
      <div class="container">

    <!----------------------------------aside--------------------------------------->
        <aside class="aside">
          <h1 class="d-none">페이지 목록</h1>
          <ul>
            <li><a href="list">Report</a></li>
          </ul>
        </aside>

    <!----------------------------------main--------------------------------------->
        <main id="main" class="main feed-list">
          <h1 class="d-none">Feed-list 관리자 페이지</h1>
            
          <section class="main-section">
            <h1 class="d-none">신고 리스트</h1>
            
                <form class="search__container">
                    <div>
                    <select class="selectbox" name="f">
                      <option ${param.f=="nickname" ? "selected":""} value="nickname">닉네임</option>
                    </select>
                    
                    <input class="search__input" type="text" name = "q" value="${param.q }">
                    </div>
                    
                    <input type="date" name="sd" value="${param.sd}">~
                        <input type="date" name="ed" value="${param.ed}">
                    <input class="button" type="submit" value="검색" />
                    
                  </form>
                  
              <table class="list-table" border="1">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>신고받은ID</th>
                    <th>신고자ID</th>
                    <th>신고일</th>
                  </tr>
                </thead>

                <tbody>
                <c:forEach var = "rf" items="${list}">
                <tr>
                  <td>${rf.num}</td>
                  <td><a href ="detail?id=${rf.id}">${rf.feedId }</a></td>
                  <td>${rf.memId}</td>
                  <td><fmt:formatDate value="${rf.repoDate}" pattern="yyyy-MM-dd / a hh:mm:ss"/></td>
                </tr>
                </c:forEach>
                 
              </tbody>
            </table>
           
          </section>
            
            
          <c:set var="page" value="${(param.p == null) ? 1 : param.p}"/>
		  <c:set var="startNum" value="${page-(page-1)%5}"/>
          <div class="pager">
            <div>
              <a href="#"><i class="fas fa-angle-double-left"></i></a>
            </div>
            <div>
              <a href="?p=${startNum-5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-left"></i></a>
            </div>
          <ul>
            <c:forEach var="i" begin="0" end="4">		
				<li><a href="?p=${startNum+i}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}" >${startNum+i}</a></li>
			</c:forEach>
          </ul>
          <div>
            <a href="?p=${startNum+5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
          </div>
          <div>
            <a href="#"><i class="fas fa-angle-double-right"></i></a>
          </div>
          </div>

        </main>
      </div>
  </div>

    <!----------------------------------footer--------------------------------------->
  <footer id="footer" class="footer">
      <div class="container">
        <h1 class="d-none">Footer</h1>
      </div>
    </footer>
  </body>
</html>