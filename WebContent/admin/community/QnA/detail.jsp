<%@page import="com.petmet.web.entity.Question" %>
<%@page import="com.petmet.web.service.QuestionService" %>
<%@page import="com.petmet.web.entity.Answer" %>
<%@page import="com.petmet.web.service.AnswerService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > QnA > 답변등록</title>

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
                    <a href="../user/index">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="index">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="../community/notice/list">
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
                                <a href="../notice/list">공지사항관리</a>
                            </li>

                            <li>
                                <i class="fas fa-bullhorn"></i>
                                <a href="list">QnA 관리</a>
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


       
    

    
    <main class = "main">
        <h1>QnA 상세페이지</h1>
        <section>
        <table class="detail-table">
         
            <tr>
                <th>제목</th>
                <td colspan="3">${q.title}</td>
            </tr>

            <tr>
                <th>작성자</th>
                <td >${q.writerId}</td>
                <th>등록일</th>
                <td>${q.regDate}</td>
            </tr>
            
            <tr>
                <th>공개</th>
                <td>${q.pub}</td>
           
            </tr>

          

            <tr class="content">
                <td colspan="4">${q.content}</td>
            </tr>
        </table>
    </section>
           
            <section>
        <form method="post">
     
                <table class= "detail-table">
                    <tr>
                    <th>관리자 답변<th>
                    </tr>
                 <tr class="content">
                 
                     <td><textarea name = "content" style="width: 900px; height: 200px; resize: none;">${a.content}</textarea></td>
                 </tr>
        </table>
           </section>
        

        <section>
            <h1 class="d-none">이벤트 버튼</h1>

           <a href="list">     <input class="button"type="button" value="목록"></a>
            <input  class="button" type="submit" value="등록">
        </section>
      
       </form>

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