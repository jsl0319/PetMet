
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
                        <a href="../notice/list">
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
                            <a href="../notice/list">공지사항관리</a>
                        </li>

                        <li>
                            <i class="fas fa-bullhorn"></i>
                            <a href="../QnA/list">QnA 관리</a>
                        </li>

                        <li>
                            <i class="fas fa-clipboard-list"></i>
                            <a href="../category/list">카테고리 관리</a>
                        </li>

                        <li>
                            <i class="fas fa-clipboard-list"></i>
                            <a href="../board/list">게시글 관리</a>
                        </li>

                        <li>
                            <i class="fas fa-ban"></i>
                            <a href="../board/reported">신고된 게시글 관리</a>
                        </li>

                        <li>
                            <i class="fas fa-comment"></i>
                            <a href="../comment/list">댓글 관리</a>
                        </li>

                        <li>
                            <i class="fas fa-comment-slash"></i>
                            <a href="../comment/reported">신고된 댓글 관리</a>
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
                        <input class="search__input" type="text" name= "q" value="${param.q}">
                        

                  

                         <label class="search__title" >일자</label>
                         <input class="search__input" type="date"name ="sd" value="${param.sd}">~<input class="search__input" type="date" name="ed"  value="${param.ed}">
                         <input class="button" type="submit" value="검색">
     
                    </form>
                </section>

                <section>
                    <h1>공지사항 관리</h1>
                    <form method="post" action="list">

                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>조회수</td>
                                
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
                         
                         
                                <td><input name="del-id" value ="${n.id}" type="checkbox"></td>
                                
                            </tr>
                                 </c:forEach>
                        </tbody>
                    </table>
                
                </section>

                <section>
                    <h1 class="d-none">이벤트 버튼</h1>
                  
                   <input class="button" type="submit" value="모두 삭제">
                    
                    <a href="reg"><input class="button" type="button" value="게시글 작성"></a>
                </section>
 				</form>
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
            <h1>Footer</h1>
        </div>
    </footer>

</body>

</html>