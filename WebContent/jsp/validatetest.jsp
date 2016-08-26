<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="contentModel" method="post">
		<form:errors path="*"></form:errors>
		<br />
		<br />     
                       姓名:<form:input path="name"  readonly="true"/>
		<br />
		<form:errors path="name"></form:errors>
		<br />
                     年龄:<form:input path="age" />
		<br />
		<form:label path="date" ></form:label>
		<br />
		
                     日期:<spring:eval expression="contentModel.date"></spring:eval>
		<br />
		 男:<form:checkbox path="sex" /><br/>
		 角色:<form:checkboxes path="roles" items="${roleList}" />
		<br />
		

	</form:form>
</body>
</html>