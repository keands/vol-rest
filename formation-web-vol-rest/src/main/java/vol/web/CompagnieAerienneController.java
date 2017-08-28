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

import vol.metier.dao.CompagnieAerienneDao;
import vol.metier.model.CompagnieAerienne;

@RestController
@RequestMapping("/compagnies-aeriennes")
public class CompagnieAerienneController {

	@Autowired
	private CompagnieAerienneDao compagnieAerienneDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CompagnieAerienne>> getAll() {
		return new ResponseEntity<List<CompagnieAerienne>>(this.compagnieAerienneDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CompagnieAerienne> get(@PathVariable Long id) {
		CompagnieAerienne compagnieAerienne = this.compagnieAerienneDao.find(id);
		if (compagnieAerienne != null) {
			return new ResponseEntity<CompagnieAerienne>(compagnieAerienne, HttpStatus.OK);
		} else {
			return new ResponseEntity<CompagnieAerienne>(compagnieAerienne, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CompagnieAerienne> add(@RequestBody CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienneDao.create(compagnieAerienne);
		return new ResponseEntity<CompagnieAerienne>(compagnieAerienne, HttpStatus.CREATED);
	}

	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 @ResponseBody
	 public ResponseEntity<CompagnieAerienne> save(@PathVariable Long id,
	 @RequestBody CompagnieAerienne compagnieAerienne) {
	 compagnieAerienne.setId(id);
	 this.compagnieAerienneDao.update(compagnieAerienne);
	 return new ResponseEntity<CompagnieAerienne>(compagnieAerienne, HttpStatus.OK);
	 }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.compagnieAerienneDao.delete(this.compagnieAerienneDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
