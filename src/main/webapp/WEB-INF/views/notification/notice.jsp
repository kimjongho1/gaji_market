<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>알림</title>
    
    <!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css" type="text/css">
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css">
    <style>
    
	
.page${currentPage}{
	color:#5715CC !important;
}

    
    </style>
    
</head>
<body>
    <div class="notification-container">
        <div class="notification-card">
            <div class="d-flex justify-content-between unread">
            <h2>거래 알림</h2>
            </div>
            <div class="d-flex justify-content-between unread"><span>읽지 않은 메시지 + ${notiCount}</span>
            <form id="notices">
            	<input type="hidden" id="notiId" name="notiId">
            	<input type="hidden" id="notiId1" name="notiId1">
            	<input type="hidden" id="notiId2" name="notiId2">
            	<input type="hidden" id="notiId3" name="notiId3">
            	<input type="hidden" id="notiId4" name="notiId4">
            	<input type="hidden" id="notiId5" name="notiId5">
            	<button type="button" class="btn" onclick="deleteAll()">알림 삭제</button>
            </form> 
            
            </div>
            <c:forEach items="${safeTradingNotice}" var="item" varStatus="loopStatus">
                <form action="${pageContext.request.contextPath}/notice/read?refId=${item.referenceId}&readYn=${item.readYn}&notiId=${item.notiId}" method="post">
                    <div>
                <ul>
                	<li class="d-flex justify-content-between">
                		<input type="checkbox" class="button-d" onclick="selectNoti(${loopStatus.index},${item.notiId},this)">
                		<button type="button" class="btn button-db" onclick="deleteNotice(${item.notiId})">삭제</button>
                	</li>
                	<li>
                    <button type="submit" class="noticeButton">
                     <div class="bcon">
                        <div class="message">${item.message}</div>
                        <div class="createdAt">
                            생성일:
                            <script>
                                var createdAt = "${item.createdAt}";
                                var formattedPastDate = moment(createdAt).fromNow();
                                document.write(formattedPastDate);
                            </script>
                        </div>
                        <div class="readYn">
                            <c:choose>
                                <c:when test="${item.readYn eq 'N'}">
                                    안읽음
                                </c:when>
                                <c:otherwise>
                                    읽음
                                </c:otherwise>
                            </c:choose>
                        </div>
                       </div>
                    </button>
                    </li>
                </ul>
                	</div>
                </form>
            </c:forEach>
    <div class="paging">
				<c:if test="${startPageNum!=1}">
					<%--페이징 이전,번호,다음에 대한 코드 --%>
					<a
						href="<%=request.getContextPath()%>/notice?currentPage=${startPageNum-1}"><span>이전</span></a>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="i">
					<a class="page${i}"
						href="<%=request.getContextPath()%>/notice?currentPage=${i}"><span>${i}</span></a>
				</c:forEach>
				<c:if test="${endPageNum<totalPageNum}">
					<a
						href="<%=request.getContextPath()%>/notice?currentPage=${endPageNum+1}"><span>다음</span></a>
				</c:if>
	</div>          
        </div>
    </div>
    
    <script>
    var count=0;
    
    	function deleteNotice(notiId){
    		$.ajax({
				  url: "${pageContext.request.contextPath}/notice/deletenotice",	
				  method: "post",
				  dataType: "text",
				  data:{notiId:notiId},
			  	  success: function(data){
			  		  if(data=='1'){
			  			  alert("알림이 삭제되었습니다.");
			  			  window.location.href="${pageContext.request.contextPath}/notice?currentPage=${currentPage}";
			  		  }
			  		  else if(data=='-1')
			  			  alert("로그인이 필요한 기능입니다.");
			  	  },
					error : (request,status,error)=>{
						console.log(request);
						console.log(status);
						console.log(error);
						alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
					}
				  });		
    	}
    	
    	function deleteAll(){
    		if(count==0){
    			console.log("선택된 알림이 없습니다.");
    			return;
    		}
    		var noticesFormdata=$('#notices').serialize();
    		$.ajax({
				  url: "${pageContext.request.contextPath}/notice/deletenotice",	
				  method: "post",
				  dataType: "text",
				  data:noticesFormdata,
			  	  success: function(data){
			  		  if(data>='1'){
			  			  alert(data+"개의 알림이 삭제되었습니다.");
			  			  window.location.href="${pageContext.request.contextPath}/notice?currentPage=${currentPage}";
			  		  }
			  		  else if(data=='-1')
			  			  alert("로그인이 필요한 기능입니다.");
			  		  else
			  			  alert("알림 삭제에 실패했습니다.");
			  	  },
					error : (request,status,error)=>{
						console.log(request);
						console.log(status);
						console.log(error);
						alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
					}
				  });		
    	}
    	
    	function selectNoti(index,notiId1,radio){
    		
    		if(index==0){
    			if($("#notiId").val()==""){
    				$("#notiId").val(notiId1);
    				count=count+1;
    			}
    			else{
    				$("#notiId").val("");
    				count=count-1;
    			}
    		}
    		else if(index==1){
    			if($("#notiId1").val()==""){
    				$("#notiId1").val(notiId1);
    			count=count+1;
			}
    			else{
    				$("#notiId1").val();
    			count=count-1;
			}
    		}
    		else if(index==2){
    			if($("#notiId2").val()==""){
    				$("#notiId2").val(notiId1);
    			count=count+1;
			}
    			else{
    				$("#notiId2").val("");
    			count=count-1;
			}
    		}
    		else if(index==3){
    			if($("#notiId3").val()==""){
    				$("#notiId3").val(notiId1);
    				count=count+1;
    			}
    			else{
    				$("#notiId3").val("");
    				count=count-1;
    			}
    		}
    		else if(index==4){
    			if($("#notiId4").val()==""){
    				$("#notiId4").val(notiId1);
    			count=count+1;
			}
    			else{
    				$("#notiId4").val("");
    			count=count-1;
			}
    		}
    		else{
    			if($("#notiId5").val()==""){
    				$("#notiId5").val(notiId1);
    			count=count+1;
			}
    			else{
    				$("#notiId5").val("");
    			count=count-1;
			}
    		}
    	}
    </script>
    
</body>
</html>
