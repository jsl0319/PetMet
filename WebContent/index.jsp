<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/reset.css" type="text/css" rel="stylesheet">
    <link href="css/admin/layout/index.css" type="text/css" rel="stylesheet">
    <link href="css/admin/content-layout/index.css" type="text/css" rel="stylesheet">
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <link href="css/user/style.css" type="text/css" rel="stylesheet">
    <script src="js/match/index.js"></script>
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
<img class="ppo" src="images/user/ppo.png">
<img class="sel" src="images/user/sel.png">
<img class="kris" src="images/user/kris.png">
<img class="black" src="images/user/black.png">

	<jsp:include page="inc/client-header.jsp"/>


    <div class="body">
        <main id="main" class="main">
            <h1 class="d-none">메인이다</h1>
            
            <section class="main1">
                
                <div class="container">
                    <h1 class="d-none">이미지</h1>
                    
                   
                
            </div>
            </section>

            <section class="main2">
                <div class="container">
                    <h1 class="d-none">그 외의 정보들</h1>
                    <section>
                        <h1>Notice</h1>
                        <table border="1">
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
                                <tr>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                </tr>
                                <tr>
                                    <td>11</td>
                                    <td>22</td>
                                    <td>33</td>
                                    <td>44</td>
                                    <td>55</td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                    <section>
                        <h1>Others</h1>
                        <table border="1">
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
                                <tr>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                </tr>
                                <tr>
                                    <td>11</td>
                                    <td>22</td>
                                    <td>33</td>
                                    <td>44</td>
                                    <td>55</td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                </div>
            </section>
        </main>

    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1>PetMet</h1>
        </div>

    </footer>

</body>

</html>