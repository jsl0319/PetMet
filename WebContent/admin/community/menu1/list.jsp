<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>
	<header>
		<h1>
			<a href="../../index.html">logo</a>
		</h1>

		<nav>
			<h1>메뉴</h1>
			<ul>
				<li><a href="../../index.html">Home</a></li>
				<li><a href="../../match/list.html">Match</a></li>
				<li><a href="../index.html">Community</a></li>
				<li><a href="../../shop/index.html">Shop</a></li>
				<li><a href="../../user/index.html">Login</a></li>
				<li><a href="../../myfeed/index.html">My Page</a></li>
			</ul>
		</nav>
	</header>

	<nav id="aside">
		<h1>커뮤니티 메뉴</h1>
		<ul>
			<li><a href="../notice/list.html">공지사항</a></li>
			<li><a href="list.html">메뉴1</a></li>
		</ul>
	</nav>

	<section>
		<main id="main">
			<h1>커뮤니티</h1>

			<section>
				<h1>메뉴1</h1>
				<table border="1">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
							<td>좋아요</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="b" items="${list}">
						<tr>
							<td>${b.id}</td>
							<td><a href="detail?id=${b.id}">${b.title}</a></td>
							<td>${b.writer}</td>
							<td>${b.regdate}</td>
							<td>${b.views}</td>
							<td>${b.likes}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</section>

			<div>
				<input type="button" value="글쓰기" onclick="location.href='reg'">
			</div>

			<section>
				<h1>검색</h1>
				<form>
					<select>
						<option>전체기간</option>
						<option>1주</option>
						<option>1개월</option>
						<option>6개월</option>
					</select> <select>
						<option>제목</option>
						<option>내용</option>
						<option>제목 + 내용</option>
						<option>작성자</option>
					</select> <input type="text"> <input type="submit" value="검색">
				</form>
			</section>

			<section>
				<h1>페이지 정보</h1>
				<div>1 / 5 pages</div>
			</section>

			<section>
				<h1>페이지 목록</h1>
				<div>
					이전
					<ul>
						<li>1</li>
						<li>2</li>
						<li>3</li>
						<li>4</li>
						<li>5</li>
					</ul>
					다음
				</div>
			</section>

		</main>
	</section>

	<section>
		<footer id="footer">
			<h1>푸터푸터푸터</h1>
		</footer>
	</section>
</body>

</html>