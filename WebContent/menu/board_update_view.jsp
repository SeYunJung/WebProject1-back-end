<%@page import="kr.co.koo.taeyeons.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String userName = (String)session.getAttribute("userName");
	String userId = (String)session.getAttribute("userId");
	String bId = (String)request.getParameter("bId");
	BoardVO board = (BoardVO)request.getAttribute("contents");
	if(userName == null) response.sendRedirect("/WebProject");
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="icon" href="/WebProject/favicon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="/WebProject/css/main.css">

    <!--Google APIs-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Anek+Telugu&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
    <!--HEADER-->
    <header>
        <div class="topbar"></div>
        <input type="checkbox" id="menuicon">
        <label for="menuicon" >
            <span></span> 
            <span></span>
            <span></span>
        </label>
        
        <div class="sidebar">
            <ul>
                <li><a href="/WebProject">Home</a></li>
                <li><a href="/WebProject/menu/profile.jsp">Profile</a></li>
                <li><a href="/WebProject/menu/tour.jsp">Tour</a></li>
                <li><a href="/WebProject/menu/discography.jsp">Discography</a></li>
                <li><a href="/WebProject/menu/music.jsp">music</a></li>
                <li><a href="/WebProject/menu/board.jsp">board</a></li>
                <li><a href="https://www.instagram.com/taeyeon_ss/">SNS</a></li>
            </ul>
        </div>
        
        <!--
        <a href="/">
            <img src="/images/menubar.png" alt="mainmenu" class="menubar">
        </a>-->
        <div class="inner">
            <div class="social-menu">
                <ul class="menu">
                    <% if(userId == null) { %>
                    <li>
                        <a href="/WebProject/menu/login.jsp">
                            <img src="/WebProject/images/login.png" alt="login" width="46px" height="46px">
                        </a>
                    </li>
                    <% } else { %>
                    <li class="userName">
		          		<%= userName %>님 
		        	</li>
		         	<% } %>
                    <li>
                        <a href="https://www.instagram.com/taeyeon_ss/">
                            <img src="/WebProject/images/instagram.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                    <li>
                        <a href="https://twitter.com/TAEYEONsmtown">
                            <img src="/WebProject/images/twitter.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                    <li>
                        <a href="https://www.youtube.com/channel/UC5z2fxN6rs69cSyXur6X6Mg">
                            <img src="/WebProject/images/youtube.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                    <li>
                        <a href="https://www.facebook.com/TAEYEON.smofficial/">
                            <img src="/WebProject/images/facebook.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                    <li>
                        <a href="https://open.spotify.com/artist/3qNVuliS40BLgXGxhdBdqu">
                            <img src="/WebProject/images/spotify.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                    <li>
                        <a href="https://music.apple.com/kr/artist/%ED%83%9C%EC%97%B0/435966642">
                            <img src="/WebProject/images/apple.png" alt="" width="46px" height="46px">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    
    <!-- BOARD-UPDATE-VIEW -->
    <section class="board-update-view">
    	<div class="topTitle">
            <h2>Board</h2>
            <div class="subTitle">
                <ul>
                    <li><a href="/WebProject">home</a></li>
                    <li><a href="/WebProject/menu/profile.jsp">profile</a></li>
                    <li><a href="/WebProject/menu/tour.jsp">tour</a></li>
                    <li><a href="/WebProject/menu/discography.jsp">discography</a></li>
                    <li><a href="/WebProject/menu/music.jsp">music</a></li>
                </ul>
            </div>
        </div>
        <div class="container">
        	<div class="inner">
        		<form action="/WebProject/menu/BUpdate.taeyeon">
        			<div class="board-update">
        					<input type="hidden" value="${contents.board_id}" name="bId" >
                    		<input type="text" value="${contents.board_title}" name="bTitle" class="title" required> <br/>
                    		<input type="text" value="${contents.board_writer}" name="bName" class="name" required> <br/>
	                        <textarea name="bContent" cols="30" rows="40" class="board-contents">${contents.board_content}</textarea> <br/>
	                        <input type="submit" value="수정">
	                        <input type="submit" value="취소" onclick="history.back()">
                    </div>
        		</form>
        	</div>
        </div>
    </section>

</body>
</html>

