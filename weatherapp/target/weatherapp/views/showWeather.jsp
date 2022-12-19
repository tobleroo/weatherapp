<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>the weather</title>
<link rel="stylesheet" href="./css/weather.css">
</head>
<body>

	<div class="main-box">
		<div class="location-box">
			<h2><c:out value="${wBean.cityStr}"/>, </h2>
			<h2><c:out value="${wBean.countryStr}"/></h2>
		</div>
		<div class="data-box">
			<p>clouds: <c:out value="${wBean.cloudsStr}"/></p>
			<p>sunrise at: <c:out value="${wBean.sunRise}"/></p>
			<p>searched at time: <c:out value="${wBean.lastUpdate}"/></p>
		</div>

		<div class="history-box">
			<c:forEach items="${searchHistory}" var="item">
				<div class="each-search-box">
					<a href="OWservlet?city=${item.city}&country=${item.country}">previous search</a>
					<h3>hello</h3>
					<p>${item.city}, <span>${item.country}</span></p>
				</div>
			</c:forEach>
		</div>

	</div>

</body>
</html>