<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 수정</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/detail.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
    <link rel="stylesheet" href="edit.css">
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
                    <h1 class="title">PetPlace 수정</h1>

                    <form action="edit" method="post" enctype="multipart/form-data">

                        <table class="detail-table">
                            <tbody>
                                <tr>
                                    <th>이름</th>
                                    <td colspan="3">
                                        <input type="text" name="name" value="${pp.name}" />
                                    </td>
                                    <th>카테고리</th>
                                    <td>
                                        <select name="categoryId">
                                            <c:forEach var="ppc" items="${list}">
                                                <option value="${ppc.id}"
                                                    ${pp.categoryId==ppc.id?"selected":""}>${ppc.name}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>주소</th>
                                    <td colspan="3"><input type="text" name="address" value="${pp.address}">
                                    </td>
                                    <th>공개 여부</th>
                                    <td>
                                        <select name="pub">
                                            <option value="1" ${pp.pub==1?"selected":""}>공개</option>
                                            <option value="0" ${pp.pub==0?"selected":""}>비공개</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>홈페이지</th>
                                    <td colspan="3"><input type="text" name="homepage"
                                            value="${pp.homepage}"></td>
                                    <th>전화번호</th>
                                    <td><input type="text" name="phone" value="${pp.phone }"></td>
                                </tr>
                                <tr>
                                    <th>작성일</th>
                                    <td colspan="5">
                                        <fmt:formatDate value="${pp.regDate}"
                                            pattern="yyyy-MM-dd a hh:mm:ss" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>작성자</th>
                                    <td>${pp.writerName}</td>
                                    <th>조회수</th>
                                    <td>${pp.hit}</td>
                                    <th>좋아요</th>
                                    <td>${pp.likes}</td>
                                </tr>
                                <tr>
                                    <th class="files">첨부파일</th>
                                    <td colspan="5">
                                        <input type="file" name="file" />
                                    </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="6">
                                        <textarea class="content" name="location"
                                            style="width: 900px; height: 100px; resize: none;">${pp.location}</textarea>
                                    </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="6">
                                        <textarea class="content" name="content"
                                            style="width: 900px; height: 500px; resize: none">${pp.content}</textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>


                    </form>
                </section>
                <section class="buttons">
                    <input type="hidden" name="id" value="${pp.id}">
                    <a class="button" href="detail?id=${pp.id}">취소</a>
                    <input class="button" type="submit" value="수정 완료" />
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