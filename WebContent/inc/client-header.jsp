<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
             <c:if test="${sessionScope.mid==null }"><li><a href="/member/login">로그인</a></li></c:if>
             <c:if test="${sessionScope.mid!=null }"><li>${sessionScope.mn}님</li></c:if>
            </ul>
            
        </div>
      
    </header>