<html>
<body>
<div>
<table border = "1">
	<thead>
		<tr>
			<th>Http Method </th>			
			<th>Resource Endpoint </th>
			<th>Description </th>
			<th>Example ajax call</th>
			<th>Input</th>
			<th>Success Response </th>
			<th>Error Response </th>
			<th>Example success response</th>
			
		</tr>
	</thead>
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
			<td><pre>[
  {
    "kysely_id": 1,
    "kysely_nimi": "Kysely1",
    "deployed": false,
    "kysely_kuvaus": "Esimerkkikuvaus",
    "omistaja_id": 1,
    "surveyID": "nkkxkf"
  }]</pre>
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
			<td><pre>[
  {
    "kysely_id": 2,
    "kysely_nimi": "Tyytyv‰isyyskysely",
    "deployed": true,
    "kysely_kuvaus": "Esimerkkikuvaus",
    "omistaja_id": 1,
    "surveyID": "teqspw"
  }]</pre>
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
			<td><pre>[
  {
    "kysely_id": 1,
    "kysely_nimi": "Kysely1",
    "deployed": false,
    "kysely_kuvaus": "Esimerkkikuvaus",
    "omistaja_id": 1,
    "surveyID": "nkkxkf"
  }]</pre></td>
		</tr>		
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/old/1"><font style="text-decoration: line-through;">/kyselyt/old/{id}</font></a><br><b>DEPRECATED</b></td>
			<td>Show all questions + questionaire related data from specific questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/old/1",
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
			<td><pre>[
  {
    "kysely_id": 1,
    "kysely_nimi": "Kysely1",
    "deployed": false,
    "kuvaus": null,
    "omistaja_id": 1,
    "kysymys": {
      "kysymys_id": 5,
      "kysely_id": 1,
      "kysymys": "test",
      "kysymys_tyyppi": "string",
      "pakollinen": true,
      "kysymys_info": null
    },
    "surveyID": "nkkxkf"
  }]</pre></td>
		</tr>
				<tr>
			<td>GET </td>
			<td><a href="kyselyt/nkkxkf">/kyselyt/{surveyID} </a></td>
			<td>Show all questions + questionaire related data from specific questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/nkkxkf",
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
			<td>Survey ID</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND</td>
			<td><pre>[
  {
    "kysely_id": 1,
    "kysely_nimi": "Kysely1",
    "deployed": false,
    "kuvaus": null,
    "omistaja_id": 1,
    "kysymys": {
      "kysymys_id": 5,
      "kysely_id": 1,
      "kysymys": "test",
      "kysymys_tyyppi": "string",
      "pakollinen": true,
      "kysymys_info": null
    },
    "surveyID": "nkkxkf"
  }]</pre></td>
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
			<td>Only returns HTTP response</td>
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
			<td>Only returns HTTP response</td>
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
			<td>Only returns HTTP response</td>
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
			<td>Only returns HTTP response</td>
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
			<td><pre>[
  {
    "kysymys_id": 1,
    "vastaus_id": 1,
    "vastaus": "Jaa",
    "kysely_id": 1,
    "kysymys": "Testikysymys",
    "kysymys_tyyppi": "String"
  }]</pre></td>
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
			<td><pre>[  {
    "kysymys_id": 1,
    "vastaus_id": 24,
    "vastaus": "on niit‰",
    "kysely_id": 1,
    "kysymys": "Testikysymys",
    "kysymys_tyyppi": "String"
  }
]</pre></td>
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
    "postman-token": "cae122cc-6a00-24f7-0d07-be7633db2c59"
  },
  "processData": false,
  "data": "{\"vastaus\" : \"esimerkkivastaus\"}\n"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>{"vastaus" : "esimerkkivastaus"}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED </td>
			<td>Only returns HTTP response</td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="login">/login/</a> </td>
			<td>Returns user id + true/negative number + false on user login. Uses SHA512 encryption </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/login",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "eedf1997-2791-83d2-625c-bc85943d5aed"
  },
  "processData": false,
  "data": "{\n\"login\" : \"kissa\",\n\"password\" : \"rotta\"\n}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> 
			</td>
			<td>{"login" : "max","password" : "max"}</td>
			<td>HTTP 200 OK </td>
			<td>401 UNAUTHORIZED </td>
			<td><pre>5 True</pre></td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/lisaaKysymys">/kyselyt/{id}/lisaaKysymys</a> </td>
			<td>Insert new question to questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/26/lisaaKysymys",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "03fa3313-b992-9dd5-0713-2e63c32d20c3"
  },
  "processData": false,
  "data": "{\n\"kysymys\" : \"Monta kaljaa?\",\n\"kysymys_tyyppi\" : \"int\"\n}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre></td>
			<td>{"kysymys" : "juutalaisia, onko heit‰?","kysymys_tyyppi" : "string", "kysymys_info" : "vaihtoehto1/vaihtoehto2/vaihtoehto3"}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED  </td>
			<td>Only returns HTTP response</td>
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
    "postman-token": "6e24349d-092d-15b0-3849-970c54b5d5e1"
  },
  "processData": false,
  "data": "{\n\"kysely_nimi\" : \"Kaljagallup2\",\n\"kuvaus\" : \"Mit‰ t‰n‰‰n juotaisiin\",\n\"omistaja_id\" : \"1\"\n}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>{"kysely_nimi" : "testi","kuvaus" : "testikuvaus","omistaja_id" : 1}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED<br>HTTP 412, PRECONDITION FAILED  </td>
			<td>Only returns HTTP response</td>
		</tr>
		<tr>
			<td>DELETE </td>
			<td><a href="/kyselyt/kysymys/1">/kyselyt/kysymys/{id}</a> </td>
			<td>Deletes question via question ID</td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/SOS_kysely/kyselyt/kysymys/9",
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
			<td>Only returns HTTP response</td>
		</tr>
				<tr>
			<td>DELETE</td>
			<td><a href="/kyselyt/1">/kyselyt/{id}</a> </td>
			<td>Deletes questionnaire </td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/kyselyt/1",
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
			<td>Only returns HTTP response</td>
		</tr>
						<tr>
			<td>POST</td>
			<td><a href="user/register">/user/register</a> </td>
			<td>Registers user</td>
			<td><pre>var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://proto433:8080/SOS_kysely/user/register",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "1bfc2da5-53ec-a664-5170-aafc6544e443"
  },
  "processData": false,
  "data": "{\n\"login\" : \"joonas\",\n\"password\" : \"nakkisota\"\n}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});</pre> </td>
			<td>{"login" : "joonas","password" : "nakkisota"}</td>
			<td>HTTP 200 OK </td>
			<td>HTTP 409 CONFLICT</td>
			<td>{"omistaja_id":0,"login":"joonas","password":null,"salt":null}</td>
		</tr>		
	</tbody>
</table>
</div>

</body>
</html>