<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/table/list.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/form/default.css" type="text/css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
 <div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
   <jsp:include page="../../inc/admin-header.jsp"></jsp:include>

    <div class="body">
        <div class="container">
            <aside class="aside">
                <h1 class="d-none">페이지 목록</h1>
                <ul>
                  <li><a href="list">회원 목록</a></li>
                  <li><a href="doglist">강아지 목록</a></li>
                  <li><a href="matchinglist">매칭 목록</a></li>
                  <li><a href="reportlist">신고 목록</a></li>

                </ul>
              </aside>
            <main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form class="search__form search__container">
                     
                            <select class="selectbox" name="f">
                                <option ${param.f=="nickname"?"selected":""} value="nickname">닉네임</option>
                        
                            </select>
                            <input type="text" class="search__input" name="q" value="${param.q}">
                      

                        <label>가입일</label>
                        <input type="date" name="sd" value="${param.sd}">~
                        <input type="date" name="ed" value="${param.ed}">
                        <input type="submit" class="button search-button" value="검색">

                    </form>
                </section>

                <section class="main-section">
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td class="col-m">이메일</td>
                                <td class="col-m">닉네임</td>
                                <td class="col-s">성별</td>
                                <td class="col-l">주소</td>
                                <td class="col-l">휴대폰번호</td>
                                <td class="col-m">가입일</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        
                      
                        <c:forEach var="m" items="${list}" varStatus="st">
                            <tr class="${st.index%2==0?'even':''}">
                                <td>${m.id}</td>
                                <td>${m.email}</td>
                                <td><a href="detail?id=${m.id}">${m.nickname}</a></td>
                                <td>
                                	${m.gender==1?"남":"여"}                      
                                </td>
                                <td>${m.address}</td>
                                <td>${m.phone}</td>
                                <td>${m.regDate}</td>
                            </tr>
                          </c:forEach>
                        </tbody>
                    </table>

                </section>
             

				<c:set var="page" value="${(empty param.p)?1:param.p}"/>
		        <c:set var="startNum" value="${page-(page-1)%5}"/>
		        <c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/num),'.')}"/>
                <div class="pager">
                    <div>
                      <a href="?p=${1}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <c:if test="${startNum>1}">
                    	<a href="?p=${startNum-5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                    <c:if test="${startNum<=1}">
                    	<a href="?p=${1}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                     
                    </div>
                    <ul>
                    <c:forEach var="i" begin="0" end="4">	
                    <c:if test="${(startNum+i)<=lastNum}">
						<li><a class="${page==(startNum+i)?"current-page":""}" href="?p=${startNum+i}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}" >${startNum+i}</a></li>
					</c:if>	
					</c:forEach>
					</ul>
                    <div>
                    <c:if test="${startNum+5<=lastNum}">
                    	<a href="?p=${startNum+5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                    <c:if test="${startNum+5>lastNum}">
                    	<a href="?p=${lastNum}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                      
                    </div>
                    <div>
                      <a href="?p=${lastNum}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                  </div>
            </main>


        </div>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1></h1>
        </div>

    </footer>

</body>

</html>