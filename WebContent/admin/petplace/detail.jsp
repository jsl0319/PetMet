<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 디테일</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="detail.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	6c3f482aeb9a4689468c97bf295d500e"></script>
    <script src="../../js/admin/petplace/detail.js"></script>
</head>

<body>
	<div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
    <!-------------------------------header------------------------------------>
    <jsp:include page="../../inc/admin-header.jsp"></jsp:include>

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
                            <a href="list">&nbsp;&nbsp;Pet Place 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-chalkboard"></i>
                            <a href="category/list">&nbsp;&nbsp;카테고리 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-clipboard"></i>
                            <a href="review/list">&nbsp;&nbsp;후기 관리</a>
                        </li>
                    </ul>
                </nav>

            </aside>

            <main class="main">
                <h1 class="d-none">main</h1>

                <section>
                    <h1 class="title">Pet Place 관리</h1>

                    <table class="detail-table">
                        <tbody>
                            <tr>
                                <th>이름</th>
                                <td>${p.name}</td>
                                <th>카테고리</th>
                                <td>${p.categoryName}</td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td colspan="3">${p.address}</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td>
                                    <fmt:formatDate value="${p.regDate }" pattern="yyyy-MM-dd a hh:mm:ss" />
                                </td>
                                <th>조회수</th>
                                <td>${p.hit }</td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>${p.writerName}</td>
                                <th>좋아요</th>
                                <td>${p.likes}</td>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td colspan="3">
                                    <c:forTokens var="fileName" items="${p.files}" delims=","
                                        varStatus="st">
                                        <fmt:formatDate var="year" value="${p.regDate}" pattern="yyyy" />
                                        <a download
                                            href="/static/notice/${year }/${n.id}/${fileName}">${fileName}</a>
                                        <c:if test="${st.last == false}">
                                            /
                                        </c:if>
                                    </c:forTokens>
                                </td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">
                                    <div id="map" style="width:900px;height:400px;"></div>
                                </td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">${p.content }</td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <section class="buttons">
                    <h1 class="d-none">버튼</h1>
                    <a class="button" href="list">목록</a>
                    <a class="button" href="edit?id=${p.id }">수정</a>
                    <a class="button" href="del?id=${p.id }">삭제</a>
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