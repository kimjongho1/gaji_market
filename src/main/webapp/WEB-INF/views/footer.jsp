<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<footer class="footer spad">

    <div width="1200px" class="">
        <button type="button" id="btn_top" class="cxRRkY btn_top_animation">
            
            <img src="${pageContext.request.contextPath}/resources/img/gaji_logo.png" alt="TOP" loading="eager" width="68" height="68">
        </button>

        <div class="container">
            <div class="footer__about__logo">
                <a href="${pageContext.request.contextPath}/"><img width="120" height="50" src="${pageContext.request.contextPath}/resources/img/gaji_logo.png" alt="그래"></a>
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
                            <li><a href="${pageContext.request.contextPath}/preparing">제휴문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">광고문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">PR문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">IR문의</a></li>
                        </ul>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/preparing">이용약관</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">개인정보처리방침</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">위치기반서비스 이용약관</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">이용자보호 비전과 계획</a></li>
                            <li><a href="${pageContext.request.contextPath}/preparing">청소년 보호정책</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <div class="footer__widget__social">
                            <a href="https://www.facebook.com/?locale=ko_KR"><i class="fa fa-facebook"></i></a>
                            <a href="https://www.instagram.com/sem/campaign/emailsignup/?campaign_id=13530338586&extra_1=s%7Cc%7C547419126947%7Ce%7Cinstagram%20c%7C&placement=&creative=547419126947&keyword=instagram%20c&partner_id=googlesem&extra_2=campaignid%3D13530338586%26adgroupid%3D126262419014%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-1321618852491%26loc_physical_ms%3D1009871%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=Cj0KCQjw4bipBhCyARIsAFsieCzO1fXhuLRPDEAGdXczBmRho7JRP024oU5erYHQdsrNWCqqXtJj4JgaAnQ8EALw_wcB"><i class="fa fa-instagram"></i></a>
                            <a href="https://twitter.com/?lang=ko"><i class="fa fa-twitter"></i></a>
                            <a href="https://www.pinterest.co.kr/"><i class="fa fa-pinterest"></i></a>
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