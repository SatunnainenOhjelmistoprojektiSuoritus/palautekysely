<html>
<body>
<table  border = "1">
	<thead>
		<tr>
			<th>Http Methdod </th>
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
			<td><a href="/vastaukset/">/vastaukset/</a>   </td>
			<td>Empty </td>
			<td>HTTP 200 OK </td>
			<td>HTTP 405, METHOD NOT SUPPORTED </td>
			<td>Fetch all responses to all questionnaires </td>
		</tr>
		<tr>
			<td>POST </td>
			<td><a href="/kyselyt/1/lisaaVastaus/">/kyselyt/{id}/lisaaVastaus/</a> </td>
			<td>
<pre>POST /kysely/kyselyt/1/lisaaVastaus HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: e1b081ed-52b1-9f51-cd27-28dc29b803fa

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
			<td><a href="/login">/login/</a> </td>
			<td>
<pre>POST /kysely/login HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 881e5df1-4a31-7c8a-4b09-bea3f1026c3f

{
"login" : "esimerkkilogin",
"password" : "esimerkkipassword"
}</pre> 
			</td>
			<td>HTTP 200 OK </td>
			<td>401 UNAUTHORIZED </td>
			<td>Returns true/false on user login </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
	</tbody>
</table>
</body>
</html>
