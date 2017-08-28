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

import vol.metier.dao.VilleDao;
import vol.metier.model.Ville;

@RestController
@RequestMapping("/villes")
public class VilleController {
	
	@Autowired
	private VilleDao villeDao;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Ville>> getAll() {
		return new ResponseEntity<List<Ville>>(this.villeDao.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Ville> get(@PathVariable Long id) {
		Ville ville = this.villeDao.find(id);
		if (ville != null) {
			return new ResponseEntity<Ville>(ville, HttpStatus.OK);
		} else {
			return new ResponseEntity<Ville>(ville, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Ville> add(@RequestBody Ville ville) {
		this.villeDao.create(ville);
		return new ResponseEntity<Ville>(ville, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Ville> save(@PathVariable Long id, @RequestBody Ville ville) {
		ville.setId(id);
		this.villeDao.update(ville);
		return new ResponseEntity<Ville>(ville, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.villeDao.delete(this.villeDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	

}
