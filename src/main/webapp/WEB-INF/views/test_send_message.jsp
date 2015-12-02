<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script> 
</head>
<body>
	<input id="test" type="text"/><input type="button" value="send" id="btn_send">
	
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script> 
<script type="text/javascript">

	$(document).ready(function(){
		$("#btn_send").click(function(){
			sendMessage();
		});
		
		var wsURI = "ws://" + document.location.host + "${pageContext.request.contextPath}/echo";
		if (!("WebSocket" in window)) {
			console.log("WebSocket is not support on your browser...")
		} else {
			console.log("WebSocket is support on your browser...");
		}
		console.log(wsURI);
		var connection = new WebSocket(wsURI);
		var sendedMessage = "";
		connection.binaryType = 'arraybuffer';
	
		connection.onopen = function(event) {
			onOpen(event);
		}
	
		connection.onerror = function(event) {
			onError(event);
	
		}
		connection.onmessage = function(event){
			onMessage(event);
        };
		
		function onOpen(event) {
			console.log("CONNECTED...")
		}
	
		function onError(event) {
			console.log(event);
		}
	
		function sendMessage() {
			sendedMessage = "SENT";
			if (connection.readyState != WebSocket.OPEN) {
				return;
			}
			if (connection.bufferedAmount == 0) {
				connection.send("SENT");
			} 
		}
		function onMessage(event) {
			console.log("test");
            console.log(event.data);
        }
	});
</script>
</body>
</html>