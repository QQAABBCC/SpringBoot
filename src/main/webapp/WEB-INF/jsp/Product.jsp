<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<jsp:include page="layout/default.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<p />
		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<div class="card-header">新增訊息</div>
					<div class="card-body">

						<form:form class="form" method="POST"
							modelAttribute="workMessages">

							<!-- form:errors  bindingResult 回傳的物件 -->
							<form:errors path="text" />

							<div class="input-group">
								<form:textarea path="text" class="form-control"></form:textarea>
							</div>

							<input type="submit" name="submit" value="新增訊息">
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>