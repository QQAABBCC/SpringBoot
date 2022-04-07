<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/default.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p />
    <c:forEach var="workMessage" items="${page.content}">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<div class="card-header">
						新增訊息的時間 
						<span>
						<fmt:formatDate
								pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${workMessage.added}" />
						</span>
					</div>
					<div class="card-body">
						<c:out value="${workMessage.text}" />

					</div>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</body>
</html>