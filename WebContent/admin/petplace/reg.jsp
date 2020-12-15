<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 등록</title>
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
                    <h1>PetPlace 등록</h1>

                    <form method="post">

                        <table class="detail-table">
                            <tbody>
                                <tr>
                                    <th>제목</th>
                                    <td>
                                        <input type="text" name="title" />
                                    </td>
                                    <th>카테고리</th>
                                    <td>
                                        <select name="category">
                                        	<c:forEach var="ppc" items="${list }">
                                            	<option value="${ppc.name }">${ppc.name }</option>
                                        	</c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="files">첨부파일</th>
                                    <td colspan="3">
                                        <input type="file" name="file" />
                                    </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="4">
                                        <textarea class="content" name="map"
                                            style="width: 900px; height: 400px; resize: none;">지도</textarea>
                                    </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="4">
                                        <textarea class="content" name="content"
                                            style="width: 900px; height: 500px; resize: none;">상세설명</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="checkbox" id="open" name="open" value="true">
                                        <label>공개</label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <section>
                            <input type="submit" value="등록" />
                            <a href="list">취소</a>
                        </section>
                    </form>
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