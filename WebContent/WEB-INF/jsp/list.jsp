<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ͼ���б�</title>
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
				<th>���</th>
				<th>����</th>
				<th>����</th>
				<th>������</th>
				<th>���</th>
				<th>���</th>
				<th>��������</th>
				<th>����</th>
			</tr>
			<!-- ���� ���� ������ ������� ��� ��� -->
			<c:forEach items="${books}" var="book" varStatus="b">
				<tr>
					<td>${book.id}</td>
					<td>${book.bookname}</td>
					<td>${book.author}</td>
					<td>${book.publishConpany}</td>
					<td>${book.info}</td>
					<td>${book.booktype}</td>
					<td>${book.publishDate}</td>
					<td><a href="${contextPath}/update/${book.id}">�޸�</a>&nbsp;<a href="${contextPath}/delete?id=${book.id}">ɾ��</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center"><a href="${contextPath}/addJsp">����ӡ�</a></td>
			</tr>
		</table>
	</div>
</body>
</html>