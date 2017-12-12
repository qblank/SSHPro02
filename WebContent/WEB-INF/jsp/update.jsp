<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交数据</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/form-validation.css">
<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.css">		
</head>
<body>
	<div class="container">
			<form:form action="${pageContext.request.contextPath }/updateJsp"
			method="post" commandName="book">
			<div class="form-group">
				<label for="exampleInputEmail1">书名</label>
				<form:input path="bookname" cssClass="form-control" value="${book.bookname}"/>
				<form:errors path="bookname"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">作者</label>
				<form:input path="author" cssClass="form-control" value="${book.author}"/>
				<form:errors path="author"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">出版社</label>
				<form:input path="publishConpany" cssClass="form-control" value="${book.publishConpany}"/>
				<form:errors path="publishConpany"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">出版年份</label>
				<form:input path="publishDate" cssClass="form-control" value="${book.publishDate}"/>
				<form:errors path="publishDate"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">简介</label>
				<form:input path="info" cssClass="form-control" value="${book.info}"/>
				<form:errors path="info"></form:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">类别</label>
				<form:input path="booktype" cssClass="form-control" value="${book.booktype}"/>
				<form:errors path="booktype"></form:errors>
			</div>
			<input type="submit" class="btn btn-primary" value="提交">
		</form:form>
	</div>
	
</body>
</html>