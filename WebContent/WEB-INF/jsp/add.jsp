<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交数据</title>
<link rel="stylesheet" href="${contextPath}/assets/css/form-validation.css">
<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.css">	
<style type="text/css">
	.form-error{
		color:red;
		margin-left:50px;
	}
</style>
</head>
<body>
	<h2>添加数据</h2>
	<div class="container">
		<form:form action="${contextPath}/add" method="POST" commandName="book" >
			<div class="form-group">
				<label for="exampleInputEmail1">书名</label>
				<form:input path="bookname" cssClass="form-control" /><br/>
				<form:errors path="bookname" cssClass="form-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">作者</label>
				<form:input path="author" cssClass="form-control" /><br/>
				<form:errors path="author" cssClass="form-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">出版社</label>
				<form:input path="publishConpany" cssClass="form-control" /><br/>
				<form:errors path="publishConpany" cssClass="form-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">出版年份</label>
				<form:input path="publishDate" cssClass="form-control" /><br/>
				<form:errors path="publishDate" cssClass="form-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">简介</label>
				<form:input path="info" cssClass="form-control" /><br/>
				<form:errors path="info" cssClass="form-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">类别</label>
				<form:input path="booktype" cssClass="form-control" /><br/>
				<form:errors path="booktype" cssClass="form-error"></form:errors>
			</div>
			<input type="submit" class="btn btn-primary" value="提交">
		</form:form>
	</div>
</body>
</html>