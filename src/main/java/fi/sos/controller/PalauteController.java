package fi.sos.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.sos.bean.Kysely;
import fi.sos.bean.Kyselyt;
import fi.sos.bean.Kysymys;
import fi.sos.bean.Omistaja;
import fi.sos.bean.Vastaukset;
import fi.sos.bean.Vastaus;
import fi.sos.dao.KyselyDAO;
import fi.sos.dao.KyselytDAO;
import fi.sos.dao.KysymysDAO;
import fi.sos.dao.LoginDAO;
import fi.sos.dao.VastauksetDAO;
import fi.sos.dao.VastausDAO;
import fi.sos.security.Salaaja;
import fi.sos.validation.Validaattori;

@Controller
public class PalauteController {
	
	private final String ERROR_NULL = "Validation failed, Input can't be null";
	private final String ERROR_WRONG_TYPE = "Validation failed, type not accepted";
	
	@Inject
	KyselyDAO kdao;

	@Inject
	VastausDAO vdao;

	@Inject
	VastauksetDAO vastauksetdao;

	@Inject
	KysymysDAO kydao;

	@Inject
	KyselytDAO kyselytdao;
	
	@Inject
	LoginDAO logindao;
	
	/*
	 * ===========================================================
	 * Kyselyt
	 * Hae yksi kysely
	 * Hae Kaikki kyselyt
	 * Hae kaikki deployed kyselyt
	 * Hae kaikki undeployed kyselyt
	 * Laita kysymys pakolliseksi
	 * Laita kysymys vapaaehtoiseksi
	 * ===========================================================
	 */
	
	
	@RequestMapping(value = "/kyselyt/old/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKyselyJSON(@PathVariable int id) {

		List<Kysely> kyselyt = kdao.haeKysely(id);
		// Jos kyselyä ei löydy, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/kyselyt/{surveyID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKyselyJSON(@PathVariable String surveyID) {

		List<Kysely> kyselyt = kdao.haeKyselySurveyID(surveyID);
		// Jos kyselyä ei löydy, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/kyselyt", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiKyselytJSON() {

		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiKyselyt();

		// Jos ei yhtään kyselyä löydy, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt/deployed", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkideployedJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiDeployedKyselyt();

		// Jos ei löydy yhtään deployattyä kyselyä, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt/undeployed", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiUndeployedKyselytJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiUnDeployedKyselyt();

		// Jos ei löydy yhtään undeployattyä kyselyä, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt/{id}/deploy", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyDeploy(@PathVariable int id) {

		kyselytdao.deployKysely(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@RequestMapping(value = "/kyselyt/{id}/undeploy", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> kyselyUndeploy(@PathVariable int id) {

		kyselytdao.UndeployKysely(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/kyselyt/kysymys/{id}/pakollinen", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kysymysPakollinen(@PathVariable int id) {

		kydao.pakollinen(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}	
	
	@RequestMapping(value = "/kyselyt/kysymys/{id}/vapaaehtoinen", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> kysymysVapaaehtoinen(@PathVariable int id) {

		kydao.vapaaehtoinen(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	/*
	 * 	===========================================================
	 * 	Vastaus
	 *  Hae vastaus id:llä
	 *  Hae kaikki vastaukset
	 * 	===========================================================
	*/
	
	@RequestMapping(value = "/kyselyt/vastaukset/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeVastaukset(@PathVariable int id) {
		List<Vastaukset> vastaukset = vdao.haeVastaukset(id);

		// Jos ei löydy yhtään vastausta, palauta 404
		if (vastaukset.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(vastaukset, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt/vastaukset/", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiVastaukset() {
		List<Vastaukset> vastaukset = vastauksetdao.haeKaikkiVastaukset();

		// Jos ei löydy yhtään vastausta kyselyyn, palauta 404
		if (vastaukset.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(vastaukset, HttpStatus.OK);
	}
		
	/*
	 * ===========================================================
	 * Lisäykset
	 * Kyselyyn vastauksen lisääminen
	 * Kyselyyn kysymyksen lisääminen
	 * Uuden kyselyn lisääminen
	 * ===========================================================	 
	 */

	@RequestMapping(value = "/kyselyt/kysymys/{id}/lisaaVastaus", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaVastaus(@PathVariable int id, @RequestBody Vastaus vastaus) {

		Validaattori v = new Validaattori();
		
		boolean checkForNull = v.checkForEmpty(vastaus.getVastaus());
		
		if (!checkForNull){
			return new ResponseEntity<String>(ERROR_NULL, HttpStatus.PRECONDITION_FAILED);
		}		
		
		vdao.lisaaVastaus(id, vastaus.getVastaus());
		return new ResponseEntity<Object>(HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/kyselyt/{id}/lisaaKysymys", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaKysymys(@PathVariable int id, @RequestBody Kysymys kysymys) {

		Validaattori v = new Validaattori();		
		
		boolean checkForNullQuestion = v.checkForEmpty(kysymys.getKysymys());
		boolean checkForNullType = v.checkForEmpty(kysymys.getKysymys_tyyppi());
		/*
		 Frontilla ei tarvetta
		 boolean checkForType = v.checkForAcceptedQuestionTypes(kysymys.getKysymys_tyyppi());
		 
		if (!checkForType){
			return new ResponseEntity<String>(ERROR_WRONG_TYPE, HttpStatus.PRECONDITION_FAILED);
		}	
		*/	
		
		if (!checkForNullQuestion){
			return new ResponseEntity<String>(ERROR_NULL, HttpStatus.PRECONDITION_FAILED);
		}
		
		if (!checkForNullType){
			return new ResponseEntity<String>(ERROR_NULL, HttpStatus.PRECONDITION_FAILED);
		}
		
		kydao.lisaaKysymys(id, kysymys.getKysymys(), kysymys.getKysymys_tyyppi(), kysymys.getKysymys_info());

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/kyselyt/lisaaKysely", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaKysely(@RequestBody Kysely kysely) {		
		
		Validaattori v = new Validaattori();
		
		boolean checkForNullDescription = v.checkForEmpty(kysely.getKuvaus());
		boolean checkForNullName = v.checkForEmpty(kysely.getKysely_nimi());
		boolean checkForID = v.checkForDataType("int", ""+kysely.getOmistaja_id());
		
		String random = UUID.randomUUID().toString();
		
		random = random.substring(0, 6);
		
		if (!checkForNullDescription){
			return new ResponseEntity<String>(ERROR_NULL, HttpStatus.PRECONDITION_FAILED);
		}
		
		if (!checkForNullName){
			return new ResponseEntity<String>(ERROR_NULL, HttpStatus.PRECONDITION_FAILED);
		}
				
		if (!checkForID){
			return new ResponseEntity<String>(ERROR_WRONG_TYPE, HttpStatus.PRECONDITION_FAILED);
		}
		
		kdao.lisaaKysely(kysely.getKysely_nimi(), kysely.getKuvaus(), kysely.getOmistaja_id(), random);

		return new ResponseEntity<String>(random, HttpStatus.OK);

	}

	/*
	 * ===========================================================
	 *  Login
	 * ===========================================================
	 */
	
	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> authAccess(@RequestBody Omistaja omistaja) {
		
		List<Omistaja> suola = logindao.getSalty(omistaja.getLogin());
		
		
		if (suola.size() != 0){
			System.out.println("SUOLA: " + suola.get(0).getSalt());
			Omistaja o = logindao.authAccess(omistaja.getLogin(), omistaja.getPassword(), suola.get(0).getSalt());	
		

			// Jos jotain palautuu, näytetään omistajan id + 'true'
			if (o != null){			
				System.out.println("CONTROLLER OMISTAJA: " + o);

				return new ResponseEntity<String>(o.getOmistaja_id() + " True", HttpStatus.OK);
			}
		}
		// Random negatiivinen numero
		Random random = new Random();
		int randomNumber = (random.nextInt(1000)-1001);
		
		//Defaulttina ei pääsyä, tulostuu false + random negatiivinen numero
		return new ResponseEntity<String>(randomNumber + " False", HttpStatus.UNAUTHORIZED);
	}
	
	/* ======================================================
	**Poistot**
	Kysymyksen poisto
	Kyselyn poisto
	=========================================================*/
	@RequestMapping(value = "/kyselyt/kysymys/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> kysymysDelete(@PathVariable int id) {

		kydao.deleteKysymys(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/kyselyt/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> kyselyDelete(@PathVariable int id) {

		kdao.deleteKysely(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	/*==============================================
	 * 
	 *
	 * Rekisteröinti
	 * 
	 *=============================================*/
	
	@RequestMapping(value = "/user/register", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> registerNewUser(@RequestBody Omistaja omistaja) {		

		
		try {
			omistaja.setSalt(Salaaja.generoiSuola());
			String password = omistaja.getPassword();
			omistaja.setPassword(Salaaja.salaa(password, omistaja.getSalt().toString() , Salaaja.SHA512, 10));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		List<Omistaja> users = logindao.fetchAllUsers();
		
		for (int i = 0; i < users.size(); i++) {
			
			if (users.get(i).getLogin().equals(omistaja.getLogin())){
				omistaja.setLogin("False");
				omistaja.setOmistaja_id(0);
				omistaja.setPassword("False");
				omistaja.setSalt("False");
				return new ResponseEntity<Object>(omistaja, HttpStatus.CONFLICT);
			}
			
		}

		logindao.addUser(omistaja);
		omistaja.setPassword(null);
		omistaja.setSalt(null);
		return new ResponseEntity<Object>(omistaja, HttpStatus.OK);
	}
	
}
