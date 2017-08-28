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
import vol.metier.model.Aeroport;

@RestController
@RequestMapping("/aeroports")
public class AeroportController {

	@Autowired
	private AeroportDao aeroportDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Aeroport>> getAll() {
		return new ResponseEntity<List<Aeroport>>(this.aeroportDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Aeroport> get(@PathVariable Long id) {
		Aeroport aeroport = this.aeroportDao.find(id);
		if (aeroport != null) {
			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
		} else {
			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Aeroport> add(@RequestBody Aeroport aeroport) {
		this.aeroportDao.create(aeroport);
		return new ResponseEntity<Aeroport>(aeroport, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Aeroport> save(@PathVariable Long id, @RequestBody Aeroport aeroport) {
		aeroport.setId(id);
		this.aeroportDao.update(aeroport);
		return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.aeroportDao.delete(this.aeroportDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
