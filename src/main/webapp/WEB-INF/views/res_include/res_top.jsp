<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">
                    <img src="resources/images/gtlLogo.jpg" alt="">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                    	<a href="/firstPage">첫번째 페이지</a>
                    </li>
                    <li>
                        <a href="/secondPage">두번째 페이지</a>
                    </li>
                    <li>
                        <a href="/thirdPage">세번째 페이지</a>
                    </li>
                    <li>
                        <a href="/fourthPage">공지 사항</a>
                    </li>
                    <li>
                    	<a href="/">${sessionScope.loggedmsg}</a>
                    </li>
                </ul>
                                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
