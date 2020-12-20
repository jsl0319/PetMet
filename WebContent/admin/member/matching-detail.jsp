<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <header id="header" class="header">
        <div class="container">
            <div class="logo">
                <a href="../index.html">
                    <i class="fas fa-dog fa-3x"></i>
                    <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                    <li>
                        <a href="list">
                            <i class="fas fa-users fa-2x"></i>
                            <span>MEMBER</span>
                        </a>
                    </li>
                    <li>
                        <a href="../feed/list">
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
        </div>
    </header>


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
                            <th>요청 회원</th>
                            <td>${mt.reqId}</td>
                            <td></td>
                            <th>요청 받은 회원</th>
                            <td>${mt.respId}</td>
                            
                        </tr>
                        <tr>
                        	<th>강아지</th>
                            <td>${mt.reqDogName}</td>
                            <td></td>
                            <th>강아지</th>
                            <td>${mt.respDogName}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><img src="/static/dog/2020/12/${mt.reqDogFiles}"></td>
                        
                            <td></td>
                            <td colspan="2"><img src="/static/dog/2020/12/${mt.respDogFiles}"></td>
                        </tr>
                        <tr>
                            <th>매칭상태</th>
                            <td colspan="4">
                            	<c:if test="${mt.result==0 }">진행중</c:if>
                                <c:if test="${mt.result==1 }">수락</c:if>
                                <c:if test="${mt.result==2 }">거절</c:if>
                            </td>
                            
                        </tr>
                        <tr class="content">
                            <td colspan="5">${mt.matchContent}</td>
                        </tr>
                        <tr>

                        </tr>
                    </table>

                </section>
                <div class="pager">
                    <a href="matchinglist"><input type="button" class="button search-button" value="목록"></a>
                </div>
            </main>


        </div>
    </div>

    <footer id="footer" class="footer">

        <div class="container">
            <h1>footer</h1>
        </div>

    </footer>

</body>

</html>