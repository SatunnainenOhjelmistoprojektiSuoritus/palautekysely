package fi.sos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.sos.bean.Kysely;
import fi.sos.bean.Vastaus;
import fi.sos.dao.KyselyDAO;
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
	
	@RequestMapping(value="/kyselyt/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselyJSON(@PathVariable int id) {
		List<Kysely> kyselyt = kdao.haeKysely(id);
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		return kyselyt;
	}
	
	@RequestMapping(value="/kyselyt", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKaikkiKyselytJSON() {
		List<Kysely> kyselyt = kdao.haeKaikkiKyselyt();
		
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		return kyselyt;
	}
	
	@RequestMapping(value="/vastaukset/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> haeKaikkiVastaukset(@PathVariable int id) {
		List<Vastaus> kyselyt = vdao.haeVastaus(id);
		//Todo: Lis‰‰ oikea virhekoodi jos tulee muulla methodilla kuin POST
		return kyselyt;
	}
	
	

}
