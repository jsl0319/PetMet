<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/reset.css" type="text/css" rel="stylesheet">
    <link href="../../css/index.css" type="text/css" rel="stylesheet">
    <link href="../../css/layout.css" type="text/css" rel="stylesheet">
    <link href="../../css/login.css" type="text/css" rel="stylesheet">
    <link href="../../css/content-layout.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/table/list.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/components/form/default.css" type="text/css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  
</head>

<body>

  <header id="header" class="header">
        <div class="container">
            <div class="logo">
                <a href="/index">
                    <i class="fas fa-dog fa-3x"></i>
                    <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                    <li>
                        <a href="/match/list">
                            <i class="fas fa-users fa-2x"></i>
                            <span>MATCHING</span>
                        </a>
                    </li>
                   
                    <li>
                        <a href="/community/notice/list">
                            <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                            <span>COMMUNITY</span>
                        </a>
                    </li>
                    <li>
                        <a href="/petplace/list">
                            <i class="fas fa-map-marked-alt fa-2x"></i>
                            <span>PLACE</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <ul class="login">
             <c:if test="${sessionScope.mid==null }"><li><a href="/member/login?return-url=${returnUrl}">로그인</a></li></c:if>
             <c:if test="${sessionScope.mid!=null }"><li>${sessionScope.mn}님</li></c:if>
            </ul>
            
        </div>
      
    </header>

    <div class="body">
        <main id="main" class="main">
            <h1 class="d-none">메인이다</h1>
            <div class="container">
               	<div style="margin-top:200px; margin-left:450px; margin-right:400px; font-size:25px; font-weight:bold;">
               		로그인이 필요한 페이지입니다.             		
               	</div>
               	<div style="margin-top:150px; margin-left:530px; margin-right:400px; font-size:25px; font-weight:bold;
               	font-style:italic; color:blue;
               	">
               		<a href="/member/login?return-url=${returnUrl}">로그인하러 가기</a>
               	</div>

            </div>
        </main>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1>footer</h1>
        </div>

    </footer>

</body>

</html>