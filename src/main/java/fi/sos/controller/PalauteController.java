package fi.sos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
public class PalauteController {
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

	@RequestMapping(value = "/kyselyt/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKyselyJSON(@PathVariable int id) {

		List<Kysely> kyselyt = kdao.haeKysely(id);
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

	@RequestMapping(value = "/vastaukset/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeVastaukset(@PathVariable int id) {
		List<Vastaukset> vastaukset = vdao.haeVastaukset(id);

		// Jos ei löydy yhtään vastausta kyselyä, palauta 404
		if (vastaukset.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(vastaukset, HttpStatus.OK);
	}

	@RequestMapping(value = "/vastaukset/", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiVastaukset() {
		List<Vastaukset> vastaukset = vastauksetdao.haeKaikkiVastaukset();

		// Jos ei löydy yhtään vastausta kyselyä, palauta 404
		if (vastaukset.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(vastaukset, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> authAccess(@RequestBody Omistaja omistaja) {		

		boolean authAccess = logindao.authAccess(omistaja.getLogin(), omistaja.getPassword());
		//System.err.println(authAccess);
		//System.err.println(login + " " + password);

		// Jos ei yhtään kyselyä löydy, palauta 404
		if (authAccess == false) {
			return new ResponseEntity<Object>(authAccess, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<Object>(authAccess, HttpStatus.OK);
	}
		


	@RequestMapping(value = "/kyselyt/{id}/lisaaVastaus", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaVastaus(@PathVariable int id, @RequestBody Vastaus vastaus) {

		vdao.lisaaVastaus(id, vastaus.getVastaus());

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/kyselyt/{id}/lisaaKysymys", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaKysymys(@PathVariable int id, @RequestBody Kysymys kysymys) {

		kydao.lisaaKysymys(id, kysymys.getKysymys(), kysymys.getKysymys_tyyppi());

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	

}
