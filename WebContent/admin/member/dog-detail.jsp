<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/form/default.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/table/detail.css" type="text/css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
 <div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
    <jsp:include page="../../inc/admin-header.jsp"></jsp:include>


    <div class="body">
        <div class="container">
            <aside class="aside">
                <h1 class="d-none">페이지 목록</h1>
                <ul>
                    <li><a href="list">회원 목록</a></li>
                  <li><a href="doglist">강아지 목록</a></li>
                  <li><a href="matchinglist">매칭 목록</a></li>
                  <li><a href="reportlist">신고 목록</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">디테일 테이블</h1>
                    <img src="../../static/dog/2020/12/${d.files}">
                    <table class="detail-table">
                       <tr>
                           <th>이름</th>
                           <td>${d.name}</td>
                           <th>회원</th>
                           <td>${d.masterId}</td>
                       </tr>

                       <tr>
                        <th>성별</th>
                        <td>${d.gender==1?"남":"여"}</td>
                        <th>견종</th>
                        <td>${d.kind}</td>
                    </tr>
                    
                    <tr>
                        <th>중성화</th>
                        <td>${d.neut==1?"O":"X"}</td>
                        <th>생일</th>
                        <td>${d.birth}</td>
                    </tr>

                    <tr>
                        <th>무게</th>
                        <td>${d.weight}kg</td>
                        <th>성격</th>
                        <td>${d.character}</td>
                    </tr>

                    <tr>
                        <th colspan="1">등록일자</th>
                        <td colspan="3">${d.regDate}</td>
                        
                    </tr>
                    
                    <tr class="content">
                    	<th>내용</th>
                        <td colspan="3">${d.content}</td>
                    </tr>
                     
                  
                    </table>

                </section>
                <div class="pager">
                  <a href="doglist"><input type="button" class="button search-button" value="목록"></a>
                </div>
            </main>


        </div>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1></h1>
        </div>

    </footer>

</body>

</html>