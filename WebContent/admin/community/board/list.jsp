<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- 
    자바스크립트 넣을 부분
    1. 데이터 수정 시 수정된 레코드들 표시

 -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 게시글 리스트</title>
    <link rel="stylesheet" href="../../../css/style.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/category-select.css" type="text/css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <script src="list.js"></script>
</head>

<body>
	<!----------------------------------header--------------------------------------->
    <header class="header">
        <div class="container">
            <div class="logo">
                <a href="../../index">
                  <i class="fas fa-dog fa-3x"></i>
                  <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                  <li>
                    <a href="../../member/list">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../feed/list">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="../notice/list">
                      <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                      <span>COMMUNITY</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../petplace/list">
                      <i class="fas fa-map-marked-alt fa-2x"></i>
                      <span>PLACE</span>
                    </a>
                  </li>
                </ul>
            </nav>

            <!-- <nav>
                <h1>바로가기 메뉴</h1>
                <ul>
                    <li><a href>펫멧이동</a></li>
                    <li><a href>로그아웃</a></li>
                </ul>
            </nav> -->
        </div>
    </header>

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
            <main class="main">
                <h1 class="d-none">Main Content</h1>

                <section>
                    <h1 class="d-none">검색폼</h1>
                    
                    <form class="search__container" action="list">
                        <select class="selectbox" name="f">
                            <option ${(param.f == "title")?"selected":"" } value="title">제목</option>
                            <option ${(param.f == "writer_id")?"selected":"" } value="writer_id">작성자</option>
                        </select>
                        <input class="search__input" name="q" type="text" value="${param.q }">
                        
                        <select class="selectbox" name="b">
                            <option>모든 게시판</option>
                            <c:forEach var="c" items="${cList }">
	                            <option ${(param.b == c.name)? "selected" : "" } value="${c.name }">${c.name }</option>
                            </c:forEach>
                        </select>
                        
                        <label class="search__title" for="date">일자</label>
                        <input class="search__input" name="sd" type="date" value="${param.sd }">
                         - 
                        <input class="search__input" name="ed" type="date" value="${param.ed }">
                        
                        <input class="button" type="submit" value="검색">
                        
                        <div>
	                        <select name="s">
	                            <option ${(param.s == "20")? "selected" : "" } value="20">20개</option>
	                            <option ${(param.s == "50")? "selected" : "" } value="50">50개</option>
	                            <option ${(param.s == "100")? "selected" : "" } value="100">100개</option>
	                        </select>
	                    </div>
                    </form>
                </section>

                <section>
                    <h1 class="d-none">게시글 리스트</h1>

                    <form action="list" method="post">
                    
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>작성자</td>
                                <td>카테고리</td>
                                <td>제목</td>
                                <td>댓글수</td>
                                <td>작성일</td>
                                <td>조회수</td>
                                <td>파일</td>
                                <td>삭제</td>
                            </tr>
                        </thead>

                        <tbody>
	                        <c:forEach var="b" items="${list }" varStatus="st">
	                            <tr ${st.count % 2==0?"class='even'":""}>
	                            	<input hidden name="id" value="${b.id }">
	                                <td>${b.num }</td>
	                                <td>${b.writerId }</td>
	                                <td>
                                        <input hidden type="text" name="id" value="${b.id }">
	                                	<select name="name">
		                                	<c:forEach var="c" items="${cList }">
		                                		<c:choose>
		                                			<c:when test="${b.categoryId eq c.id }">
		                                				<option value="${c.id }" selected>${c.name }</option>
		                                			</c:when>
		                                			<c:otherwise>
		                                        		<option value="${c.id }">${c.name }</option>
		                                        	</c:otherwise>
		                                        </c:choose>
	                                    	</c:forEach>
	                                    </select>
	                                </td>
	                                <td><a href="detail?id=${b.id }">${b.title }</a></td>
	                                <td>${b.cmtCnt }</td>
	                                <td>${b.regDate }</td>
	                                <td>${b.hit }</td>
	                                <td>${b.files }</td>
	                                <td><input name="del" value="${b.id }" type="checkbox">
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
                
                <c:set var="page" value="${(empty param.p)?1:param.p }"/>
                <c:set var="startNum" value="${page-(page-1)%5}"/>
                <c:set var="lastNum" value="${tp }"/>
                <div class="pager">
	                <c:if test="${1 <= startNum-5}">
	                    <div>
	                      <a href="?p=1"><i class="fas fa-angle-double-left"></i></a>
	                    </div>
	                    <div>
	                      <a href="?p=${startNum - 5 }"><i class="fas fa-angle-left"></i></a>
	                    </div>
                    </c:if>
                    <ul>
                    	<c:forEach var="i" begin="0" end="4">
							<c:if test="${(startNum + i) <= lastNum }">
								<li><a href="?p=${startNum + i}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}&s=${param.s}">${startNum + i}</a></li>
							</c:if>
						</c:forEach>
                    </ul>
                    
                    <c:if test="${startNum+5 <= lastNum}">
	                    <div>
	                      <a href="?p=${startNum+5}&f=${param.f}&q=${param.q}&sd=${param.sd}&ed=${param.ed}"><i class="fas fa-angle-right"></i></a>
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
        <div class="container">
            <h1 class="d-none">Footer</h1>
        </div>
    </footer>

</body>
</html>