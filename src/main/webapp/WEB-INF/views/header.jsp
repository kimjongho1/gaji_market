<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/slicknav.min.css" type="text/css">  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/resources/css/style.css" type="text/css">

</head>
<style>

header {
        position: static;
        z-index: 1000;
        width: 100%;
        position: sticky;
        top: 0px;
        background-color: rgba(255, 255, 255, 0.9);
    }


.rights {
    position: fixed;
    right: 100px   ;
    padding: 15px;
}


</style>
<body>
   




    
    <!-- Header Section Begin -->
    <header width="100%" id="header" >
                        
  
        <div class="container">
            <div class="head_top">
            <div class="row">

                    <div class="header__logo">
                        <a href="./index.html"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
                    </div>
                


                
                    <div class="hero__search" >
                        <div class="hero__search__form">
                            <form action="#">
                                
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>     
                    </div>
                
                    <div class="header__cart rights" >
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                            <li><a href="#">login</a></li>
                        </ul>
                       
                    </div>

                    
            </div>
            </div>
            <div class="row">  
                    <nav class="header__menu">
                        <ul>
                            <li><a href="#">카테고리</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="#">가구/인테리어</a></li>
                                    <li><a href="#">생활가전</a></li>
                                    <li><a href="#">생활/주방</a></li>
                                    <li><a href="#">디지털 기기</a></li>
                                    <li><a href="#">취미/게임</a></li>
                                    <li><a href="#">기타</a></li>
                                </ul>
                            </li>
                            <li class="active"><a href="#">상품</a></li>
                            <li><a href="#">1:1채팅</a></li>
                        </ul>
                                
                           
                        
                    </nav>
                



                
                
                   
                </div>
            
        </div>
    </header>
    <!-- Header Section End -->

    
   

    

   

    

    <!-- Js Plugins -->

    <script>


        window.addEventListener("scroll", function () {
            if (window.pageYOffset > 1) {
                document.querySelector("#header").className = 'sc';
            } else {
                document.querySelector("#header").className = 'sc';
            }
        });

    </script>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>



</body>

</html>