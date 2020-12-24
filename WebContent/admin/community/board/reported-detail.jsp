<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width>, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 게시글 리스트/신고된 게시글 관리 > 디테일</title>
    <link rel="stylesheet" href="../../../css/style.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/table/detail.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">
	<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
	<!----------------------------------header--------------------------------------->
    <jsp:include page="../../../inc/admin-header.jsp"></jsp:include>

	<!----------------------------------body--------------------------------------->
    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">
        	<!----------------------------------aside--------------------------------------->
            <aside class="aside">
                <h1 class="d-none">Aside 메뉴</h1>

                <nav>
                    <h1 class="d-none">세부 메뉴 목록</h1>

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
                            <a href="list">게시글 관리</a>
                        </li>

                        <li>
                            <a href="reported">신고된 게시글 관리</a>
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

			<!----------------------------------main--------------------------------------->
            <main class = "main">
                <h1 class="d-none">게시글/신고된 게시글 상세 내용</h1>
                
                <!-- <section class="main-section"> -->
	                <section>
	                    <h1>신고된 게시글</h1>
	                    
	                    <table class="detail-table">
	                        <tr>
	                            <th>제목</th>
	                            <td colspan="3">${b.title }</td>
	                        </tr>
	                        
	                        <tr>
	                            <th>작성자</th>
	                            <td>${b.writerId }</td>
	                            <th>카테고리</th>
	                            <td>${b.categoryName }</td>
	                        </tr>
	                    </table>
	                </section>
	                <section>
	                    <h1>신고 리스트</h1>
	                    <table class="list-table">
	                        <thead>
	                            <tr>
	                                <td>번호</td>
	                                <td>신고자 닉네임</td>
	                                <td>신고 내용</td>
	                                <td>신고일</td>
	                            </tr>
	                        </thead>
	                        <tbody>
		                        <c:forEach var="r" items="${list }" varStatus="st">
		                        	<tr ${st.count % 2==0?"class='even'":""}>
		                                <td>${r.id }</td>
		                                <td>${r.memId }</td>
		                                <td>${r.content }</td>
		                                <td>${r.regDate }</td>
		                            </tr>
		                        </c:forEach>
	                        </tbody>
	                    </table>
	                </section>
				
	                <section>
	                    <h1 class="d-none">페이저</h1>
	                    <ul>
	                        <li><a href="reported-detail?next=${b.id }">다음 게시글</a></li>
	                        <li><a href="reported-detail?prev=${b.id }">이전 게시글</a></li>
	                    </ul>
	                </section>
                
	                <form action="reported-detail" method="post">
	                <input hidden name="id" value="${b.id }">
	                <section>
	                    <h1 class="d-none">이벤트 버튼</h1>
	                    
	                    <a href="reported">
	                        <input class="button" type="button" value="목록">
	                    </a>
	                    <input class="button" type="submit" value="삭제">
	                </section>
	                </form>
 				<!-- </section> -->
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