<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet">
<link href="../css/admin/layout/index.css" type="text/css"
	rel="stylesheet">
<link href="../css/admin/content-layout/index.css" type="text/css"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/admin/components/feed.css">
<link rel="stylesheet"
	href="../../../css/admin/components/table/list.css" type="text/css">
<link href="../css/admin/ji.css" type="text/css" rel="stylesheet">
<script src="https://kit.fontawesome.com/b280fc7aa7.js"
	crossorigin="anonymous"></script>
<script src="../js/admin/index.js"></script>


</head>

<body>

	<jsp:include page="../inc/admin-header.jsp"></jsp:include>
	<div class="neon circle"></div>
	<div class="neon circle"></div>
	<div class="neon square"></div>
	<div class="neon square2"></div>
	<div class="neon tri"></div>
	<div class="neon tri2"></div>



	<div class="body">
		<main id="main" class="main">
			<h1 class="d-none">메인이다</h1>
			<section class="main1">
				<div class="container">
					<h1 class="d-none">유저방문 & 매칭 횟수</h1>
					<section>
						<h1 class="d-none">숫자</h1>

						<button class="buttonload1">
							<i class="fa fa-refresh fa-spin"></i>매칭 등록
						</button>

						<button class="buttonload2">
							<i class="fa fa-refresh fa-spin"></i>리뷰 건수
						</button>


					</section>
					<section class="graph">
						<h1 class="d-none">그래프</h1>
						<canvas width="600px" height="400px"></canvas>
					</section>
				</div>
			</section>

			<section class="main2">
				<div class="container">
					<h1 class="d-none">그 외의 정보들</h1>
					<section>
						<h1 class="title">Notice</h1>
						<table class="list-table">
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>조회수</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${nList}" varStatus="st">
									<tr ${st.count % 2==0?"class='even'":""}>
										<td>${n.id}</td>
										<td><a href="detail?id=${n.id}">${n.title}</a></td>
										<td>${n.writerId}</td>
										<td>${n.regdate}</td>
										<td>${n.hit}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</section>

					<section>
						<h1 class="title">Question</h1>
						<table class="list-table">
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>등록일</td>
									<td>답변</td>
									<td>답변일자</td>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="q" items="${qList}" varStatus="st">
									<tr ${st.count % 2==0?"class='even'":""}>
										<td>${q.id}</td>
										<td><a href="detail?id=${q.id}">${q.title}</a></td>
										<td>${q.writerId}</td>
										<td>${q.regDate}</td>
										<td>${q.isAnswer}</td>
										<td>${q.anDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</section>
				</div>
			</section>
		</main>

	</div>

	<footer id="footer" class="footer">

		<div class="container">
			<h1 class="d-none"></h1>
		</div>

	</footer>

</body>

</html>