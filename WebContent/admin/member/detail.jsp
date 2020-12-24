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
                    <table class="detail-table">
                       <tr>
                           <th>닉네임</th>
                           <td>${mv.nickname}</td>
                           <th>가입일</th>
                           <td>${mv.regDate}</td>
                       </tr>
                       <tr>
                        <th>등록강아지</th>
                        <td><a href="doglist?q=${mv.nickname}">${mv.dogNum}</a></td>
                        <th>신고횟수</th>
                        <td>${mv.repNum}</td>
                    </tr>
                    
                    <tr>
                        <th>매칭 요청 횟수</th>
                        <td>${mv.mtReqNum}</td>
                        <th>매칭 요청 받은 횟수</th>
                        <td>${mv.mtRespNum}</td>
                        
                    </tr>
                    <tr>
                    	<th>매칭 성사 횟수</th>
                        <td>${mv.mtSuccess}</td>
                    </tr>

                    </table>

                </section>
                <div class="pager">
                  <a href="list"><input type="button" class="button search-button" value="목록"></a>
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