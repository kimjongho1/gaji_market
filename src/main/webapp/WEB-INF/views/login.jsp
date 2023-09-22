<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="login.css">

</head>
<body>
    <div>123</div>


    <div class="content">
        <div class="login_wrap">
            
            <form id="frmNIDLogin" name="frmNIDLogin" target="_top" AUTOCOMPLETE="off"
                  action="#" method="POST">
                <input type="hidden" id="localechange" name="localechange" value="">
                <input type="hidden" name="dynamicKey" id="dynamicKey" value="f-ZmGzfp39VjnxQ1q-FxEpwkwgpH92mORPHcj8CHsijmEDZ0YJvrKF5nZrQI_kLmWnOCz9hvWrVdwD6geSguZC7h8AIrNJdXaABJRzaOTPM">
                <input type="hidden" name="encpw" id="encpw" value="">
    <input type="hidden" name="enctp" id="enctp" value="1">
    <input type="hidden" name="svctype" id="svctype" value="1">
    <input type="hidden" name="smart_LEVEL" id="smart_LEVEL" value="1">
    <input type="hidden" name="bvsd" id="bvsd" value="">
    <input type="hidden" name="encnm" id="encnm" value="">
    <input type="hidden" name="locale" id="locale" value="ko_KR">
    <input type="hidden" name="url" id="url" value="#">
    
    
                <ul class="panel_wrap">
                    <li class="panel_item" style="display: block;">
                        <div class="panel_inner" role="tabpanel" aria-controls="loinid">
                            <div class="id_pw_wrap">
                                <div class="input_row" id="id_line">
                                    <div class="icon_cell" id="id_cell">
                                        <span class="icon_id">
                                            <span class="blind">아이디</span>
                                        </span>
                                    </div>
                                    <input type="text" id="id" name="id" placeholder="아이디" title="아이디"
                                           class="input_text" maxlength="41"
                                           value="">
                                    <span role="button" class="btn_delete" id="id_clear" style="display: none;">
                                        <span class="icon_delete">
                                            <span class="blind">삭제</span>
                                        </span>
                                    </span>
                                </div>
                                <div class="input_row" id="pw_line">
                                    <div class="icon_cell" id="pw_cell">
                                        <span class="icon_pw">
                                            <span class="blind">비밀번호</span>
                                        </span>
                                    </div>
                                    <input type="password" id="pw" name="pw" placeholder="비밀번호" title="비밀번호"
                                           class="input_text" maxlength="16">
                                    <span role="button" class="btn_delete" id="pw_clear" style="display: none;">
                                        <span class="icon_delete">
                                            <span class="blind">삭제</span>
                                        </span>
                                    </span>
                                </div>
                            </div>
                            <div class="login_keep_wrap" id="login_keep_wrap">
                                <div class="keep_check">
                                    <input type="checkbox" id="keep" name="nvlong"
                                           class="input_keep"  value="off">
                                    <label for="keep" class="keep_text">로그인 상태 유지</label>
                                </div>
                                
                            </div>
    
                            <div class="login_error_wrap" id="err_capslock" style="display: none;">
                                <div class="error_message">
                                    <strong>CapsLock</strong>이 켜져 있습니다.
                                </div>
                            </div>
    
                            <div class="login_error_wrap" id="err_empty_id" style="display: none;">
                                <div class="error_message">
                                    <strong>아이디</strong>를 입력해 주세요.
                                </div>
                            </div>
    
                            <div class="login_error_wrap" id="err_empty_pw" style="display: none;">
                                <div class="error_message">
                                    <strong>비밀번호</strong>를 입력해 주세요.
                                </div>
                            </div>
                            <div class="login_error_wrap" id="err_common"  style="display:none;">
                                <div class="error_message"
                                     style="width:90%">
                                    
                                </div>
                            </div>
                            <div class="btn_login_wrap">
    
                                <button type="submit" class="btn_login" id="log.login">
                                    <span class="btn_text">로그인</span>
                                </button>
    
                            </div>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
        <ul class="find_wrap" id="find_wrap">
    
            <li><a target="_blank" href="#"
                   class="find_text">비밀번호 찾기</a></li>
            <li><a target="_blank" href="#"
                   class="find_text">아이디 찾기</a></li>
            <li><a target="_blank" href="#" class="find_text">회원가입</a>
            </li>
    
        </ul>
        <!--배너-->
        <div id="gladbanner" class="banner_wrap">
            &nbsp;
        </div>
    </div>
</body>
</html>