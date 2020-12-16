<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/style.css">
  <link rel="stylesheet" href="../../css/admin/components/table/list.css">
  <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  <title>FEED-detail</title>
</head>
<body>

    <!----------------------------------header--------------------------------------->
    <header id="header" class="header">
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
              <a href="../member/list">
                <i class="fas fa-users fa-2x"></i>
                <span>USER</span>
              </a>
            </li>
            <li>
              <a href="list">
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

    <!----------------------------------body--------------------------------------->
     <div class="body">
        <h1 class="d-none">contents body</h1>

        <div class="container">

            <aside class="aside">
                <h1 class="d-none">aside</h1>

                <nav>
                    <h1 class="d-none">세부 메뉴</h1>

                    <ul>
                        <li>
                            <i class="fas fa-map-marked-alt"></i>
                            <a href="list">&nbsp;&nbsp;Pet Place 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-chalkboard"></i>
                            <a href="category/list">&nbsp;&nbsp;카테고리 관리</a>
                        </li>
                        <li>
                            <i class="fas fa-clipboard"></i>
                            <a href="review/list">&nbsp;&nbsp;후기 관리</a>
                        </li>
                    </ul>
                </nav>

            </aside>

            <main class="main">
                <h1 class="d-none">main</h1>

                <section>
                    <h1>Pet Place 관리</h1>

                    <table class="detail-table">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td colspan="3">${p.name }</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td>
                                	<fmt:formatDate value="${p.regDate }" pattern="yyyy-MM-dd a hh:mm:ss" /> 
                                </td>
                                <th>조회수</th>
                                <td>${p.hit }</td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>${p.writerId }</td>
                                <th>좋아요</th>
                                <td>${p.likes }</td>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td colspan="3">
                                	<c:forTokens var="fileName" items="${p.files}" delims="," varStatus="st">
										<fmt:formatDate var="year" value="${p.reDdate }" pattern="yyyy" /> 
                                      		<a download href="/static/notice/${year }/${n.id}/${fileName}">${fileName}</a>
                                      	<c:if test="${st.last == false}">
                                      	 / 
                                      	</c:if>
                                   	</c:forTokens>
                                </td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">지도</td>
                            </tr>
                            <tr class="content">
                                <td colspan="4">${p.content }</td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">버튼</h1>
                    <a class="button" href="list">목록</a>
                    <a class="button" href="edit?id=${p.id }">수정</a>
                    <a class="button" href="del?id=${p.id }">삭제</a>
                </section>

            </main>

        </div>
    </div>
    <!----------------------------------main--------------------------------------->

          <main id="main" class="main feed-index">
            <h1 class="d-none">Feed-list 관리자 페이지</h1>
            <section>
              <h1 class="d-none">신고 리스트</h1>
              
	              <form action="post">
		              <select>
			              <option>이름</option>
		              </select>
		           	  <input type="text">
		           	  <input type="submit" value="검색" />
		              
              	  </form>
              	  
                <table class="list-table" border="1">
                  <thead>
                    <tr>
                      <td>번호</td>
                      <td>신고받은ID</td>
                      <td>신고수</td>
                      <td>조치여부</td>
                    </tr>
                  </thead>

                  <tbody>
                  <c:forEach var = "rf" items="${list}">
                    <tr>
                      <td>${rf.num}</td>
                      <td><a href="detail.jsp">${rf.reportedId}</a></td>
                      <td><a href="detail-list">${rf.repoCnt }</a></td>
                      <td>${rf.action}</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
            </section>

            <div class="pager">
              <div>
                <a href="#"><i class="fas fa-angle-double-left"></i></a>
              </div>
              <div>
                <a href="#"><i class="fas fa-angle-left"></i></a>
              </div>
              <ul>
                <li><a href="#">1</a></li>
              </ul>
              <div>
                <a href="#"><i class="fas fa-angle-right"></i></a>
              </div>
              <div>
                <a href="#"><i class="fas fa-angle-double-right"></i></a>
              </div>
            </div>
          </main>
        </div>

    </div>

    <!----------------------------------footer--------------------------------------->
    <footer id="footer" class="footer">
      <div class="container">
        <h1 class="d-none">Footer</h1>
      </div>
    </footer>

</body>
</html>