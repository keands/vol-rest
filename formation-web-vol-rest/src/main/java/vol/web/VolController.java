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

import vol.metier.dao.VolDao;
import vol.metier.model.Vol;

@RestController
@RequestMapping("/vols")
public class VolController {

	@Autowired
	private VolDao volDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Vol>> getAll() {
		return new ResponseEntity<List<Vol>>(this.volDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Vol> get(@PathVariable Long id) {
		Vol vol = this.volDao.find(id);
		if (vol != null) {
			return new ResponseEntity<Vol>(vol, HttpStatus.OK);
		} else {
			return new ResponseEntity<Vol>(vol, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Vol> add(@RequestBody Vol vol) {
		this.volDao.create(vol);
		return new ResponseEntity<Vol>(vol, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Vol> save(@PathVariable Long id, @RequestBody Vol vol) {
		vol.setId(id);
		this.volDao.update(vol);
		return new ResponseEntity<Vol>(vol, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.volDao.delete(this.volDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
