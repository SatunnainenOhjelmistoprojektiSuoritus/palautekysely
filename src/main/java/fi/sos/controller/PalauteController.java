package fi.sos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fi.sos.bean.Kysely;
import fi.sos.bean.Kyselyt;
import fi.sos.bean.Vastaus;
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
	
	@RequestMapping(value="/kyselyt/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselyJSON(@PathVariable int id) {
		List<Kysely> kyselyt = kdao.haeKysely(id);
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin GET
		return kyselyt;
	}
	
	@RequestMapping(value="/kyselyt", method=RequestMethod.GET)
	public @ResponseBody List<Kyselyt> haeKaikkiKyselytJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiKyselyt();
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin GET
		return kyselyt;
	}
	
	@RequestMapping(value="/kyselyt/deployed", method=RequestMethod.GET)
	public @ResponseBody List<Kyselyt> haeKaikkideployedJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiDeployedKyselyt();
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin GET
		return kyselyt;
	}
	
	@RequestMapping(value="/kyselyt/undeployed", method=RequestMethod.GET)
	public @ResponseBody List<Kyselyt> haeKaikkiUndeployedKyselytJSON() {
		List<Kyselyt> kyselyt = kyselytdao.haeKaikkiUnDeployedKyselyt();
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		return kyselyt;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/kyselyt/{id}/deploy", method=RequestMethod.POST)
	public void kyselydeploy(@PathVariable int id) {

		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		kyselytdao.deployKysely(id);
		
	}	
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/kyselyt/{id}/undeploy", method=RequestMethod.DELETE)
	public void kyselyUndeploy(@PathVariable int id) {

		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin DELETE
		kyselytdao.UndeployKysely(id); 
		
	}	
	
	
	
	
	@RequestMapping(value="/vastaukset/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> haeKaikkiVastaukset(@PathVariable int id) {
		List<Vastaus> vastaukset = vdao.haeVastaus(id);
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		return vastaukset;
	}
	
	

}
