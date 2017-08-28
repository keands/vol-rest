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

import vol.metier.dao.PassagerDao;
import vol.metier.model.Passager;

@RestController
@RequestMapping("/passagers")
public class PassagerController {
	@Autowired
	private PassagerDao passagerDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Passager>> getAll() {
		return new ResponseEntity<List<Passager>>(this.passagerDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Passager> get(@PathVariable Long id) {
		Passager passager = this.passagerDao.find(id);
		if (passager != null) {
			return new ResponseEntity<Passager>(passager, HttpStatus.OK);
		} else {
			return new ResponseEntity<Passager>(passager, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Passager> add(@RequestBody Passager passager) {
		this.passagerDao.create(passager);
		return new ResponseEntity<Passager>(passager, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> save(@PathVariable Long id, @RequestBody Passager passager) {
		passager.setId(id);
		this.passagerDao.update(passager);
		return new ResponseEntity<Passager>(passager, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.passagerDao.delete(this.passagerDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
