<%-- 
    Document   : index
    Created on : 26/12/2015, 13:12:36
    Author     : omartini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>EJB e CDI Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
	var wooYayIntervalId = 0;

	var servicesEJBs = [ 'PerformanceGateCDI', 'PerformanceLocalStatelessEJB',
			'PerformanceRemoteStatelessEJB', 'PerformanceRemoteStatefulEJB',
			'PerformanceRemoteSingletonEJB' ];

	var responsesEJBs = [ '#responsePerformanceCDI',
			'#responseLocalStatelessEJB', '#responseRemoteStatelessEJB',
			'#responseRemoteStatefulEJB', '#responseRemoteSingletonEJB' ];

	$(function() {
		$("#aioConceptName").on("change", function() {
			//$("#debug").text($("#aioConceptName").val());
		}).trigger("change");
	});

	function wooYayClickHandler() {
		if (document.getElementById("wooYayButton").value == "Clicar Aqui Benzinho") {
			// Start the timer
			//document.getElementById("wooYayButton").value = "Parar Timer!";
			$("#wooYayButton").attr('value', 'Parar Timer!');

			wooYayIntervalId = setInterval("wooYay()", $("#aioConceptName")
					.val());
		} else {
			document.getElementById("setTimerIntervalMessage").innerHTML = "Stoped SetInterval: "
					+ $("#aioConceptName").val() + " millis";

			//document.getElementById("wooYayButton").value = "Clicar Aqui Benzinho";
			$("#wooYayButton").attr('value', 'Clicar Aqui Benzinho');

			clearInterval(wooYayIntervalId);
		}
	}

	function wooYay() {
		//if (Math.random() > .5) {
		document.getElementById("setTimerIntervalMessage").innerHTML = "Iniciado SetInterval: "
				+ $("#aioConceptName").val() + " millis";
		//} else {
		//	document.getElementById("setTimerIntervalMessage").innerHTML = "Value!";
		//}

		//setTimeout('document.getElementById("setTimerIntervalMessage").innerHTML = ""',
		//		500);

		callDirectURIs();

	}

	function callDirectURIs() {
		// this is how you set it up
		var synchronizer = new ajaxSynchronizer();
		synchronizer.add(foo1);
		synchronizer.add(foo2);
		synchronizer.add(foo3);
		synchronizer.add(foo4);
		synchronizer.add(foo5);
		synchronizer.callWhenFinished(afterFunction);
	}

	function foo1(callback) {
		$.ajax({
			url : servicesEJBs[0], //'/echo/html/',
			success : function(data) {
				//alert('foo1');
				$(responsesEJBs[0]).text(data).css("font-weight", "Bold").css(
						'color', 'red');
				callback();
			}
		});
	}

	function foo2(callback) {
		$.ajax({
			url : servicesEJBs[1], //'/echo/html/',
			success : function(data) {
				//alert('foo2');
				$(responsesEJBs[1]).text(data).css("font-weight", "Bold").css(
						'color', 'red');
				callback();
			}
		});
	}

	function foo3(callback) {
		$.ajax({
			url : servicesEJBs[2], //'/echo/html/',
			success : function(data) {
				//alert('foo2');
				$(responsesEJBs[2]).text(data).css("font-weight", "Bold").css(
						'color', 'red');
				callback();
			}
		});
	}

	function foo4(callback) {
		$.ajax({
			url : servicesEJBs[3], //'/echo/html/',
			success : function(data) {
				//alert('foo2');
				$(responsesEJBs[3]).text(data).css("font-weight", "Bold").css(
						'color', 'red');
				callback();
			}
		});
	}

	function foo5(callback) {
		$.ajax({
			url : servicesEJBs[4], //'/echo/html/',
			success : function(data) {
				//alert('foo2');
				$(responsesEJBs[4]).text(data).css("font-weight", "Bold").css(
						'color', 'red');
				callback();
			}
		});
	}

	// here is my simplified solution
	ajaxSynchronizer = function() {
		var funcs = [];
		var funcsCompleted = 0;
		var callback;

		this.add = function(f) {
			funcs.push(f);
		}

		this.synchronizer = function() {
			funcsCompleted++;
			if (funcsCompleted == funcs.length) {
				callback.call(this);
			}
		}

		this.callWhenFinished = function(cb) {
			callback = cb;
			for (var i = 0; i < funcs.length; i++) {
				funcs[i].call(this, this.synchronizer);
			}
		}
	}

	// this is the function that is called when both ajax calls are completed.
	afterFunction = function() {
		//alert('All done!');
	}

	$(document)
			.ready(
					function() {

						$('#submit').click(function(event) {
							var username = $('#user').val();
							$.get('ActionServlet', {
								user : username
							}, function(responseText) {

								$('#welcometext').text(responseText);

								console.log(responseText);

							});
						});

						$('#submitPrimeJSFEJB3')
								.click(
										function(event) {
											event.preventDefault();

											$(location)
													.attr('href',
															'http://wservices-sysmartek.rhcloud.com/listaMercadorias.jsf');
											//  					$(window).attr('location','http://localhost:8080/cdi-jsf-1.0/');
											//  					$(location).prop('href', 'http://localhost:8080/cdi-jsf-1.0/');

										});

						$('#submitSpringMVC')
								.click(
										function(event) {
											event.preventDefault();

											alert('Meu amor Preciso Estudar Sprimg MVC');
											return null;

											$(location)
													.attr('href',
															'http://wservices-sysmartek.rhcloud.com/listaMercadorias.jsf');
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
			<h3>Call Servlets with EJBs via Jquery</h3>
			<h3>Muliple Calls Timers in JavaScript</h3>
			<h3>Call CRUD EJB - JSF on Openshif</h3>
			  
			<div id="setTimerIntervalMessage"
				style="height: 1.5em; font-size: 2em; color: blue;"></div>
			<div class="container">
				<input id="wooYayButton" type="button"
					onclick="wooYayClickHandler()" value="Clicar Aqui Benzinho"
					class="btn btn-info btn-block"></input>
			</div>
			<div>
				<select id="aioConceptName">
					<option value="100" selected>100 millis</option>
					<option value="200">200 millis</option>
					<option value="300">300 millis</option>
					<option value="500">500 millis</option>
					<option value="1000">1000 millis</option>
				</select>
				<!-- 				<div id="debug"></div> -->
			</div>
		</div>
		<div>
			<h3>Test of CDI!</h3>
			<h3>
				<a class="callCDI" href="PerformanceGateCDI">Performance CDI</a>
			</h3>
			<div id="responsePerformanceCDI"></div>
		</div>
		<div>
			<h3>Test of @Local @Stateless EJB</h3>
			<h3>
				<a class="callLocalStatelessEJB" href="PerformanceLocalStatelessEJB">Performance
					Local Stateless EJB</a>
			</h3>
			<div id="responseLocalStatelessEJB"></div>
		</div>
		<div>
			<h3>Test of @Remote @Stateless EJB</h3>
			<h3>
				<a class="callRemoteStatelessEJB"
					href="PerformanceRemoteStatelessEJB">Performance Remote
					Stateless EJB</a>
			</h3>
			<div id="responseRemoteStatelessEJB"></div>
		</div>
		<div>
			<h3>Test of @Remote @Stateful EJB</h3>
			<h3>
				<a class="callRemoteStatefulEJB" href="PerformanceRemoteStatefulEJB">Performance
					Remote Stateful EJB</a>
			</h3>
			<div id="responseRemoteStatefulEJB"></div>
		</div>
		<div>
			<h3>Test of @Remote @Singleton EJB</h3>
			<h3>
				<a class="callRemoteSingletonEJB"
					href="PerformanceRemoteSingletonEJB">Performance Remote
					Singleton EJB</a>
			</h3>
			<div id="responseRemoteSingletonEJB"></div>
		</div>
		<br />

		<h3>Test JavaScript</h3>
		<input class="form-control" type="text" id="user" /> <input
			class="btn btn-primary btn-block" type="button" id="submit"
			value="Ajax Submit" />
		<div id="welcometext"></div>

		<h3>Test JSF Prime EJB 3 Persistence</h3>
		<input class="btn btn-primary btn-block" type="button"
			id="submitPrimeJSFEJB3" value="PRIME JSF ManagedBean" /> <br />

		<h3>Test Spring MVC</h3>
		<input class="btn btn-primary btn-block" type="button"
			id="submitSpringMVC" value="Spring MVC" /> <br />


	</div>

</body>

</html>
