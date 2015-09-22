<%@include file="include/_head.jsp"%>
<body>
	<c:forEach items="${users }" var="user">
		${user.usID }
	</c:forEach>
</body>
</html>