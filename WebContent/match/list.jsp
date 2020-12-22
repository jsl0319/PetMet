<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/style.css" type="text/css" rel="stylesheet">
    <link href="../css/admin/components/table/list.css" type="text/css" rel="stylesheet">
    <link href="../css/admin/components/form/default.css" type="text/css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
    <script src="../js/match/list.js"></script>
</head>

<body>

    <header id="header" class="header">
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
                    <h1 class="d-none">검색폼</h1>
                    <form class="search__form search__container">
                    <div>
                        <div>
                       		 사나움<input style="margin-left:0x;" type="checkbox">
                       		 낯가림<input type="checkbox">
                       		 활발<input type="checkbox">
                       		 산만<input type="checkbox">
                       		 온순<input type="checkbox">
                       		 착함<input type="checkbox">
                        </div>
                        <div>
                            <label>중성화 여부</label>
                                 	O<input type="checkbox" name="neut" value="1">
                                 	X<input type="checkbox" name="neut" value="0">                      
                        </div>

						<div>
                        <label>견종</label>
                        <select class="selectbox">
                          <option>견종</option>
                          <option>푸들</option>
                          <option>비숑</option>
                          <option>말티즈</option>
                          <option>진돗개</option>
                          <option>포메라니안</option>
                        </select>
                        <select class="selectbox">
                          <option>정렬</option>
                          <option>거리순</option>
                        </select>
                      </div>
                      </div>

                    </form>
                </section>

                <section class="main-section">
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td class="col-m">회원(성별)</td>
                                <td class="col-m">강아지 이름</td>
                                <td class="col-s">성별</td>
                                <td class="col-s">중성화</td>
                                <td class="col-l">성격</td>
                                <td class="col-m">견종</td>
                                <td class="col-m">거리</td>
                                <td class="col-m">등록일자</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        
                            
                           
                        </tbody>
                    </table>

                </section>
                
               
                 <div class="pager">
                    <div>
                      <a href=""><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      
                    	<a href=""><i class="fas fa-angle-left"></i></a>
                    
                  
            
                    
                     
                    </div>
                    <ul>
                  
						<li><a href=""></a></li>
					
					</ul>
                    <div>
                   
                    	<a href=""><i class="fas fa-angle-right"></i></a>
                   
                    
                  
                      
                    </div>
                    <div>
                      <a href=""><i class="fas fa-angle-double-right"></i></a>
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