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
    <link rel="stylesheet" href="../../css/admin/components/table/list.css">
    <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="detail.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	6c3f482aeb9a4689468c97bf295d500e"></script>
    <script src="../js/petplace/detail.js"></script>
</head>

<body>
<div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
    <!-------------------------------header------------------------------------>
    <header class="header">
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
                            <span>MEMBER</span>
                        </a>
                    </li>
                    <li>
                        <a href="../feed/list">
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
                        <a href="list">
                            <i class="fas fa-map-marked-alt fa-2x"></i>
                            <span>PLACE</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>

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
                            <a href="list">&nbsp;&nbsp;Pet Place</a>
                        </li>
                    </ul>
                </nav>

            </aside>

            <main class="main">
                <h1 class="d-none">main</h1>

                <section>
                    <h1 class="title">Pet Place</h1>

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
                                        <a download href="/static/notice/${year }/${n.id}/${fileName}">${fileName}</a>
                                        <c:if test="${st.last == false}">
                                            /
                                        </c:if>
                                    </c:forTokens>
                                </td>
                            </tr>
                            <tr class="content-map">
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

                <section>

                    <h1 class="title2">Review</h1>

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td class="col-s">번호</td>
                                <td class="col-s">작성자</td>
                                <td class="col-l">리뷰 내용</td>
                                <td class="col-m">평점</td>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="l" items="${list}">
                                <tr ${l.num%2==0?"class='even'":""}>
                                    <td>${l.num}</td>
                                    <td>${l.memberName}</td>
                                    <td>${l.content}</td>
                                    <td>${l.rating}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </section>
                
            </main>

        </div>
    </div>

    <!-------------------------------footer------------------------------------>
    <footer class=" footer">
                                    <div class="container">
                                        <h1></h1>
                                    </div>
                                    </footer>

</body>

</html>