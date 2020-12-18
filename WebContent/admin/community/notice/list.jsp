
<%@page import="com.petmet.web.entity.Notice"%>
<%@page import="com.petmet.web.service.NoticeService"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 공지사항 관리</title>

    <link rel="stylesheet" href="../../css/reset.css" type="text/css">

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
                <h1 class="d-none">헤더 메뉴 목록</h1>

                <ul>
                    <li>
                        <a href="list.html">
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
                    <h1 class= "d-none">세부 메뉴 목록</h1>

                    <ul>
                        <li>
                            <i class="fas fa-bullhorn"></i>
                            <a href="list.html">공지사항관리</a>
                        </li>

                        <li>
                            <i class="fas fa-bullhorn"></i>
                            <a href="../QnA/list.html">QnA 관리</a>
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
                        <input class="search__input" type="text" name= "q">
                        

                         <!-- <label class="search__title" >공개여부</label> -->
                         <input type="radio" id="cb1"  name ="p"  value = "0">
                         <label for="cb1"></label> <label class="search__title" >공개</label>
                         <input type="radio" id="cb2" name = "p" value = "1">
                         <label for="cb2"></label> <label class="search__title" >비공개</label>
                       

                         <label class="search__title" >일자</label>
                         <input class="search__input" type="date"name ="sd">~<input class="search__input" type="date" name="ed">
                         <input class="button" type="submit" value="검색">
     
                    </form>
                </section>

                <section>
                    <h1>공지사항 관리</h1>

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>조회수</td>
                                <td>공개여부</td>
                                <td>삭제</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="n" items="${list}">
                            <tr>
                                <td>${n.id}</td>
                  <td><a href="detail?id=${n.id}">${n.title}</a></td>

                                <td>${n.writerId}</td>
                                <td> ${n.regdate}</td>
                                <td>${n.hit}</td>
                                <td><input type="checkbox"></td>
                                <td><input type="checkbox"></td>
                                
                            </tr>
                                 </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">이벤트 버튼</h1>
                    <a href="pub?id"><input class="button" type="button" value="모두 공개"></a>
                    <a href="del?id=${n.id}"><input class="button" type="button" value="모두 삭제"></a>
                    <a href="reg"><input class="button" type="button" value="게시글 작성"></a>
                </section>

                <div class="pager">
                   <c:forEach var = "i" begin = "0" end="4" >
                  <li><a class="-text- orange bold" href="?p=1&t=&q=">${i+1}</a></li>
			   </c:forEach>
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