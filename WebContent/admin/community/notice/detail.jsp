<%@page import="com.petmet.web.entity.Notice" %>
<%@page import="com.petmet.web.service.NoticeService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 공지사항관리 > 상세페이지</title>

    <link rel="stylesheet" href="../../../css/admin/components/table/detail.css" type="text/css">
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
            <main class = "main">
                <h1>공지사항 상세 내용</h1>
                <section>
                <table class ="detail-table">
                    <tr>
                        <th>제목</th>
                        <td colspan="3">${n.title}</td>
                    </tr>
    
                    <tr>
                        <th>등록일</th>
                       <td> <fmt:formatDate value="${n.regdate}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
                       
                            
                    </tr>
    
                    <tr>
    
                    <th>첨부파일</th>
                    <td>
                    <c:forTokens var="fileName" items="${n.files}" delims="," varStatus = "st">
                                   <fmt:formatDate value="${n.regdate}" pattern="yyyy"/>
                                      <a download href="/static/notice/2020/${n.id}/${fileName}">${fileName} </a> 
                                      <c:if test = "${st.last==false }">
                                      /
                                      </c:if>
                                   </c:forTokens>
                 </td>
                </tr>
                    <tr class="content">
                        <td colspan="4">${n.content}</td>
                    </tr>
                </table>
            </section>
    
                <section class = "button-list">
                    <h1 class= "d-none">이벤트 버튼</h1>
    
                 <a href="list">  <input class="button" type="button" value="목록"></a>
               		<a href="edit?id=${n.id}">     <input class="button" type="button" value="수정"></a>
                 <a href="del?id=${n.id}"><input class="button" type="button" value="삭제"></a>
                </section>
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