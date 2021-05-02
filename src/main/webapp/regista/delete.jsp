<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<jsp:include page="../header.jsp" />
	<link href="./assets/css/global.css" rel="stylesheet">
		
	<title>Elimina regista</title>
	
</head>

<body>

	<jsp:include page="../navbar.jsp" />

	
	<main role="main" class="container">

			<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio da eliminare
		    </div>
		
		    <div class='card-body'>

				<dl class="row">
					<dt class="col-sm-3 text-right">Id:</dt>
					<dd class="col-sm-9">${regista_delete.id}</dd>
				</dl>

		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Nome:</dt>
				  <dd class="col-sm-9">${regista_delete.nome}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cognome:</dt>
				  <dd class="col-sm-9">${regista_delete.cognome}</dd>
		    	</dl>

				<dl class="row">
					<dt class="col-sm-3 text-right">Data Di Nascita:</dt>
					<dd class="col-sm-9"><fmt:formatDate type = "date" value = "${regista_delete.dataDiNascita}" /></dd>
				</dl>

				<dl class="row">
					<dt class="col-sm-3 text-right">Sesso:</dt>
					<dd class="col-sm-9">${regista_delete.sesso}</dd>
				</dl>
		    </div>
		    
		    <div class='card-footer'>
		        <form action="ExecuteDeleteRegistaServlet" method="post">
			       <a href="ExecuteListRegistaServlet" class='btn btn-outline-secondary' style='width:7em'>
		             <i class='fa fa-chevron-left'></i> Indietro
		           </a>
			       	<input type="hidden" name="idDeleteInput" value="${regista_delete.id}">
		        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-danger" style='width:7em;'>Elimina</button>
		        </form>
		       
		    </div>
		    
		</div>	
		
	</main>
	
	<jsp:include page="../footer.jsp" />

</body>

</html>