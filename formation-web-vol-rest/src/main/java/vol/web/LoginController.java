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


import vol.metier.dao.LoginDao;

import vol.metier.model.Login;

@RestController
@RequestMapping("/logins")
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Login>> getAll() {
		return new ResponseEntity<List<Login>>(this.loginDao.findAll(), HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Login> get(@PathVariable Long id) {
		Login login = this.loginDao.find(id);
		if (login != null) {
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		} else {
			return new ResponseEntity<Login>(login, HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Login> add(@RequestBody Login login) {
		this.loginDao.create(login);
		return new ResponseEntity<Login>(login, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Login> save(@PathVariable Long id, @RequestBody Login login) {
		login.setId(id);
		this.loginDao.update(login);
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.loginDao.delete(this.loginDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	
}