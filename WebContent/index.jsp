<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="pages" uri="/WEB-INF/tag/pager.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=urf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" id="testForm">

		<pages:createPager pageSize="5" totalPage="10" totalCount="50"
			curPage="1" formId="testForm" />
	</form>
</body>
</html>