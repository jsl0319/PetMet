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
    <link href="../../css/admin/components/table/list.css" type="text/css" rel="stylesheet">
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
                        <a href="list.html">
                            <i class="fas fa-users fa-2x"></i>
                            <span>MEMBER</span>
                        </a>
                    </li>
                    <li>
                        <a href="../feed/index.html">
                            <i class="fas fa-camera-retro fa-2x"></i>
                            <span>FEED</span>
                        </a>
                    </li>
                    <li>
                        <a href="../community/index.html">
                            <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                            <span>COMMUNITY</span>
                        </a>
                    </li>
                    <li>
                        <a href="../petplace/list.html">
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
                  <li><a href="list.html">회원 목록</a></li>
                  <li><a href="dog-list.html">강아지 목록</a></li>
                  <li><a href="matching-list.html">매칭 목록</a></li>
                  <li><a href="report-num-list.html">신고 목록</a></li>

                </ul>
              </aside>
            <main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form>
                        <div>
                            <select>
                                <option>회원</option>
                                <option>닉네임</option>
                            </select>
                            <input type="text">
                        </div>

                        <label>견종</label>
                        <select>
                          <option>푸들</option>
                          <option>비숑</option>
                          <option>말티즈</option>
                      </select>
                        <input type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>아이디</td>
                                <td>회원</td>
                                <td>이름</td>
                                <td>성별</td>
                                <td>생일</td>
                                <td>성격</td>
                                <td>몸무게</td>
                                <td>견종</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach var="d" items="${doglist}">
                            <tr>
                              <td class="col-m">${d.id}</td>
                                <td>${d.masterId}</td>
                                <td><a href="dog-detail?id=${d.id}">${d.name}</a></td>
                                <td>${d.gender}</td>
                                <td>${d.birth}</td>
                                <td>${d.character}</td>
                                <td>${d.weight}kg</td>
                                <td>${d.kind}</td>
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

    <footer id="footer" class="footer">

        <div class="container">
            <h1>footer</h1>
        </div>

    </footer>

</body>

</html>