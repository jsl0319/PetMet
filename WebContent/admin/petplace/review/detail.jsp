<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 카테고리</title>
    <link rel="stylesheet" href="../../../css/style.css">
    <link rel="stylesheet" href="../../../css/admin/components/table/list.css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="detail.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
<div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
    <!-------------------------------header------------------------------------>
    <jsp:include page="../../../inc/admin-header.jsp"></jsp:include>

    <!-------------------------------body------------------------------------>
    <div class="body">
        <h1 class="d-none">contents body</h1>

        <div class="container">

            <aside class="aside">
                <h1 class="d-none">aside</h1>

                <nav>
                    <h1 class="d-none">세부 메뉴</h1>

                    <ul>
                        <li>
                            <i class="fas fa-map-marked-alt"></i>
                            <a href="../list">&nbsp;&nbsp;Pet Place 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-chalkboard"></i>
                            <a href="../category/list">&nbsp;&nbsp;카테고리 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-clipboard"></i>
                            <a href="../review/list">&nbsp;&nbsp;후기 관리</a>
                        </li>
                    </ul>

                </nav>

            </aside>

            <main class="main">
                <h1 class="title">Review 관리</h1>
                
                <form action="detail" method="post">
                <section>
                    <h1 hidden>Pet Place : ${list[0].categoryName}</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td class="col-s">번호</td>
                                <td class="col-s">작성자</td>
                                <td class="col-l">리뷰 내용</td>
                                <td class="col-m">평점</td>
                                <td>삭제</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        	<c:forEach var="l" items="${list}">
	                            <tr  ${l.num%2==0?"class='even'":""}>
	                                <td>${l.num}</td>
	                                <td>${l.memberName}</td>
	                                <td>${l.content}</td>
	                                <td>${l.rating}</td>
	                                <td><input name="del" value="${l.id}" type="checkbox"></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section class="buttons">
                    <h1 class="d-none">버튼</h1>
                    <input class="button" type="submit" value="선택 삭제">
                </section>
				</form>
				
                <section>
                    <c:set var="page" value="${(empty param.p)?1:param.p}"/>
                    <c:set var="startNum" value="${page-(page-1)%5}" />
                    <c:set var="lastNum" value="${tp}"/>
                    <div class="pager">
                        <c:if test="${1 <= startNum-5}">
		                    <div>
		                      <a href="?p=1"><i class="fas fa-angle-double-left"></i></a>
		                    </div>
		                    <div>
		                      <a href="?p=${startNum - 5}"><i class="fas fa-angle-left"></i></a>
		                    </div>
                   		</c:if>
                        <ul>
                    	<c:forEach var="i" begin="0" end="4">
							<c:if test="${(startNum + i) <= lastNum }">
								<li><a href="?p=${startNum+i}">${startNum+i}</a></li>
							</c:if>
						</c:forEach>
                    	</ul>
                        <c:if test="${startNum+5 <= lastNum}">
		                    <div>
		                      <a href="?p=${startNum+5}"><i class="fas fa-angle-right"></i></a>
		                    </div>
		                    <div>
		                      <a href="?p=${lastNum }"><i class="fas fa-angle-double-right"></i></a>
		                    </div>
                    	</c:if>
                    </div>
                </section>
            </main>
        </div>
    </div>

    <!-------------------------------footer------------------------------------>
    <footer class="footer">
        <div class="container">
            <h1></h1>
        </div>
    </footer>

</body>

</html>