<%@page import="com.petmet.web.entity.Question"%>
<%@page import="com.petmet.web.service.QuestionService"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티> QnA관리 > 리스트 </title>

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
                        

                        <!-- <label class="search__title" >공개여부</label> -->
                        <input ${(param.r==1)?"checked":"" }value =1 type="radio" id="cb1" name="r">
                        <label for="cb1"></label> <label class="search__title">공개</label>
                        <input ${(param.r==2)?"checked":"" }value = 2 type="radio" id="cb2" name="r">
                        <label for="cb2"></label> <label class="search__title">비공개</label>


                    <label class="search__title" >일자</label>
                         <input class="search__input" type="date"name ="sd" value="${param.sd}">~<input class="search__input" type="date" name="ed"  value="${param.ed}">
                         <input class="button" type="submit" value="검색">
                    </form>
                </section>

                <section>
                    <br>
                    <h1>QnA 리스트</h1>

                    <table class="list-table" >
                        <thead>
                          <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>공개</td>
                                <td>답변</td>
                                <td>답변일자</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="q" items="${qlist}" varStatus="st">
                         <tr ${st.count % 2==0?"class='even'":""}>
                            <td>${q.id}</td>
                            <td><a href="detail?id=${q.id}">${q.title}</a></td>
                            <td>${q.writerId}</td>
                            <td>${q.regDate}</td>
                            <td>${q.pub}</td>
                            <td>${q.isAnswer}</td>
                            <td>${q.anDate}</td>
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
    </section>






    <footer class="footer">
        <div class="container">
            <h1 class="d-none"></h1>
        </div>
    </footer>



</body>

</html>