<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenWeather</title>
<link rel="stylesheet" href="./css/search-page.css">
</head>
<body>

	<div class="search-box">
		<form action="OWservlet" method="get">
			<div class="input-box">
				City:<input type="text" name="city" />
			</div>
			<div class="input-box">
				Country:<input type="text" name="country" /><br />
			</div>
			<div class="input-box">
				<input type="submit" value="go" id="goBtn"/>
			</div>
			<c:if test="${empty cookie['acceptCookies']}">
				<div class="input-box">
					<input type="hidden" value="false" id="acceptCookiesBool" name="acceptCookiesBool"/>
				</div>
			</c:if>
			
			
			
		</form>
	</div>
	

	
	<c:if test="${empty cookie['acceptCookies']}">
		<div class="cookies-modal-box" id="cookies-box">
			<h2>do you accept cookies</h2>
			<div class="buttons-box">
				<button id="acceptBtn">accept</button>
				<button id="declineBtn">Decline</button>
			</div>
		</div>
	</c:if>


	<script src="js/cookies.js"></script>

</body>
</html>
