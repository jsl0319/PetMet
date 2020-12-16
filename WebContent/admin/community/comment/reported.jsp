<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 신고된 댓글 관리</title>
    <link rel="stylesheet" href="../../../css/style.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/category-select.css" type="text/css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>

</head>

<body>
    <header class="header">
        <div class="container">
            <div class="logo">
                <a href="../../index.html">
                  <i class="fas fa-dog fa-3x"></i>
                  <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                  <li>
                    <a href="../../user/index.html">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../feed/index.html">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="../index.html">
                      <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                      <span>COMMUNITY</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../petplace/index.html">
                      <i class="fas fa-map-marked-alt fa-2x"></i>
                      <span>PLACE</span>
                    </a>
                  </li>
                </ul>
            </nav>

            <!-- <nav>
                <h1>바로가기 메뉴</h1>
                <ul>
                    <li><a href>펫멧이동</a></li>
                    <li><a href>로그아웃</a></li>
                </ul>
            </nav> -->
        </div>
    </header>

    <section class="body">
        <h1 class="d-none">Content Body</h1>

        <div class="container">
            <aside class="aside">
                <h1 class="d-none">Aside 메뉴</h1>

                <nav>
                    <h1 class="d-none">세부 메뉴 목록</h1>

                    <ul>
                        <li>
                            <a href="../notice/list.html">공지사항관리</a>
                        </li>

                        <li>
                            <a href="../QnA/list.html">QnA 관리</a>
                        </li>

                        <li>
                            <a href="../category/list">카테고리 관리</a>
                        </li>
                        
                        <li>
                            <a href="../board/list">게시글 관리</a>
                        </li>

                        <li>
                            <a href="../board/reported">신고된 게시글 관리</a>
                        </li>

                        <li>
                            <a href="list">댓글 관리</a>
                        </li>

                        <li>
                            <a href="reported">신고된 댓글 관리</a>
                        </li>
                    </ul>
                </nav>
            </aside>

            <main class="main">
                <h1 class="d-none">Main Content</h1>

                <section>
                    <h1 class="d-none">검색폼</h1>

                    <form class="search__container" method="post">
                        <select class="selectbox" name="search">
                            <option value="게시글 제목">게시글 제목</option>
                            <option value="작성자">작성자</option>
                            <option value="내용">내용</option>
                        </select>
                        <input class="search__input" name="query" type="text">
                        <select class="selectbox" name="category">
                            <option>게시판</option>
                            <c:forEach var="c" items="${cList }">
                            	<option value="${c.name }">${c.name }</option>
                            </c:forEach>
                        </select>
                        <label class="search__title" for="date">일자</label>
                        <input class="search__input" type="date" name="start_date"> - <input class="search__input" type="date" name="end_date">
                        <input class="button" type="submit" value="검색">
                    </form>
                </section>

                <section>
                    <h1 class="d-none">신고된 댓글 관리</h1>
                    <div>
                        <select>
                            <option value="20개">20개</option>
                            <option value="50개">50개</option>
                            <option value="50개">100개</option>
                        </select>
                    </div>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>카테고리</td>
                                <td>게시글 번호</td>
                                <td>게시글 제목</td>
                                <td>작성자</td>
                                <td>내용</td>
                                <td>작성일</td>
                                <td>누적 신고 횟수</td>
                                <td>삭제</td>
                            </tr>
                        </thead>

                        <tbody>
	                        <c:forEach var="c" items="${list}">
	                            <tr>
	                                <td>${c.id }</td>
	                                <td>${c.categoryId }</td>
	                                <td>${c.boardId }</td>
	                                <td><a href="../board/detail?id=${c.boardId }">${c.title }</a></td>
	                                <td>${c.writerId }</td>
	                                <td><a href="detail?id=${c.id }&bId=${c.boardId}">${c.content }</a></td>
	                                <td>${c.regDate }</td>
	                                <td><a href="reported-detail?id=${c.id }">${c.reported }</a></td>
	                                <td><input type="checkbox"></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">이벤트 버튼</h1>

                    <input class="button" type="submit" value="삭제">
                </section>

                <div class="pager">
                    <div>
                      <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
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
    </section>

    <footer class="footer">
        <div class="container">
            <h1>Footer</h1>
        </div>
    </footer>

</body>
</html>