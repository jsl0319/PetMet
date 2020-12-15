<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 디테일</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
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
                        <a href="index">
                            <i class="fas fa-camera-retro fa-2x"></i>
                            <span>FEED</span>
                        </a>
                    </li>
                    <li>
                        <a href="../community/index">
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
                            <i class="fas fa-bullhorn"></i>
                            <a href="list">Pet Place 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-bullhorn"></i>
                            <a href="category/list">카테고리 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-bullhorn"></i>
                            <a href="review/list">후기 관리</a>
                        </li>
                    </ul>
                </nav>

            </aside>

            <main class="main">
                <h1 class="d-none">main</h1>

                <section>
                    <h1>Pet Place 관리</h1>

                    <table class="detail-table">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td colspan="3">${p.name }</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td colspan="3">
                                	<fmt:formatDate value="${p.regDate }" pattern="yyyy-MM-dd a hh:mm:ss" /> 
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>${p.writerId }</td>
                                <th>조회수</th>
                                <td>${p.hit }</td>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td colspan="3">
                                	<c:forTokens var="fileName" items="${p.files}" delims="," varStatus="st">
										<fmt:formatDate var="year" value="${p.reDdate }" pattern="yyyy" /> 
                                      	<a download href="/static/notice/${year }/${n.id}/${fileName}">${fileName}</a>
                                      	<c:if test="${st.last == false}">
                                      	 / 
                                      	</c:if>
                                   	</c:forTokens>
                                </td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">지도</td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">${p.content }</td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">버튼</h1>
                    <a href="list">목록</a>
                    <a href="edit?id=${p.id }">수정</a>
                    <a href="del?id=${p.id }">삭제</a>
                </section>

            </main>

        </div>
    </div>

    <!-------------------------------footer------------------------------------>
    <footer class="footer">
        <div class="container">
            <h1>footer</h1>
        </div>
    </footer>

</body>

</html>