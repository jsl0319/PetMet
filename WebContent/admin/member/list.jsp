<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <header id="header" class="header">
        <div class="container">
            <div class="logo">
                <a href="../index.html">
                    <i class="fas fa-dog fa-3x"></i>
                    <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                    <li>
                        <a href="list">
                            <i class="fas fa-users fa-2x"></i>
                            <span>MEMBER</span>
                        </a>
                    </li>
                    <li>
                        <a href="../feed/index.html">
                            <i class="fas fa-camera-retro fa-2x"></i>
                            <span>FEED</span>
                        </a>
                    </li>
                    <li>
                        <a href="../community/index.html">
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
        </div>
    </header>


    <div class="body">
        <div class="container">
            <aside class="aside">
                <h1 class="d-none">페이지 목록</h1>
                <ul>
                  <li><a href="list">회원 목록</a></li>
                  <li><a href="dog-list.html">강아지 목록</a></li>
                  <li><a href="matching-list.html">매칭 목록</a></li>
                  <li><a href="report-num-list.html">신고 목록</a></li>

                </ul>
              </aside>
            <main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form class="search__container">
                        <div>
                            <select class="search__title">
                                <option>닉네임</option>
                            </select>
                            <input type="text" class="search__input">
                        </div>

                        <label>가입일</label>
                        <input type="date">~
                        <input type="date">
                        <input type="submit" class="button" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td class="col-m">이메일</td>
                                <td>닉네임</td>
                                <td>성별</td>
                                <td class="col-m">주소</td>
                                <td class="col-m">휴대폰번호</td>
                                <td class="col-m">가입일</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach var="m" items="${list}">
                            <tr>
                                <td>${m.id}</td>
                                <td><a href="detail?id=${m.id}">${m.email}</a></td>
                                <td>${m.nickname}</td>
                                <td>                         
                                	<c:if test="${m.gender==1}">남</c:if>
                                	<c:if test="${m.gender==2}">여</c:if>
                                </td>
                                <td>${m.address}</td>
                                <td>${m.phone}</td>
                                <td>${m.regDate}</td>
                            </tr>
                          </c:forEach>
                        </tbody>
                    </table>

                </section>
                <div class="pager">
                    <div>
                      <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
                      <li><a href="#">1</a></li>
                    </ul>
                    <div>
                      <a href="#"><i class="fas fa-angle-right"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                  </div>
            </main>


        </div>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1>footer</h1>
        </div>

    </footer>

</body>

</html>