<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 펫플레이스 > 리스트</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/admin/components/table/list.css">
    <link rel="stylesheet" href="../../css/admin/components/form/default.css">
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
                        <a href="../feed/list">
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

                <section class="search-form">

                    <h1 class="d-none">검색폼</h1>

                    <form>

                        <select>
                            <option>이름</option>
                            <option>내용</option>
                            <option>지역</option>
                            <option>카테고리</option>
                        </select>

                        <input type="text">
                        <input type="submit" value="검색">
                    </form>

                </section>

                <section>
                    <h1 class="d-none">Pet Place 관리</h1>

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td class="col-l">이름</td>
                                <td class="col-s">작성자</td>
                                <td class="col-m">작성일</td>
                                <td>조회수</td>
                                <td class="col-m">공개여부</td>
                                <td>삭제</td>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="p" items="${list }">
	                            <tr>
	                                <td>${p.num }</td>
	                                <td><a href="detail?id=${p.id }">${p.name }</a></td>
	                                <td>${p.writerId }</td>
	                                <td>${p.regDate }</td>
	                                <td>${p.hit }</td>
	                                <td><input type="checkbox"></td>
	                                <td><input type="checkbox"></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">버튼</h1>
                    <a class="button" href="reg">Pet Place 등록</a>
                    <input class="button" type="submit" value="선택 공개">
                    <input class="button" type="submit" value="선택 삭제">
                </section>

                <section>
                    <div class="pager">
                        <div>
                            <a href="#"><i class="fas fa-angle-double-left"></i></a>
                        </div>
                        <div>
                            <a href="#"><i class="fas fa-angle-left"></i></a>
                        </div>
                        <ul>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                        </ul>
                        <div>
                            <a href="#"><i class="fas fa-angle-right"></i></a>
                        </div>
                        <div>
                            <a href="#"><i class="fas fa-angle-double-right"></i></a>
                        </div>
                    </div>
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