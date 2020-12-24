<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 공지사항관리 > 등록</title>

    <link rel="stylesheet" href="../../../css/admin/components/table/detail.css" type="text/css">
    <link rel="stylesheet" href="../../../css/style.css">
    <link rel="stylesheet" href="../../../css/admin/components/form/default.css" type="text/css">

    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
</head>

<body>
    <header class="header">
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
                    <a href="../user/index">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="index">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="../community/notic/list">
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

    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">

            <aside class="aside">
                
                <h1 class="d-none">Aside 메뉴</h1>

                    <nav>
                        <h1 class="d-none" >세부 메뉴 목록</h1>

                        <ul>

                            <li>
                                <i class="fas fa-bullhorn"></i>
                                <a href="../notice/list">공지사항관리</a>
                            </li>

                            <li>
                                <i class="fas fa-bullhorn"></i>
                                <a href="list">QnA 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-clipboard-list"></i>
                                <a href="../category/list">카테고리 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-clipboard-list"></i>
                                <a href="../board/list">게시글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-ban"></i>
                                <a href="../board/reported">신고된 게시글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-comment"></i>
                                <a href="../comment/list">댓글 관리</a>
                            </li>

                            <li>
                                <i class="fas fa-comment-slash"></i>
                                <a href="../comment/reported">신고된 댓글 관리</a>
                            </li>
                        </ul>
                    </nav>
            </aside>
            <main class = "main">
             <form method="post" enctype="multipart/form-data">
                <h1>공지사항 글쓰기</h1>
                <section>
                    <table class ="detail-table">
                        
                     <thead>
                    <tr>
                        <th>제목</th>
                        <td>
                            <input type="text" name="title" />
                        </td>
                      
                        </tr>

                        <tr>
                           
                            <th>공개여부</th>
                            
                         	
                            
                            <th>첨부파일</th>
                           <td>
                            <input type="button" value="이미지">
                            <input type="button" value="동영상">
                            <input type="button" value="링크">
                            <input type="button" value="파일">
                        </td>

                        </tr>
                    </thead>
                      
                      <tbody>
    
                        <tr class="content">
                           <td colspan="4"><textarea class="content" name="content" style="width: 900px; height: 500px; resize: none;"></textarea></td>
                        </tr>
    
                    </tbody>
                    </table>
                    <input class="button" type="submit" value="등록">
                     <a class="button" href="list">취소</a>
                     
                </section>
    
                </form>
            </main>

        </div>
    </section>






    <footer class="footer">
        <div class="container">
            <h1 class="d-none"></h1>
        </div>
    </footer>



</body>

</html>