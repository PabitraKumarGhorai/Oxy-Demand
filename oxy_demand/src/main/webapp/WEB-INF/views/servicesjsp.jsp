<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#ADD8E6;">
	<div align="center">
  <h1>Oxygen Registration Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Full Name</td>
     <td><input type="text" name="fullname" /></td>
    </tr>
    <tr>
     <td>Address Line1</td>
     <td><input type="text" name="add1" /></td>
    </tr>
    <tr>
     <td>Address Line2</td>
     <td><input type="text" name="add2" /></td>
    </tr>
    <tr>
     <td>State</td>
     <td><input type="text" name="state" /></td>
    </tr>
    <tr>
     <td>City</td>
     <td><input type="text" name="city" /></td>
    </tr>
    <tr>
     <td>Aaddhar Card</td>
     <td><input type="text" name="adhar" /></td>
    </tr>
     <tr>
     <td>Contact No</td>
     <td><input type="text" name="mobile" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>