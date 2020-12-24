<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 > 커뮤니티 > 게시글 리스트</title>
<link rel="stylesheet" href="../../../css/style.css" type="text/css">
<link rel="stylesheet"
	href="../../../css/admin/components/table/list.css" type="text/css">
<link rel="stylesheet"
	href="../../../css/admin/components/form/default.css" type="text/css">
	<link rel="stylesheet" href="../../css/admin/components/feed.css">
<script src="https://kit.fontawesome.com/b280fc7aa7.js"
	crossorigin="anonymous"></script>
<script src="../../../js/admin/community/category/list.js"></script>
</head>

<body>
<div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
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
						<li><a href="../notice/list">공지사항관리</a></li>

						<li><a href="../QnA/list">QnA 관리</a></li>

						<li><a href="list">카테고리 관리</a></li>

						<li><a href="../board/list">게시글 관리</a></li>

						<li><a href="../board/reported">신고된 게시글 관리</a></li>

						<li><a href="../comment/list">댓글 관리</a></li>

						<li><a href="../comment/reported">신고된 댓글 관리</a></li>
					</ul>
				</nav>
			</aside>

			<!----------------------------------main--------------------------------------->
			<main class="main">
				<h1 class="d-none">Main Content</h1>
				
				<!-- <section class="main-section"> -->
					<section>
						<h1 class="d-none">게시글 리스트</h1>
	
						<input class="button addBtn" type="button" value="+ Add">
	
						<form action="list" method="post">
	
							<table class="list-table">
								<thead>
									<tr>
										<td>번호</td>
										<td class="col-l">카테고리명</td>
										<td class="col-m">게시글 수</td>
										<td>삭제</td>
									</tr>
								</thead>
	
								<tbody>
									<c:forEach var="c" items="${list }" varStatus="st">
										<tr ${st.count % 2==0?"class='even'":""}>
											<td>${c.num }</td>
											<td class="col-l">
												<input hidden type="text" name="id" value="${c.id }">
												<input type="text" name="name" value="${c.name }">
											</td>
											<td class="col-m">${c.cntBoard }</td>
											<td>
												<input name="del" value="${c.id }" type="checkbox">
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
					</section>
	
					<section>
						<h1 class="d-none">이벤트 버튼</h1>
	
						<input class="button" name="button" type="submit" value="저장">
	                    <input class="button" name="button" type="submit" value="삭제">
					</section>
					</form>
				<!-- </section> -->
				
				<c:set var="page" value="${(empty param.p)? 1 : param.p}"/>
				<c:set var="startNum" value="${page - (page-1)%5 }"/>
				<c:set var="lastNum" value="${tp }"/>
				<div class="pager">
					<c:if test="${1 <= startNum-5}">
						<div>
							<a href="?p=1"><i class="fas fa-angle-double-left"></i></a>
						</div>
						<div>
							<a href="?p=${startNum-5}"><i class="fas fa-angle-left"></i></a>
						</div>
					</c:if>
					<ul>
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${(startNum + i) <= lastNum }">
								<li><a href="?p=${startNum + i}">${startNum + i}</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<c:if test="${startNum+5 <= lastNum}">
						<div>
							<a href="?p=${startNum+5}"><i class="fas fa-angle-right"></i></a>
						</div>
						<div>
							<a href="?p=${lastNum }"><i class="fas fa-angle-double-right"></i></a>
						</div>
					</c:if>
				</div>
			</main>
		</div>
	</section>

	<footer class="footer">
		<div class="d-none">
			<h1></h1>
		</div>
	</footer>
	
</body>
</html>