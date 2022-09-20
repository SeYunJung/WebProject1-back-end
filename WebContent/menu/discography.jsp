<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String userName = (String)session.getAttribute("userName");
	String userId = (String)session.getAttribute("userId");
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
                <li><a href="/WebProject/menu/Blist.taeyeon">board</a></li>
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

    <!--DISCOGRAPHY-->
    <section class="discography">
        <div class="topTitle">
            <h2>Discography</h2>
            <div class="subTitle">
                <ul>
                    <li><a href="/WebProject">home</a></li>
                    <li><a href="/WebProject/menu/profile.jsp">profile</a></li>
                    <li><a href="/WebProject/menu/tour.jsp">tour</a></li>
                    <li><a href="/WebProject/menu/music.jsp">music</a></li>
                    <li><a href="/WebProject/menu/Blist.taeyeon">board</a></li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="inner">
                <ul class="Albums">
                    <li>
                        <div class="Album"> <!--정규앨범-->
                            <div class="first-album">
                                <a href="/WebProject/albums/MyVoice.jsp">
                                    <img src="/WebProject/images/My Voice.png" alt="My Voice" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="second-album">
                                <a href="/WebProject/albums/Purpose.jsp">
                                    <img src="/WebProject/images/Purpose.png" alt="My Voice" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="third-album">
                                <a href="/WebProject/albums/INVU.jsp">
                                    <img src="/WebProject/images/INVU.png" alt="My Voice" width="400px" height="400px">
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="EP"> <!--미니앨범-->
                            <div class="first-mini">
                                <a href="/WebProject/albums/I.jsp">
                                    <img src="/WebProject/images/I.png" alt="I" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="second-mini">
                                <a href="/WebProject/albums/Why.jsp">
                                    <img src="/WebProject/images/Why.png" alt="Why" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="third-mini">
                                <a href="/WebProject/albums/Something.jsp">
                                    <img src="/WebProject/images/Something New.png" alt="Why" width="400px" height="400px">
                                </a>
                            </div>
                            <!--
                            <div class="fourth-mini">
                                <a href="/albums/WhatDo.html">
                                    <img src="/images/What Do I Call You.png" alt="Why" width="400px" height="400px">
                                </a>
                            </div>
                            -->
                        </div>
                    </li>
                    <li>
                        <div class="Single"> <!--싱글앨범-->
                            <div class="single-rain">
                                <a href="/WebProject/albums/Rain.jsp">
                                <img src="/WebProject/images/Rain.png" alt="Rain" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="single-eleven">
                                <a href="/WebProject/albums/eleven.jsp">
                                <img src="/WebProject/images/11.png" alt="eleven" width="400px" height="400px">
                                </a>
                            </div>
                            <div class="single-fourseason">
                              <a href="/WebProject/albums/FourSeason.jsp">
                                <img src="/WebProject/images/Four Season.png" alt="fourseason" width="400px" height="400px">
                              </a>
                            </div> 
                            <!--
                            <div class="single-happy">
                              <a href="/albums/Happy.jsp">
                                <img src="/images/Happy.png" alt="happy" width="400px" height="400px">
                              </a>
                            </div>
                            -->
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        
    </section>

</body>
</html>

