<html>
<body>
<table  border = "1">
	<thead>
		<tr>
			<th>Http Method </th>			
			<th>Resource Endpoint </th>
			<th>Description </th>
			<th>Example ajax call</th>
			<th>Input</th>
			<th>Success Response </th>
			<th>Error Response </th>
			
		</tr>
	<tbody>	
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/">/kyselyt</a></td>
			<td>Show all deployed / undeployed questionnaires </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "4f045233-f38d-4fc5-bfdf-ddb5a9977691"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>None</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/deployed">/kyselyt/deployed</a></td>
			<td>Show all deployed questionnaires </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/deployed",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "faf20ebc-300f-4b03-09d1-8606e7edf188"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>None</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/undeployed">/kyselyt/undeployed</a></td>
			<td>Show all undeployed questionnaires </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/undeployed",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "21e46220-160f-eea6-980d-d00ed8e5d156"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>None</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			
		</tr>		
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/1">/kyselyt/{id} </a></td>
			<td>Show data from specific questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/1",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "9a0745c2-8ae3-a380-222f-32a76e1e7961"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND</td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/deploy">/kyselyt/{id}/deploy</a>  </td>
			<td>Deploy questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/1/deploy",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "710b8b18-f9fe-e6b1-754f-4e86ee9bc81a"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			
		</tr>
		<tr>
			<td>DELETE </td>
			<td><a href="kyselyt/1/undeploy">/kyselyt/{id}/undeploy</a>  </td>
			<td>Undeploy questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/1/undeploy",
  "method": "DELETE",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "d7b8080a-1f4d-0612-6c46-9bc87e74e1f8"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/kysymys/1/pakollinen">/kyselyt/kysymys/{id}/pakollinen</a>  </td>
			<td>Set question to mandatory, default value is mandatory. Uses <b>QUESTION ID</b></td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/kysymys/1/pakollinen",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "8ffe1f9a-8419-9db8-5a0b-c9912f721e9b"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			
		</tr>
		<tr>
			<td>DELETE </td>
			<td><a href="kyselyt/kysymys/1/vapaaehtoinen">/kyselyt/kysymys/{id}/vapaaehtoinen</a>  </td>
			<td>Set question to non-mandatory, uses <b>QUESTION ID</b> </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/kysymys/1/vapaaehtoinen",
  "method": "DELETE",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "21a8944d-bc21-3fe4-6ec7-3e642e2bfa02"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/vastaukset/">/kyselyt/vastaukset/</a>   </td>
			<td>Fetch all responses to all questionnaires </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/vastaukset/",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "77253a47-c6e6-a56a-e4c0-9a11b26f47f9"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>None</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/vastaukset/1">/kyselyt/vastaukset/{id}</a>   </td>
			<td>Fetch all responses to specific questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/vastaukset/1",
  "method": "GET",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "7b6daf0d-a027-bee0-6b35-30612bfe9c72"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>Questionaires ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/kysymys/1/lisaaVastaus">/kyselyt/kysymys/{id}/lisaaVastaus/</a> </td>
			<td>Answer to questionnaires question with specific <b>QUESTION</b> ID. </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/kysymys/1/lisaaVastaus",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "af6b3901-a996-fe80-cb3f-248774db1319"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>{"vastaus" : "esimerkkivastaus"}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED </td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="login">/login/</a> </td>
			<td>Returns true/false on user login. Uses SHA512 encryption </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/login",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "406f0784-f609-151f-4336-ecdda711fb53"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> 
			</td>
			<td>{"login" : "max","password" : "max"}</td>
			<td>HTTP 200 OK </td>
			<td>401 UNAUTHORIZED </td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/lisaaKysymys">/kyselyt/{id}/lisaaKysymys</a> </td>
			<td>Insert new question to questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/1/lisaaKysymys",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "18734e22-c52e-9593-f366-e6bda1467b2c"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>{"kysymys" : "juutalaisia, onko heitä?","kysymys_tyyppi" : "string"}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED  </td>
			
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/lisaaKysely">/kyselyt/lisaaKysely</a> </td>
			<td>Adds a new questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/lisaaKysely",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "c4ac53bd-fb61-5a1c-357f-1eae1738e634"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>{"kysely_nimi" : "testi","kuvaus" : "testikuvaus","omistaja_id" : 1}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED  </td>
			
		</tr>
		<tr>
			<td>DELETE </td>
			<td><a href="/kyselyt/kysymys/1">/kyselyt/kysymys/{id}</a> </td>
			<td>Deletes question via question ID</td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/kysely/kyselyt/kysymys/9",
  "method": "DELETE",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "de168704-ce1c-0edc-901a-ecfc9ae58d8d"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>Question ID</td>
			<td>HTTP 200 OK </td>
			<td>None</td>
			
		</tr>
				<tr>
			<td>DELETE</td>
			<td><a href="/kyselyt/1">/kyselyt/{id}</a> </td>
			<td>Deletes questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/kysely/kyselyt/1",
  "method": "DELETE",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "413d1d11-a143-728a-96da-de0696752a38"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>Questionnaire ID</td>
			<td>HTTP 200 OK </td>
			<td>None</td>
			
		</tr>		
	</tbody>
</table>
</body>
</html>
