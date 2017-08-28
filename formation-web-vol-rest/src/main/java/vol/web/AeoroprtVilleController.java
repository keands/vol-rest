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


import vol.metier.model.*;
import vol.metier.dao.*;

@RestController
@RequestMapping("/aeroportVilles")
public class AeoroprtVilleController {
	@Autowired
	private AeroportVilleDao aeroportVilleDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<AeroportVille>> getAll() {
		return new ResponseEntity<List<AeroportVille>>(this.aeroportVilleDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AeroportVille> get(@PathVariable Long id) {
		AeroportVille aeroportVille = this.aeroportVilleDao.find(id);
		if (aeroportVille != null) {
			return new ResponseEntity<AeroportVille>(aeroportVille, HttpStatus.OK);
		} else {
			return new ResponseEntity<AeroportVille>(aeroportVille, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AeroportVille> add(@RequestBody AeroportVille aeroportVille) {
		this.aeroportVilleDao.create(aeroportVille);
		return new ResponseEntity<AeroportVille>(aeroportVille, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<AeroportVille> save(@PathVariable Long id, @RequestBody AeroportVille aeroportVille) {
		aeroportVille.setId(id);
		this.aeroportVilleDao.update(aeroportVille);
		return new ResponseEntity<AeroportVille>(aeroportVille, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.aeroportVilleDao.delete(this.aeroportVilleDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
