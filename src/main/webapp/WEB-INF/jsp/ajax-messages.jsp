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
<h1>ajax Messages Page</h1>


<div class="container">
    <input id="myMesssage" />
    <button id="submitBtn"></button>

<div>
  <table class="mytable" id="list_table_json">
  <thead>
   <tr>
       <th>訊息內容</th>
       <th>時間</th>
   </tr>
  </thead>
  </table>
</div>

</div>
<script>
  $(document).ready(function(){
      $('#submitBtn').click(function(){
        var inputText = document.getElementById('myMesssage').value;
        var dtoObject = {"message": inputText};
        var dtoJsonString = JSON.stringify(dtoObject);

        $.ajax({
            url:'http://localhost:8080/myapp/api/postMessage',
            contentType: 'application/json; charset=UTF-8', // 送過去的
            dataType: 'json', // 傳回來的
            method: 'post',
            data: dtoJsonString,
            success: function(result){
            	$('#list_table_json tr td').remove();
                console.log(result)
                msg_data = '';
                $.each(result, function(index, value){
                    msg_data += '<tr>'
                    msg_data += '<td>' + value.text + '</td>'
                    msg_data += '<td>' + value.added + '</td>'
                    msg_data += '<tr>'
                })
                $('#list_table_json').append(msg_data);
            },
            error: function (err) {
                console.log(err);
            }
        })

      })
  })


</script>

</body>
</html>