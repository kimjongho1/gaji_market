<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style>
.btn_top_animation {
    position: relative;
    z-index: 200
    
}

#btn_top {
    color: brown;
    bottom: 100px;
    /* display: none; */
    /* display: block; */
    left: 50%;
    margin-left: 750px;
    position: fixed;
    right: 500px;
    z-index: 200
    /* z-index: 50 */
}

.cxRRkY {
        position: absolute;
        padding: 0px;
        width: 68px;
        opacity: 1;
        visibility: visible;
        transition: opacity 0.5s ease 0s, visibility 0.5s ease 0s;
    }
</style> 

<footer class="footer spad">

    <div width="1200px" class="">
        <button type="button" id="btn_top" class="cxRRkY btn_top_animation">
            
            <img src="/#" alt="TOP" loading="eager" width="68" height="68">
        </button>

        <div class="container">
            <div class="footer__about__logo">
                <a href="./index.html"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <ul>
                            <li>주소: 서울 강남구 역삼동 823-42 </li>
                            <li>전화: 02-1234-5678</li>
                            <li>이메일: Gaji@martket.com</li>
                            <li>대표:김종호 백의헌 천영준 신정훈</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <ul>
                            <li><a href="#">제휴문의</a></li>
                            <li><a href="#">광고문의</a></li>
                            <li><a href="#">PR문의</a></li>
                            <li><a href="#">IR문의</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">이용약관</a></li>
                            <li><a href="#">개인정보처리방침</a></li>
                            <li><a href="#">위치기반서비스 이용약관</a></li>
                            <li><a href="#">이용자보호 비전과 계획</a></li>
                            <li><a href="#">청소년 보호정책</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> Gaji Martket 
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>


      <!--   <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text"><p>Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.</p></div>
                    <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                </div>
            </div>
        </div>
    </div> -->


<script>

const backToTopButton = document.querySelector("#btn_top");
        window.addEventListener("scroll", function () {
            if (window.pageYOffset > 200) {
                backToTopButton.style.display = "block";
            } else {
                backToTopButton.style.display = "none";
            }
        });
        backToTopButton.addEventListener("click", function () {
            window.scrollTo({ top: 0, behavior: "smooth" });
        });

</script>