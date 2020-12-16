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
    <!-- <link rel="stylesheet" href="../../css/admin/community/index.css" type="text/css"> -->
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>

</head>

<body>
    <header class="header">
        <h1><a href="../index.html">logo</a></h1>

        <nav>
            <h1>헤더 메뉴 목록</h1>

            <ul>
                <li><a href="../user/index.html">User</a></li>
                <li><a href="../feed/index.html">Feed</a></li>
                <li><a href="../index.html">Community</a></li>
                <li><a href="../place/index.html">Place</a></li>
            </ul>
        </nav>

        <nav>
            <h1>바로가기 메뉴</h1>
              
                    <il><a href="">로그아웃</a></li>
            
        </nav>
    </header>

    <section class="body">
        <h1>Content Body</h1>

        <aside class="aside">
            <h1>Aside 메뉴</h1>

            <nav>
                <h1>세부 메뉴 목록</h1>

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
            <h1>Main Content</h1>

            <section>
                <h1>검색폼</h1>

                <form>
                    <label for="title">제목</label>
                    <input type="text" id="title">
                    <label for="date">일자</label>
                    <input type="date">~<input type="date">
                    <input type="button" value="검색">
                </form>
            </section>

            <section>
                <h1>공지사항 관리</h1>

                <table border="1">
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
                            <td><a href="detail?id=${n.id}">${n.title}></a></td>
                            <td>${n.writerId}</td>
                            <td>${n.regdate}</td>
                            <td>${n.hit}</td>
                            <td><input type="checkbox"></td>
                            <td><input type="checkbox"></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>

            <section>
                <h1>이벤트 버튼</h1>
                <a href=""><input type="button" value="모두 공개"></a>
                <a href=""><input type="button" value="모두 삭제"></a>
                <a href="reg.html"><input type="button" value="게시글 작성"></a>
            </section>

            <section>
                <h1>페이지 목록</h1>
               
                    이전
                    <ul>
                    <c:forEach begin = "0" end="4" varStatus="st">
                        <li><a href="?p=1&t=&q=">${i+1}</a></li>
                       </c:forEach>
                    </ul>
                    다음 
            </section>


        </main>
    </section>

    <footer class="footer">
        <h1>Footer</h1>
    </footer>

</body>
</html>