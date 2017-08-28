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

import vol.metier.dao.CompagnieAerienneVolDao;
import vol.metier.model.CompagnieAerienne;
import vol.metier.model.CompagnieAerienneVol;
import vol.metier.model.CompagnieAerienneVolId;
import vol.metier.model.Vol;

@RestController
@RequestMapping("/compagnie-aerienne-vols")
public class CompagnieAerienneVolController {

	@Autowired
	private CompagnieAerienneVolDao compagnieAerienneVolDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CompagnieAerienneVol>> getAll() {
		return new ResponseEntity<List<CompagnieAerienneVol>>(this.compagnieAerienneVolDao.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/numero/{numero}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CompagnieAerienneVol> getNumero(@PathVariable String numero) {
		CompagnieAerienneVol compagnieAerienneVol = this.compagnieAerienneVolDao
				.find(numero);
		if (compagnieAerienneVol != null) {
			return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.OK);
		} else {
			return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/numero/{numero}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> deleteNumero(@PathVariable String numero) {
		this.compagnieAerienneVolDao.delete(this.compagnieAerienneVolDao.find(numero));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "/{compagnievol}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CompagnieAerienneVol> get(@PathVariable String compagnievol) {
		String[] splitted = compagnievol.split("-");
		Vol vol = new Vol();
		vol.setId(Long.parseLong(splitted[1]));
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setId(Long.parseLong(splitted[0]));

		CompagnieAerienneVol compagnieAerienneVol = this.compagnieAerienneVolDao
				.find(new CompagnieAerienneVolId(compagnieAerienne, vol));
		if (compagnieAerienneVol != null) {
			return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.OK);
		} else {
			return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CompagnieAerienneVol> add(@RequestBody CompagnieAerienneVol compagnieAerienneVol) {
		this.compagnieAerienneVolDao.create(compagnieAerienneVol);
		return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{compagnievol}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<CompagnieAerienneVol> save(@PathVariable String compagnievol,
			@RequestBody CompagnieAerienneVol compagnieAerienneVol) {
		String[] splitted = compagnievol.split("-");
		Vol vol = new Vol();
		vol.setId(Long.parseLong(splitted[1]));
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setId(Long.parseLong(splitted[0]));
		
		compagnieAerienneVol.setId(new CompagnieAerienneVolId(compagnieAerienne, vol));
		this.compagnieAerienneVolDao.update(compagnieAerienneVol);
		return new ResponseEntity<CompagnieAerienneVol>(compagnieAerienneVol, HttpStatus.OK);
	}

	@RequestMapping(value = "/{compagnievol}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable String compagnievol ) {
		String[] splitted = compagnievol.split("-");
		Vol vol = new Vol();
		vol.setId(Long.parseLong(splitted[1]));
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienne.setId(Long.parseLong(splitted[0]));
		this.compagnieAerienneVolDao.delete(this.compagnieAerienneVolDao.find(new CompagnieAerienneVolId(compagnieAerienne, vol)));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
