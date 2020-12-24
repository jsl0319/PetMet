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
  <jsp:include page="../../../inc/admin-header.jsp"></jsp:include>

    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">

            <aside class="aside">
                
                <h1 class="d-none">Aside 메뉴</h1>

                  <nav>
                    <h1 class= "d-none">세부 메뉴 목록</h1>

                    <ul>
                        <li>
                          
                            <a href="../notice/list">공지사항관리</a>
                        </li>

                        <li>
                            
                            <a href="../QnA/list">QnA 관리</a>
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
                          
                            <a href="../comment/list">댓글 관리</a>
                        </li>

                        <li>
                           
                            <a href="../comment/reported">신고된 댓글 관리</a>
                        </li>
                    </ul>
                </nav>
            </aside>
            <main class = "main">
            <form method="post" enctype="multipart/form-data">
                <h1>공지사항 상세 내용</h1>
                <section>
                <table class ="detail-table">
                    <tr>
                        <th>제목</th>
                     <td>  <input type="text" name="title" value="${n.title}" /></td>
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
                       <td colspan="4">
                                <textarea name = "content" style="width: 900px; height: 500px; resize: none;">
                                ${n.content}
                                </textarea>
                                </td>
                    </tr>
                </table>
                
            </section>
    
                <section class = "button-list">
                    <h1 class= "d-none">이벤트 버튼</h1>
    
                 <a href="list">  <input class="button" type="button" value="목록"></a>
         <input class="button" type="submit" value="수정완료">
                 <a href="del?id=${n.id}"><input class="button" type="button" value="삭제"></a>
                </section>
                </form>
            </main>

        </div>
    </section>






    <footer class="footer">
        <div class="container">
            <h1 class="d-none"></h1>
        </div>
    </footer>



</body>

</html>