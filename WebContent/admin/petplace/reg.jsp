<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 등록</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="reg.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6c3f482aeb9a4689468c97bf295d500e"></script>
    <script src="../../js/admin/petplace/reg.js"></script>
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
                    <h1 class="title">PetPlace 등록</h1>

                    <form method="post" enctype="multipart/form-data">

                        <table class="detail-table">
                            <tbody>
                                <tr>
                                    <th>이름</th>
                                    <td>
                                        <input type="text" name="name" />
                                    </td>
                                    <th>카테고리</th>
                                    <td>
                                        <select name="categoryId">
                                            <c:forEach var="ppc" items="${list}">
                                                <option value="${ppc.id}">${ppc.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>주소</th>
                                    <td>
                                        <input hidden class="location-input" type="text" name="location">
                                        <input class="address-input" type="text" name="address">
                                        <input type="button" class="search-btn" value="지도 검색">
                                    </td>
                                    <th>공개 여부</th>
                                    <td>
                                        <select name="pub">
                                            <option selected value="1">공개</option>
                                            <option value="0">비공개</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>홈페이지</th>
                                    <td><input type="text" name="homepage"></td>
                                    <th>전화번호</th>
                                    <td><input type="text" name="phone"></td>
                                </tr>
                                <tr>
                                    <th class="files">첨부파일</th>
                                    <td colspan="3">
                                        <input type="file" name="file" />
                                    </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="4">
                                        <textarea class="content" name="content" placeholder="상세 설명"
                                            style="width: 900px; height: 500px; resize: none;"></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                    </form>
                </section>
                <section class="buttons">
                    <h1 class="d-none">버튼</h1>
                    <input class="button" type="submit" value="등록" />
                    <a class="button cancle-button" href="list">취소</a>
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