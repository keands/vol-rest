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

import vol.metier.dao.ClientDao;
import vol.metier.model.Client;
import vol.metier.model.ClientMoral;
import vol.metier.model.ClientPhysique;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientDao clientDao;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Client>> getAll() {
		return new ResponseEntity<List<Client>>(this.clientDao.findAll(), HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Client> get(@PathVariable Long id) {
		Client client = this.clientDao.find(id);
		if (client != null) {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>(client, HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value = "/physique", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Client> addPhysique(@RequestBody ClientPhysique client) {
		this.clientDao.create(client);
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/moral", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Client> addMoral(@RequestBody ClientMoral client) {
		this.clientDao.create(client);
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/Pphysique{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Client> save(@PathVariable Long id, @RequestBody ClientPhysique client) {
		client.setId(id);
		this.clientDao.update(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	@RequestMapping(value = "/Pmoral{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Client> save(@PathVariable Long id, @RequestBody ClientMoral client) {
		client.setId(id);
		this.clientDao.update(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.clientDao.delete(this.clientDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	
}