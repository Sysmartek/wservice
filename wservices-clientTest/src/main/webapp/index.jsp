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

<link href="resources/assets/css/style.css" rel="stylesheet" />

<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>

<script src="resources/assets/js/script.js"></script>
<script src="resources/javascript/js/callBackAjax.js"></script>
<script src="resources/javascript/js/codeDesign.js"></script>
<script src="resources/javascript/js/documentReadyMain.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- <script src="resources/javascript/jquery.min.js"></script> -->
<!-- <script src="resources/javascript/jquery.mobile-1.4.5.min.js"></script> -->
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

.textarea {
	overflow: hidden;
	overflow-x: hidden;
	overflow-y: hidden;
	padding: 10px;
}

#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: auto;
	width: 300px;
	float: left;
	padding: 5px;
	width: 300px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>

<script>
	
</script>

</head>
<body>
	<%--     <% response.sendRedirect("listaMercadorias.jsf"); %> --%>
	<details>
		<summary>Clock and Alarm</summary>
		<form>
		<div id="clock" class="light">
			<div class="display">
				<div class="weekdays"></div>
				<div class="ampm"></div>
				<div class="alarm"></div>
				<div class="digits"></div>
			</div>
		</div>

		<div class="button-holder">
			<a id="switch-theme" class="button">Switch Theme</a> <a
				class="alarm-button"></a>
		</div>

		<!-- The dialog is hidden with css -->
		<div class="overlay">

			<div id="alarm-dialog">

				<h2>Set alarm after</h2>

				<label class="hours"> Hours <input type="number" value="0"
					min="0" />
				</label> <label class="minutes"> Minutes <input type="number"
					value="0" min="0" />
				</label> <label class="seconds"> Seconds <input type="number"
					value="0" min="0" />
				</label>

				<div class="button-holder">
					<a id="alarm-set" class="button blue">Set</a> <a id="alarm-clear"
						class="button red">Clear</a>
				</div>

				<a class="close"></a>

			</div>

		</div>

		<div class="overlay">

			<div id="time-is-up">

				<h2>Time's up!</h2>

				<div class="button-holder">
					<a class="button blue">Close</a>
				</div>

			</div>

		</div>

		<audio id="alarm-ring" preload>
			<source src="resources/assets/audio/ticktac.mp3" type="audio/mpeg" />
			<source src="resources/assets/audio/ticktac.ogg" type="audio/ogg" />
		</audio>
		
		</form>
	</details>

	<div id="header">
		<div>
			<h3>Call Servlets with EJBs via Jquery</h3>
			<h3>Muliple Calls Timers in JavaScript</h3>
			<h3>Call CRUD EJB - JSF on Openshif</h3>
		</div>
	</div>
	<div id="nav" class=jumbotron>
		<div class="container">
			<div id="setTimerIntervalMessage"
				style="height: 1.5em; font-size: 2em; color: blue;"></div>

			<input id="wooYayButton" type="button" onclick="wooYayClickHandler()"
				value="Clicar Aqui Benzinho" class="btn btn-info btn-block"></input>

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

			<div>
				<h3>Test JavaScript</h3>
				<input class="btn btn-primary btn-block" type="button"
					id="callAddProduct" value="Add Product" /> <input
					class="form-control" type="text" id="fieldProduct" /> <input
					class="btn btn-primary btn-block" type="button"
					id="callCheckOutProduct" value="Close Cart" />
				<h3>Test of Shoppipng Cart Servlet</h3>
				<h3>
					<a class="callShoppProductEmpty" href="ShoppingCartServlet?product">Shopping
						Product Empty</a>
				</h3>
			</div>
			<div>
				<h3>Test of CDI</h3>
				<h3>
					<a class="callCDI" href="PerformanceGateCDI">Performance CDI</a>
				</h3>
				<div id="responsePerformanceCDI"></div>
			</div>
			<div>
				<h3>Test of @Local @Stateless EJB</h3>
				<h3>
					<a class="callLocalStatelessEJB"
						href="PerformanceLocalStatelessEJB">Performance Local
						Stateless EJB</a>
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
					<a class="callRemoteStatefulEJB"
						href="PerformanceRemoteStatefulEJB">Performance Remote
						Stateful EJB</a>
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
			<input class="form-control" type="text" id="userTest" /> <input
				class="btn btn-primary btn-block" type="button" id="submitAjax"
				value="Ajax Submit" />
			<div id="welcometext"></div>

			<h3>Test JSF Prime EJB 3 Persistence</h3>
			<input class="btn btn-primary btn-block" type="button"
				id="submitPrimeJSFEJB3" value="PRIME JSF ManagedBean" /> <br />

		<h3>Test CRUD EJB</h3>
			<input class="btn btn-primary btn-block" type="button"
				id="submitCRUDEJB" value="CRUD EJB" /> <br />

			<h3>Test Spring MVC</h3>
			<input class="btn btn-primary btn-block" type="button"
				id="submitSpringMVC" value="Spring MVC" /> <br />

		</div>
	</div>

	<div id="section">
		<textarea class="textarea" id="responseShopCartBase" rows="1"
			cols="40">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum porttitor neque eget consequat. Sed faucibus purus vitae felis facilisis bibendum.</textarea>

		<br /> <br />
		<button id="Add">Add one</button>
		<button id="Add2">Add another</button>
		<div id="pane"></div>
		<h2>London</h2>
		<p>London is the capital city of England. It is the most populous
			city in the United Kingdom, with a metropolitan area of over 13
			million inhabitants.</p>
		<p>Standing on the River Thames, London has been a major
			settlement for two millennia, its history going back to its founding
			by the Romans, who named it Londinium.</p>
	</div>

	<div id="footer">Copyright © Sysmartek.com (Sysmartek-Inc)</div>

</body>

</html>
