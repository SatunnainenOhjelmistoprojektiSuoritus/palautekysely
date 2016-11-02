package fi.sos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.sos.bean.Kysely;
import fi.sos.dao.KyselyDAO;


@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;

	@RequestMapping("kyselyt.json")
	public @ResponseBody List<Kysely> haeKaikkiKyselytJSON() {
		List<Kysely> kyselyt = dao.haeKaikki();
		return kyselyt;
	}

}
