<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inscription Etudiant</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Inscription Etudiant</h1>
 	
	<form:form method="POST" modelAttribute="etudiant" class="form-horizontal" >

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">Nom</label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName">Prenom</label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		
		<form:input type="hidden" path="compte.ssoId" id="ssoId" class="form-control input-sm" />
			

	   
	   <form:input type="hidden" path="compte.password" id="password" class="form-control input-sm" />
			

	
		<form:input type="hidden" path="email" id="email" class="form-control input-sm" />
			
        
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="tel">Tel</label>
				<div class="col-md-7">
					<form:input type="text" path="tel" id="tel" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="tel" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
        
        
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" >CNE</label>
				<div class="col-md-7">
					<form:input type="text" path="cne" id="cne" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="cne" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
        
       
        
        
        
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Enregistrement" class="btn btn-primary btn-sm"> or <a href="<c:url value='/' />">Annuler</a>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>