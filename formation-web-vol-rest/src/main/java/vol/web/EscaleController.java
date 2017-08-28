package vol.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import vol.metier.dao.AeroportDao;
import vol.metier.dao.EscaleDao;
import vol.metier.dao.VolDao;
import vol.metier.model.Aeroport;
import vol.metier.model.Escale;
import vol.metier.model.EscaleId;
import vol.metier.model.Vol;




@RestController
@RequestMapping("/escales")
public class EscaleController {
	
	@Autowired
	private EscaleDao escaleDao;
	@Autowired
	private VolDao volDao;
	@Autowired
	private AeroportDao aeroportDao;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Escale>> getAll() {
		return new ResponseEntity<List<Escale>>(this.escaleDao.findAll(), HttpStatus.OK);
	}
	
	/*long-long*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Escale> get(@PathVariable String  id) {
		String[] parts = id.split("-");
		String idVol = parts[0]; // 004
		String idAeroport = parts[1]; // 034556
		
		Vol vol=volDao.find(Long.valueOf(idVol));
		Aeroport aer=aeroportDao.find(Long.valueOf(idAeroport));
		EscaleId escId=new EscaleId();
		escId.setVol(vol);escId.setAeroport(aer);
		Escale escale = this.escaleDao.find(escId);
		if (escale != null) {
			return new ResponseEntity<Escale>(escale, HttpStatus.OK);
		} else {
			return new ResponseEntity<Escale>(escale, HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Escale> add(@RequestBody Escale escale) {
		this.escaleDao.create(escale);
		return new ResponseEntity<Escale>(escale, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Escale> save(@PathVariable String id, @RequestBody Escale escale) {
		String[] parts = id.split("-");
		String idVol = parts[0]; // 004
		String idAeroport = parts[1]; // 034556
		Vol vol=volDao.find(Long.valueOf(idVol));
		Aeroport aer=aeroportDao.find(Long.valueOf(idAeroport));
		
		escale.setAeroport(aer);
		escale.setVol(vol);
		
		this.escaleDao.update(escale);
		return new ResponseEntity<Escale>(escale, HttpStatus.OK);
	}
//
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable String id) {
		String[] parts = id.split("-");
		String idVol = parts[0]; // 004
		String idAeroport = parts[1]; // 034556
		Vol vol=volDao.find(Long.valueOf(idVol));
		Aeroport aer=aeroportDao.find(Long.valueOf(idAeroport));
		EscaleId escId=new EscaleId();
		escId.setVol(vol);escId.setAeroport(aer);
		
		this.escaleDao.delete(this.escaleDao.find(escId));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	
}