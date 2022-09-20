<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!--<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">-->
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
        <div class="inner">
            <div class="social-menu">
                <ul class="menu">
                    <li>
                        <a href="/WebProject/menu/login.jsp">
                            <img src="/WebProject/images/login.png" alt="login" width="46px" height="46px">
                        </a>
                    </li>
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

    <!--LOGIN-->
    <section class="login">
        <div class="login-form">
            <h2>로그인</h2>
            <div class="input-box">
            	<form action="/WebProject/menu/check_login.jsp">
		            <input type="text" value="ID" class="id-text" name="userId"> <br/>
	                <input type="text" value="PW" class="pw-text" name="userPw"> <br/>
	                <input type="submit" value="LOGIN" class="login-btn"> <br/>
	                <a href="/WebProject/menu/join.jsp"><input type="submit" value="JOIN US" class="join-btn"></a> <br/>
	                <div class="find-idpw">
	                    <a href="/WebProject/menu/find-id.jsp"><span class="find-id">아이디 찾기</span></a> <br/>
	                    <a href="/WebProject/menu/find-pw.jsp"><span class="find-pw">비밀번호 찾기</span></a>
	                </div>
            	</form>
                
            </div>
        </div>
    </section>

    <!--LOGIN
    <section class="profile">
        <div class="topTitle">
            <h2>Profile</h2>
            <div class="subTitle">
                <ul>
                    <li><a href="/">home</a></li>
                    <li><a href="/menu/tour.html">tour</a></li>
                    <li><a href="/menu/discography.html">discography</a></li>
                    <li><a href="/menu/music.html">music</a></li>
                    <li><a href="/menu/board.html">board</a></li>
                </ul>
            </div>
        </div>
        <div class="profilebox">
            <div class="inner">
                <div class="subBox">
                    <h3>MUSICIAN</h3>
                </div>
                <div class="artistDetail">
                    <div class="artist">
                    <div class="left">
                        <img src="/images/profile.png" width="500px" height="500px">
                    </div>
                    <div class="right">
                        <div class="title">
                        <div class="title-text">
                            <h4>태연</h4>
                        </div>
                        <div class="text-box">
                            <div class="birth">
                            <h3>생일</h3>
                            <p>3월 9일</p>
                            </div>
                            <div class="debut">
                            <h3>데뷔</h3>
                            <p>2007년 8월 5일 소녀시대 '다시 만난 세계'</p>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                </div>
        </div>
        
    </section>
    -->

</body>
</html>

