<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/admin/shop/product/reg.css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <title>상품수정</title>
</head>
<body>
    <header class="header">
        <h1><a href="../../index.html">logo</a></h1>

        <nav>
            <h1 class="d-none">메뉴</h1>
            <ul>
                <li>
                    <a href="../../user/index.html">회원관리</a>
                </li>
                <li>
                    <a href="../index.html">쇼핑몰</a>
                </li>
                <li>
                    <a href="../../community/index.html">커뮤니티 게시글관리</a>
                </li>
            </ul>
        </nav>
    </header>
    

    <div class="body">
        <div class="container">
            <h1 class="d-none">관리인 : 쇼핑몰 관리</h1>
            <aside class="aside">
                <nav>
                    <h1 class="d-none">쇼핑몰관리 목록</h1>
                    <ul>
                        <li>
                            <i class="far fa-list-alt"></i>
                            <a href="../order/index.html">주문관리</a>
                        </li>
                        <li>
                            <i class="fas fa-gift"></i>
                            <a href="../product/list.html">상품관리</a>
                            <ul>
                                <li><a href="reg.html">상품등록</a></li>
                            </ul>
                        </li>
                        <li>
                            <i class="fas fa-clipboard-list"></i>
                            <a href="../post/notice.html">게시글 관리</a>
                        </li>
                    </ul>
                </nav>
            </aside>

    <main class="main">
        <h1>상품수정</h1>
        <form action="modify" method = "post">
            <table border="1">
                <tr>
                    <td>상품명
                        <select>
                            <option>사료</option>
                            <option>용품</option>
                        </select>
                        <input name="name" type="text" value ="${p.name}">
                    </td>
                </tr>
                <tr>
                    <td>진열여부
                        <input name="posted" type="text" value ="${p.posted}">
                    </td>
                </tr>
                <tr>
                    <td>상품 등록일
                    <fmt:formatDate value="${p.regdate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td>판매가
                    <input name="price" type="text" value="${p.price}">
                    </td>
                </tr>
                <tr>
                    <td>재고량
                    <input name="amount" type="text" value ="${p.amount}">
                </td>
                </tr>
                <tr>
                    <td>상품이미지
                        <input type="file" accept="image/png, image/jpg">
                    </td>
                </tr>
            </table>
	            <input type = "hidden" name="id" value ="${p.id}" >
	            <input type="submit" value="수정">
            </form>
    </main>
    </div>
    </div>
    
        <footer class="footer">
            <h1 class="d-none">Footer</h1>
        </footer>
</body>
</html>