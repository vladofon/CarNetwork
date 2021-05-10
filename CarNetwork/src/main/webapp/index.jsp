<%@
	page import = "ua.com.foxminded.db.*"
%>
<%@
	page import = "ua.com.foxminded.sitecore.*"
%>
<html>
<body>
	<h2>Hello World! It's all of my cars!</h2><br>

	<%
		for(String carName : DatabaseFacade.getInfo()) {
			out.println("Car in garage: <b>" + carName + "</b>" + 
			"<form method='POST' action='garageDeleteForm' "+
			"style='display: inline-block; margin-left: 10px; margin-bottom: 0px'>"+
			"<input type='hidden' name='dlt' value='"+ carName +"'>"+
			"<input type='submit' value='delete'"+
			"style='display: inline; background: red; color: white; font-size: 7px; padding: 2px; "+
			"border: 0px; border-radius: 3px; cursor: pointer;'>"+
			"</form><br>");
		}
	
/* 		if(request.getParameter("input") != null)
		{
			DatabaseFacade.insert(request.getParameter("input"));
			response.sendRedirect("http://localhost:8080/WebProject/index.jsp");
		} */
		
/* 		if(request.getParameter("dlt") != null)
		{
			DatabaseFacade.delete(request.getParameter("dlt"));
			response.sendRedirect("http://localhost:8080/WebProject/index.jsp");
		} */
	%>



	<form style='margin-top: 15px' method='POST' action='garageAddForm'>
		<input name ="input" type="text">
		<input type="submit" value="send">
	</form>

</body>
</html>