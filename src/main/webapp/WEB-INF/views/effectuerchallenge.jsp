<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Effectuer Challenge</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="<c:url value='/static/js/effectuerchallenge.js' />"></script>
<script src="<c:url value='/static/js/jquery.cookie.js' />"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/effectuerchallenge.css' />" rel="stylesheet"></link>


<script>

var action_compile = "/project/responseCompilerTest?${_csrf.parameterName}=${_csrf.token}";
var id_challenge = ${id_challenge}; 
var envoyer_solution = "/project/envoyerSolution?${_csrf.parameterName}=${_csrf.token}";

</script>

<body>
<div class="container">         

<div class="row" id="ide">
  
  
  
  <div class="col-sm-4 col-sm-offset-1">
  <p> <b>code : </b> </p>
  <form id="compiler" method="post" action="/project/responseCompiler?${_csrf.parameterName}=${_csrf.token}">
     <textarea rows="15" cols="50" name="code"   id="code"></textarea>  
  </form>
  
  <div style="margin-left : 15px;">
  <button class="button upload" >
    Upload <input type="file" id="file">
  </button>
  <button class="button compile">Compiler</button>
  <button class="button envoyer">Envoyer</button>
  </div>
  
  </div>
  
 <div class="col-sm-5" > 
 <table class="table table-bordered" id="table_info">
    <tbody>
      <tr >
        <td> <b> Titre challenge : </b></td>
        <td>${titre}</td>
      </tr>
      <tr >
        <td> <b> Langage de programmation : </b></td>
        <td> ${language} </td>
      </tr>
      </tbody>
</table> 

<div class="alert alert-success" id="success" style="display: none;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success !</strong> 
  
  <div id="msgsuccess">  </div>
   <table class="table table-bordered">
    <tbody>
      <tr >
        <td> <b> date : </b></td>
        <td id="date"></td>
      </tr>
      <tr >
        <td> <b> time : </b></td>
        <td id="time"></td>
      </tr>
      <tr >
        <td> <b> memory (byte) : </b></td>
        <td id="memory"></td>
      </tr>
      </tbody>
</table> 
  
  
</div>

<div class="alert alert-danger" id="error" style="display: none;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Error !</strong> 
  <div id="msgerror"> </div>
</div>
 </div> 


</div>    

</div>
</body>
</html>