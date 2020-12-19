<%@page import="com.petmet.web.entity.Question"%>
<%@page import="com.petmet.web.entity.Answer"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티> QnA관리 > 리스트 </title>

    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <link rel="stylesheet" href="../../../css/style.css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">

    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
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
                    <a href="../user/index.html">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
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
                    <a href="../petplace/list.html">
                      <i class="fas fa-map-marked-alt fa-2x"></i>
                      <span>PLACE</span>
                    </a>
                  </li>
                </ul>
              </nav>
        </div>
    </header>

    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">

            <aside class="aside">
                
                <h1 class="d-none">Aside 메뉴</h1>

                    <nav>
                        <h1 class="d-none" >세부 메뉴 목록</h1>

                        <ul>

                            <li>
                                <i class="fas fa-bullhorn"></i>
                                <a href="../notice/list.html">공지사항관리</a>
                            </li>

                            <li>
                                <i class="fas fa-bullhorn"></i>
                                <a href="list.html">QnA 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-clipboard-list"></i>
                                <a href="../category/list.html">카테고리 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-clipboard-list"></i>
                                <a href="../board/list.html">게시글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-ban"></i>
                                <a href="../board/reported.html">신고된 게시글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-comment"></i>
                                <a href="../comment/list.html">댓글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-comment-slash"></i>
                                <a href="../comment/reported.html">신고된 댓글 관리</a>
                            </li>
                        </ul>
                    </nav>
            </aside>

            <main class="main">
                <h1 class="d-none">Main Content</h1>

                <section>
                    <h1 class="d-none">검색폼</h1>

                    <form class="search__container">

                        <label class="search__title">제목</label>
                        <input class="search__input" type="text">


                        <!-- <label class="search__title" >공개여부</label> -->
                        <input type="checkbox" id="cb1">
                        <label for="cb1"></label> <label class="search__title">공개</label>
                        <input type="checkbox" id="cb2">
                        <label for="cb2"></label> <label class="search__title">비공개</label>


                        <label class="search__title">일자</label>
                        <input class="search__input" type="date">~<input class="search__input" type="date">
                        <input class="button" type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <br>
                    <h1>게시글 리스트</h1>

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>공개</td>
                                <td>답변</td>
                                <td>답변일자</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="q" items="${qlist}">
                         <tr>
                            <td>${q.id}</td>
                            <td><a href="detail?id=${q.id}">${q.title}</a></td>
                            <td>${q.writerId}</td>
                            <td>${q.regDate}</td>
                            <td>${q.pub}</td>
                            <td>${q.isAnswer}</td>
                            <td>${q.anDate}</td>
                            </tr>
                             </c:forEach>
                        </tbody>
                    </table>
                </section>


              <c:set var="page" value="${(param.p==null)?1:param.p}"/>
				<c:set var="startNum" value="${page-(page-1)%5}"/>
                <div class="pager">
                    <div>
                      <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
                    <c:forEach var="i" begin="0" end="4">		
						<li><a href="?p=${startNum+i}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}" >${startNum+i}</a></li>
					</c:forEach>
					</ul>
                    <div>
                      <a href="?p=${startNum+5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
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
            <h1 class="d-none">Footer</h1>
        </div>
    </footer>



</body>

</html>