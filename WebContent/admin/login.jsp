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
    <link href="../css/index.css" type="text/css" rel="stylesheet">
    <link href="../css/layout.css" type="text/css" rel="stylesheet">
    <link href="../css/login.css" type="text/css" rel="stylesheet">
    <link href="../css/content-layout.css" type="text/css" rel="stylesheet">
    <link href="../../css/shape.css" type="text/css" rel="stylesheet">
    <link href="../css/admin/components/table/list.css" type="text/css" rel="stylesheet">
    <link href="../css/admin/components/form/default.css" type="text/css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
  
</head>

<body>
 <div class="neon circle"></div>
  <div class="neon circle"></div>
  <div class="neon square"></div>
  <div class="neon square2"></div>
  <div class="neon tri"></div>
  <div class="neon tri2"></div>
   <jsp:include page="../inc/admin-header.jsp"/>


    <div class="body">
        <main id="main" class="main">
            <h1 class="d-none">메인이다</h1>
            <div class="container">
                <h1 class="d-none">로그인 정보 입력</h3>
                <form class="login-form" method="post">
                    <fieldset class="login">
                        <legend class="d-none">로그인 폼</legend>
                        
                        <ul class="login-box">
                            <li>
                                <label for="aid" class="id">아이디 </label>
                                <input type="text" name="aid" placeholder="아이디" />
                            </li>
                            <li class="pwd">
                                <label for="pwd">비밀번호</label>
                                <input type="password" name="pwd" placeholder="비밀번호" />
                            </li>
                        </ul>

                       
                       
                        <input type="submit" class="btn login-btn" value="login"/>
                       
                        
                    </fieldset>
                </form>

            </div>
        </main>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1></h1>
        </div>

    </footer>

</body>

</html>