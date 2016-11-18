package fi.sos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.sos.bean.Kysely;
import fi.sos.bean.Kyselyt;
import fi.sos.bean.Vastaukset;
import fi.sos.dao.KyselyDAO;
import fi.sos.dao.KyselytDAO;
import fi.sos.dao.KysymysDAO;
import fi.sos.dao.VastausDAO;

@Controller
public class PalauteController {
	@Inject
	KyselyDAO kdao;

	@Inject
	VastausDAO vdao;

	@Inject
	KysymysDAO kydao;

	@Inject
	KyselytDAO kyselytdao;

	@RequestMapping(value = "/kyselyt/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKyselyJSON(@PathVariable int id) {

		List<Kysely> kyselyt = kdao.haeKysely(id);
		// Jos kysely� ei l�ydy, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiKyselytJSON() {

		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiKyselyt();

		// Jos ei yht��n kysely� l�ydy, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/kyselyt/deployed", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkideployedJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiDeployedKyselyt();

		// Jos ei l�ydy yht��n deployatty� kysely�, palauta 404
		if (kyselyt.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(kyselyt, HttpStatus.OK);
	}

	@RequestMapping(value = "/kyselyt/undeployed", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> haeKaikkiUndeployedKyselytJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiUnDeployedKyselyt();

		//Jos ei l�ydy yht��n undeployatty� kysely�, palauta 404
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
	public @ResponseBody ResponseEntity<?> haeKaikkiVastaukset(@PathVariable int id) {
		List<Vastaukset> vastaukset = vdao.haeVastaukset(id);
		
		//Jos ei l�ydy yht��n vastausta kysely�, palauta 404
		if (vastaukset.size() == 0) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(vastaukset, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/kyselyt/{id}/lisaaVastaus/{vastaus}", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> kyselyLisaaVastaus(@PathVariable int id,@PathVariable String vastaus) {
System.out.println(vastaus);
	 vdao.lisaaVastaus(id, vastaus);
		return new ResponseEntity<Object>(HttpStatus.OK);

		
	}
	

}
