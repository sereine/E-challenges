<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compiler Online</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script>

$body = $("body");



$(document).ready(function() {
	
	
	
	$('#run').click(
		function(event) {
			
			
			var code = $('#code').val();
			var input = $('#input').val();		
			var id = $('#languages').val();	
			
			var data = 'code='
					+ encodeURIComponent(code)
					+ '&input='
					+ encodeURIComponent(input)
					+ '&languages='
					+ encodeURIComponent(id);
			        
			$.ajax({
				url : $("#compiler").attr("action"),
				data : data,
				type : "GET",
 
				success : function(response) {
					$('#output').val(response);
					
					
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
				}
			});
		});
	});

</script>

<style>
#code {
    position: absolute;
    left: 200px;
    top: 50px;
}

#input {
    position: absolute;
    left: 600px;
    top: 50px;
}

#output {
    position: absolute;
    left: 600px;
    top: 220px;
}

#run {
    position: absolute;
    left: 530px;
    top: 520px;
}


#languages {
    position: absolute;
    left: 200px;
    top: 20px;
    width: 373px;
}


</style>



<body>



<form id="compiler" method="post" action="/project/responseCompiler?${_csrf.parameterName}=${_csrf.token}">
     
    
     <form:select path="languages" items="${languages}" itemLabel="nomLangage" name="languages" itemValue="idAsString" id="languages" /> 
    
    
     <textarea rows="30" cols="50" name="code"   id="code"></textarea>
     <textarea rows="10" cols="50" name="input"   id="input"></textarea>
     <textarea rows="10" cols="50" name="output"  id="output"></textarea>
     
     
     <button type="button" id="run">Run</button>
     
     
</form>


</body>
</html>