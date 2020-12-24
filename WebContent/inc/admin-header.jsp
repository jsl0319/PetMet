<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="header">
        <div class="container">
            <div class="logo">
                <a href="/admin/index">
                <i class="fas fa-dog fa-3x"></i>
                <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                  <li>
                    <a href="/admin/member/list">
                      <i class="fas fa-users fa-2x"></i>
                      <span>MEMBER</span>
                    </a>
                  </li>
                  <li>
                    <a href="/admin/feed/list">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="/admin/community/notice/list">
                      <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                      <span>COMMUNITY</span>
                    </a>
                  </li>
                  <li>
                    <a href="/admin/petplace/list">
                      <i class="fas fa-map-marked-alt fa-2x"></i>
                      <span>PLACE</span>
                    </a>
                  </li>
                </ul>
            </nav>

            <!-- <nav>
                <h1 class="d-none">바로가기 메뉴</h1>
                <ul>
                    <li><a href>펫멧이동</a></li>
                    <li><a href>로그아웃</a></li>
                </ul>
            </nav> -->
        </div>
    </header>