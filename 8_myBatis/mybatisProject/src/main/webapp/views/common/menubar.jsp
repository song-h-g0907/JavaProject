<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>

 	<!-- jQuery -->
    <script 
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
    <script
        src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
        integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
        crossorigin="anonymous"></script>
        
    <!-- 부트스트램 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    
    
 	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
 
	<style>
	    .login-area a{
	        text-decoration: none;
	        color: black;
	        font-size: 12px;
	    }
	
	    .nav-area{
	        background: black;
	        color: white;
	        height: 50px;
	    }
	    .menu{
	        display: table-cell;
	        width: 250px;
	        height: 50px;
	        vertical-align: middle;
	        font-size: 20px;
	        font-weight: bold;
	    }
	    .outer{
	    	width: 900px;
	    	background: black;
	    	color: white;
	    	margin: auto;
	    	margin-top: 50px;
	    }
	</style>
</head>
<body>

    <h1 align="center">welcome to Mybatis World</h1>
    <br>

    <div class="login-area" align="right">
    	<c:choose>
    		<c:when test="${ empty loginUser }">
		        <!-- 로그인전 -->
		        <form action="login.me" method="post">
			        <table>
			            <tr>
			                <td>아이디</td>
			                <td><input type="text" name="userId" required></td>
			                <td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
			            </tr>
			            <tr>
			                <td>비밀번호</td>
			                <td><input type="password" name="userPwd" required></td>
			                
			            </tr>
			            <tr>
			                <td colspan="3" align="center">
			                    <a href="">회원가입</a>
			                    <a href="">아이디/비번찾기</a>
			                </td> 
			            </tr>
		            </table>
		        </form>
	     	</c:when>
	       	<c:otherwise>
		        <!-- 로그인후 -->
		        <div>
		            <table>
		                <tr>
		                    <td colspan="2">
		                        <h3>${loginUser.userName}님 환영합니다. </h3>
		                    </td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td><a href="">마이페이지</a></td>
		                    <td><a href="">로그아웃</a></td>
		                </tr>
		            </table>
		        </div>
	        </c:otherwise>
        </c:choose>
    </div>
    <br>

    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu" onclick="requestPay()" >공지사항</div>
        <div class="menu">게시판</div>
        <div class="menu">ETC</div>
    </div>
    <script>
	    function requestPay() {
	    	IMP.init('store-2c741ae7-334b-4984-9a8c-62eba220c91b');
	    	IMP.request_pay({
	    	    pg : 'kakaopay',
	    	    pay_method : 'card', //생략 가능
	    	    merchant_uid: 'TC0ONETIME', // 상점에서 관리하는 주문 번호
	    	    name : '주문명:결제테스트',
	    	    amount : 14000,
	    	    buyer_email : 'iamport@siot.do',
	    	    buyer_name : '구매자이름',
	    	    buyer_tel : '010-1234-5678',
	    	    buyer_addr : '서울특별시 강남구 삼성동',
	    	    buyer_postcode : '123-456'
	    	}, function(rsp) { // callback 로직
	    		if ( response.success ) { //결제 성공
	    			console.log(response);
	    		} else {
	    			alert('결제실패 : ' + response.error_msg);
	    		}
	    	});
	    }
    </script>
</body>
</html>