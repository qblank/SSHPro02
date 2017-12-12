<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<style type="text/css">
	table{
		text-align:center;
		margin: 0 auto;
	}
</style>
<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<table border="1" class="table">
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>简介</th>
				<th>类别</th>
				<th>出版日期</th>
				<th>操作</th>
			</tr>
			<!-- 书名 作者 出版社 出版年份 简介 类别 -->
			<c:forEach items="${books}" var="book" varStatus="b">
				<tr>
					<td>${book.id}</td>
					<td>${book.bookname}</td>
					<td>${book.author}</td>
					<td>${book.publishConpany}</td>
					<td>${book.info}</td>
					<td>${book.booktype}</td>
					<td>${book.publishDate}</td>
					<td><a href="${contextPath}/update/${book.id}">修改</a>&nbsp;<a href="${contextPath}/delete?id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center"><a href="${contextPath}/addJsp">【添加】</a></td>
			</tr>
		</table>
	</div>
</body>
</html>