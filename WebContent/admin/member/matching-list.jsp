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
                    <form class="search__container search__form">
                        <div>
                          

                            <select class="selectbox" name="f">
                                <option value="-1" ${param.f==-1?"selected":""}>매칭 상태</option>
                                <option value="0" ${param.f==0?"selected":""}>진행중</option>
                                <option value="1" ${param.f==1?"selected":""}>수락</option>
                                <option value="2" ${param.f==2?"selected":""}>거절</option>
                            </select>
                        </div>

                        <label>등록일</label>
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
                                <td class="col-m">요청회원</td>
                                <td>강아지</td>
                                <td>응답회원</td>
                                <td class="col-m">강아지</td>
                                <td class="col-m">매칭 상태</td>
                                <td class="col-m">날짜</td>
                            </tr>
                        
                        </thead>
                
                        <tbody>
                         <c:forEach var="mt" items="${list}" varStatus="st">
                            <tr class="${st.index%2==0?'even':''}">
                                <td>${mt.id}</td>
                                <td>${mt.reqId}</td>
                                <td>${mt.reqDogName}</td>
                                <td>${mt.respId}</td>
                                <td>${mt.respDogName}</td>
                                <td>
                                	<c:if test="${mt.result==0 }"><a href="matchingdetail?id=${mt.id}">진행중</a></c:if>
                                	<c:if test="${mt.result==1 }"><a href="matchingdetail?id=${mt.id}">수락</a></c:if>
                                	<c:if test="${mt.result==2 }"><a href="matchingdetail?id=${mt.id}">거절</a></c:if>
                                </td>
                                <td>${mt.reqDate}</td>
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
                      <a href="?p=${1}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <c:if test="${startNum>1}">
                    	<a href="?p=${startNum-5}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                    <c:if test="${startNum<=1}">
                    	<a href="?p=${1}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                     
                    </div>
                    <ul>
                    <c:forEach var="i" begin="0" end="4">	
                    <c:if test="${(startNum+i)<=lastNum}">
						<li><a class="${page==(startNum+i)?"current-page":""}" href="?p=${startNum+i}&f=${param.f}&sd=${param.sd}&ed=${param.ed}" >${startNum+i}</a></li>
					</c:if>	
					</c:forEach>
					</ul>
                    <div>
                    <c:if test="${startNum+5<=lastNum}">
                    	<a href="?p=${startNum+5}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                    <c:if test="${startNum+5>lastNum}">
                    	<a href="?p=${lastNum}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                      
                    </div>
                    <div>
                      <a href="?p=${lastNum}&f=${param.f}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-double-right"></i></a>
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