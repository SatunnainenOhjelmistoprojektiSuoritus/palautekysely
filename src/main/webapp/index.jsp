<html>
<body>
<table  border = "1">
	<thead>
		<tr>
			<th>Http Method </th>
			<th>Resource Endpoint </th>
			<th>Input </th>
			<th>Success Response </th>
			<th>Error Response </th>
			<th>Description </th>
		</tr>
	<tbody>	
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/">/kyselyt</a></td>
			<td>Empty </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Show all deployed / undeployed questionnaires </td>
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/deployed">/kyselyt/deployed</a></td>
			<td>Empty </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Show all deployed questionnaires </td>
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/undeployed">/kyselyt/undeployed</a></td>
			<td>Empty </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Show all undeployed questionnaires </td>
		</tr>		
		<tr>
			<td>GET </td>
			<td><a href="kyselyt/1">/kyselyt/{id} </a></td>
			<td>Questionnaires ID </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND</td>
			<td>Show data from specific questionnaire </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/deploy">/kyselyt/{id}/deploy</a>  </td>
			<td>Questionnaires ID </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			<td>Deploy questionnaire </td>
		</tr>
		<tr>
			<td>DELETE </td>
			<td><a href="kyselyt/1/undeploy">/kyselyt/{id}/undeploy</a>  </td>
			<td>Questionnaires ID </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 404, NOT FOUND </td>
			<td>Undeploy questionnaire </td>
		</tr>
		<tr>
			<td>GET </td>
			<td><a href="vastaukset/">/vastaukset/</a>   </td>
			<td>Empty </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Fetch all responses to all questionnaires </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/lisaaVastaus/">/kyselyt/{id}/lisaaVastaus/</a> </td>
			<td>
<pre>POST /kysely/kyselyt/1/lisaaVastaus HTTP/1.1
Host: proto433.haaga-helia.fi:8080
Content-Type: application/json
Cache-Control: no-cache

{
"vastaus" : "esimerkkivastaus"
}
</pre> </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Answer to questionnaires question with specific ID. </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="login">/login/</a> </td>
			<td>
<pre>POST /kysely/login HTTP/1.1
Host: proto433.haaga-helia.fi:8080
Content-Type: application/json
Cache-Control: no-cache

{
"login" : "test",
"password" : "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff"
}
{
"login" : "siteadmin",
"password" : "RepypQ1dd4KBho4Uj/IqioNVh6QU5N4fq55o1mCOl/fiwKcRxTWoQrdB8Kao8P2mk9j/6vXNrvOZ5eDO2frQNw=="
}

</pre> 
			</td>
			<td>HTTP 200 OK </td>
			<td>401 UNAUTHORIZED </td>
			<td>Returns true/false on user login. Uses SHA512 encryption </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/1/lisaaKysymys">/kyselyt/{id}/lisaaKysymys</a> </td>
			<td>
<pre>POST /kysely//kyselyt/1/lisaaKysymys HTTP/1.1
Host: proto433.haaga-helia.fi
Content-Type: application/json
Cache-Control: no-cache

{
"kysymys" : "juutalaisia, onko heitä?",
"kysymys_tyyppi" : "string"
}</pre> </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Insert new question to questionnaire </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="kyselyt/lisaaKysely">/kyselyt/lisaaKysely</a> </td>
			<td><pre>POST /kysely/kyselyt/lisaaKysely HTTP/1.1
Host: proto433.haaga-helia.fi:8080/
Content-Type: application/json
Cache-Control: no-cache

{
"kysely_nimi" : "testi",
"kuvaus" : "testikuvaus",
"omistaja_id" : 1
}</pre> </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Adds a new questionnaire </td>
		</tr>
	</tbody>
</table>
</body>
</html>
