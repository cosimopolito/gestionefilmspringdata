<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	
	<meta charset="ISO-8859-1">
	
	<title>Cancella elemento</title>
	
	 <link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo</dt>
				  <dd class="col-sm-9">${filmDaEliminare.titolo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere:</dt>
				  <dd class="col-sm-9">${filmDaEliminare.genere}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Minuti Durata (min):</dt>
				  <dd class="col-sm-9">${filmDaEliminare.minutiDurata}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Pubblicazione:</dt>
				   <fmt:formatDate type = "date" var="dataParsed" value ="${filmDaEliminare.dataPubblicazione}" pattern="yyyy-MM-dd"/>
				  <dd class="col-sm-9">${dataParsed}</dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		   
		        
		        <form action="ExecuteDeleteFilmServlet" method="post" >
		        	<input type ="hidden" name="idFilmDaEliminare" value = "${filmDaEliminare.id}"> 
		        	
		        	<a href="ExecuteListFilmServlet" class='btn btn-outline-secondary' style='width:80px'>
		            	<i class='fa fa-chevron-left'></i> Back
		            </a>
		            
		            <button type="submit" name="submit" value="submit" id="submit" class='btn btn-outline-secondary' style='width:80px'>Delete</button>
		        </form>
		        
		    </div>
		</div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>