<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajouter challenge</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Ajouter challenge</h1>
 	
	<form:form method="POST"  class="form-horizontal" modelAttribute="challengetest">
	
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="titre">Titre challenge</label>
				<div class="col-md-7">
					<form:input type="text" path="titre" id="titre" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="titre" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">Description</label>
				<div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="description" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="date_echeance">date d'écheance </label>
				<div class="col-md-7">
					<form:input type="date" path="date_echeance" id="date_echeance" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="date_echeance" class="help-inline"/>
					</div> 
				</div>
			</div>
		</div>

		<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="poste"> poste </label>
						<div class="col-md-7">
							<form:input type="text" path="poste" id="poste" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="poste" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>

               <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="type"> type </label>
						<div class="col-md-7">
							<form:select id="type" name="type" path="type" >
							<option>Stage PFE </option>
							<option>Stage Cadre</option>
							<option>Recrutement</option>
							</form:select>
							
							<div class="has-error">
								<form:errors path="type" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				
				
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="langage"> langage </label>
						<div class="col-md-7">
							     <form:select path="langage" items="${langage}" itemLabel="nomLangage" name="langage" itemValue="id" id="langage" /> 
							
							
							<div class="has-error">
								<form:errors path="langage" class="help-inline"/>
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