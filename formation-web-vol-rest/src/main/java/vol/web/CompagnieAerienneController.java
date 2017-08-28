package vol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vol.metier.dao.CompagnieAerienneDao;
import vol.metier.model.CompagnieAerienne;

@RestController
@RequestMapping("/compagnies-aeriennes")
public class CompagnieAerienneController {
	
	@Autowired
	private CompagnieAerienneDao compagnieAerienneDao;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CompagnieAerienne>> getAll() {
		return new ResponseEntity<List<CompagnieAerienne>>(this.compagnieAerienneDao.findAll(), HttpStatus.OK);
	}
/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Immeuble> get(@PathVariable Long id) {
		Immeuble immeuble = this.immeubleDao.find(id);
		if (immeuble != null) {
			return new ResponseEntity<Immeuble>(immeuble, HttpStatus.OK);
		} else {
			return new ResponseEntity<Immeuble>(immeuble, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Immeuble> add(@RequestBody Immeuble immeuble) {
		this.immeubleDao.create(immeuble);
		return new ResponseEntity<Immeuble>(immeuble, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Immeuble> save(@PathVariable Long id, @RequestBody Immeuble immeuble) {
		immeuble.setId(id);
		this.immeubleDao.update(immeuble);
		return new ResponseEntity<Immeuble>(immeuble, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.immeubleDao.delete(this.immeubleDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}*/
}
