<%-- 
    Document   : index
    Created on : 26/12/2015, 13:12:36
    Author     : omartini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EJB e CDI Test</title>
<link href=”resources/bootstrap/bootstrap.css” rel=”stylesheet”
	type=”text/css” />
<style>
.jumbotron {
	width: 400px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
}

.table {
	margin-top: 20px;
}

.form-control {
	margin-top: 5px;
}
</style>
<script src="resources/javascript/jquery.min.js"></script>
<script src="resources/javascript/jquery.mobile-1.4.5.min.js"></script>
<script>
            $(document).ready(function() {                       
               
                $('#submit').click(function(event) {  
                    var username = $('#user').val();
                 	$.get('ActionServlet',{user:username},function(responseText) { 
                        
                        $('#welcometext').text(responseText);         
			        	
			        	console.log(responseText);
                    
                    });
                });
                
                
                $('#submitPrimeJSFEJB3').click(function(event){  
					event.preventDefault();
			    	
					$(location).attr('href','http://wservices-sysmartek.rhcloud.com/listaMercadorias.jsf');
//  					$(window).attr('location','http://localhost:8080/cdi-jsf-1.0/');
//  					$(location).prop('href', 'http://localhost:8080/cdi-jsf-1.0/');
				
				});
				
				
			$('#submitSpringMVC').click(function(event){  
					event.preventDefault();

					alert('Meu amor Preciso Estudar Sprimg MVC');
					return null;
			    	
					$(location).attr('href','http://wservices-sysmartek.rhcloud.com/listaMercadorias.jsf');
//  					$(window).attr('location','http://localhost:8080/cdi-jsf-1.0/');
//  					$(location).prop('href', 'http://localhost:8080/cdi-jsf-1.0/');
				
				});
                
                
                  $("a.callCDI").click(function(event) {
			    	event.preventDefault();
			    	var url = $(this).attr("href");
			
			    	$.get(url, function(data) {
			    	
			        	console.log(data);
			        	$('#responsePerformanceCDI').text(data);    
			        
			    	});
				});
                
               
                  $("a.callLocalStatelessEJB").click(function(event) {
			    	event.preventDefault();
			    	var url = $(this).attr("href");
			
			    	$.get(url, function(data) {
			    	
			        	console.log(data);
			        	$('#responseLocalStatelessEJB').text(data);    
			        
			    	});
				});


                  $("a.callRemoteStatelessEJB").click(function(event) {
			    	event.preventDefault();
			    	var url = $(this).attr("href");
			
			    	$.get(url, function(data) {
			    	
			        	console.log(data);
			        	$('#responseRemoteStatelessEJB').text(data);    
			        
			    	});
				});
				
				 $("a.callRemoteStatefulEJB").click(function(event) {
			    	event.preventDefault();
			    	var url = $(this).attr("href");
			
			    	$.get(url, function(data) {
			    	
			        	console.log(data);
			        	$('#responseRemoteStatefulEJB').text(data);    
			        
			    	});
				});
				
				 $("a.callRemoteSingletonEJB").click(function(event) {
			    	event.preventDefault();
			    	var url = $(this).attr("href");
			
			    	$.get(url, function(data) {
			    	
			        	console.log(data);
			        	$('#responseRemoteSingletonEJB').text(data);    
			        
			    	});
				});

            
            });
		</script>

</head>
<body>
<%--     <% response.sendRedirect("listaMercadorias.jsf"); %> --%>
	<div class=jumbotron>
		<div>
			<h2>Test of CDI!</h2>
			<h2>
				<a class="callCDI" href="PerformanceGateCDI">Performance CDI</a>
			</h2>
			<div id="responsePerformanceCDI"></div>
		</div>
		<div>
			<h2>Test of @Local @Stateless EJB</h2>
			<h2>
				<a class="callLocalStatelessEJB" href="PerformanceLocalEJB">Performance 
					Local Stateless EJB</a>
			</h2>
			<div id="responseLocalStatelessEJB"></div>
		</div>
		<div>
			<h2>Test of @Remote @Stateless EJB</h2>
			<h2>
				<a class="callRemoteStatelessEJB" href="PerformanceRemoteStatelessEJB">Performance 
					Remote Stateless EJB</a>
			</h2>
			<div id="responseRemoteStatelessEJB"></div>
		</div>
		<div>
			<h2>Test of @Remote @Stateful EJB</h2>
			<h2>
				<a class="callRemoteStatefulEJB" href="PerformanceRemoteStatefulEJB">Performance 
					Remote Stateful EJB</a>
			</h2>
			<div id="responseRemoteStatefulEJB"></div>
		</div>
		<div>
			<h2>Test of @Remote @Singleton EJB</h2>
			<h2>
				<a class="callRemoteSingletonEJB" href="PerformanceRemoteSingletonEJB">Performance 
					Remote Singleton EJB</a>
			</h2>
			<div id="responseRemoteSingletonEJB"></div>
		</div>
		<br />

		<h1>Test JavaScript</h1>
		<input class="form-control" type="text" id="user" /> <input
			class="btn btn-primary btn-block" type="button" id="submit"
			value="Ajax Submit" />
		<div id="welcometext"></div>

		<h1>Test JSF Prime EJB 3 Persistence</h1>
		<input class="btn btn-primary btn-block" type="button" id="submitPrimeJSFEJB3"
			value="PRIME JSF ManagedBean" /> <br />

		<h1>Test Spring MVC</h1>
		<input class="btn btn-primary btn-block" type="button" id="submitSpringMVC"
			value="Spring MVC" /> <br />


	</div>

</body>

</html>
