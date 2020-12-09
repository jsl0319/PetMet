<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Main</title>
<link rel="stylesheet" href="../../../css/reset.css">
<link rel="stylesheet" href="../../../css/admin/shop/board/product.css">
<script src="https://kit.fontawesome.com/b280fc7aa7.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<header class="header">
		<h1>
			<a href="../index.html">logo</a>
		</h1>

		<nav>
			<h1 class="d-none">메뉴</h1>
			<ul>
				<li><a href="../../user/index.html">회원관리</a></li>
				<li><a href="../index.html">쇼핑몰</a></li>
				<li><a href="../../community/index.html">커뮤니티 게시글관리</a></li>
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
						<li><i class="far fa-list-alt"></i> <a href="notice.html">공지사항
								관리</a></li>
						<li><i class="fas fa-clipboard-list"></i> <a
							href="product.html">상품문의 관리</a></li>
					</ul>
				</nav>
			</aside>

			<main class="main">

				<section>
					<h1>상품문의</h1>
					<table border="1">
						<thead>
							<tr>
								<td>No</td>
								<td>상품정보</td>
								<td>제목</td>
								<td>작성자</td>
								<td>등록일</td>
								<td>조회</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>null</td>
								<td>null</td>
								<td>널</td>
								<td>널</td>
								<td>널럴</td>
								<td>널널</td>
							</tr>
							<tr>
								<td>null</td>
								<td>null</td>
								<td>널</td>
								<td>널</td>
								<td>널럴</td>
								<td>널널</td>
							</tr>
						</tbody>

					</table>
					<div class="reg-button">
						<a href="reg.html"><input type="button" value="등록"></a>
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