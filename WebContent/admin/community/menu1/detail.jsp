
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <header>
        <h1><a href="../../index.html">logo</a></h1>

        <nav>
            <h1>메뉴</h1>
            <ul>
                <li><a href="../../index.html">Home</a></li>
                <li><a href="../../match/list.html">Match</a></li>
                <li><a href="../index.html">Community</a></li>
                <li><a href="../../shop/index.html">Shop</a></li>
                <li><a href="../../user/index.html">Login</a></li>
                <li><a href="../../myfeed/index.html">My Page</a></li>
            </ul>
        </nav>
    </header>
	
    <nav id="aside">
        <h1>커뮤니티 메뉴</h1>
        <ul>
            <li><a href="../notice/list.html">공지사항</a></li>
            <li><a href="list.html">메뉴1</a></li>
        </ul>
    </nav>
    
    <section>
        <main id="main">
            <table border="1">
                <thead>
                    <tr>
                        <td colspan="3">${b.title}</td>
                         </tr>
                </thead>
                <tbody>
                    <tr>

                        <td>${b.title}</td>
                        <td>${b.regdate}</td>
                        <td>${b.views}</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                           ${b.content}
                        </td>
                    </tr>
                </tbody>
            </table>
        </main>
    </section>

    <section>
        <footer id="footer">
            <h1>푸터푸터푸터</h1>
        </footer>
    </section>
</body>

</html>