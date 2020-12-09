<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Product Main</title>
	<link rel="stylesheet" href="../../../css/admin/shop/board/detail.css">
	<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
	<header class="header">
		<h1>
			<a href="../../index">logo</a>
		</h1>

		<nav>
			<!-- <h1>메뉴</h1> -->
			<ul>
				<li><a href="../../user/index">회원관리</a></li>
				<li><a href="../index">쇼핑몰</a></li>
				<li><a href="../../community/index">커뮤니티 게시글관리</a></li>
			</ul>
		</nav>
	</header>

	<div class="body">
		<div class="container">
			<h1 class="d-none">쇼핑몰 관리</h1>
			<aside class="aside">
				<nav>
					<h1 class="d-none">쇼핑몰관리 목록</h1>
					<ul>
						<li><i class="far fa-list-alt"></i> <a href="notice">공지사항
								관리</a></li>
						<li><i class="fas fa-clipboard-list"></i> <a href="product">상품문의 관리</a></li>
					</ul>
				</nav>
			</aside>

			<main class="main">
				<section>
					<h1>공지사항 관리</h1>
					<table border="1">

						<tr>
							<td>제목</td>
							<td>${b.title }</td>
							<td>작성자</td>
							<td>${b.writer }</td>
							<td>조회수</td>
							<td>${b.views }</td>
						</tr>

						<tr>
							<td>카테고리</td>
							<td>${b.category }</td>
							<td>작성날짜</td>
							<td>${b.regdate }</td>
							<td>파일경로</td>
							<td>${b.image }</td>
						</tr>

						<tr>
							<td colspan="6" height="500px">${b.content }</td>
						</tr>

					</table>
					<div class="button-list">
                        <a href="notice">
                            <input class="buttons" type="button" value="취소">
                        </a>
                        <a href="edit">
                            <input class="buttons" type="button" value="수정">
                        </a>
                        <a href="del">
                            <input class="buttons" type="button" value="삭제">
                        </a>
                    </div>
				</section>

			</main>
		</div>
	</div>

	<footer class="footer">
		<h1>Footer</h1>
	</footer>
</body>

</html>