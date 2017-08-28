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

import vol.metier.dao.ReservationDao;
import vol.metier.model.Reservation;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Reservation>> getAll() {
		return new ResponseEntity<List<Reservation>>(this.reservationDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Reservation> get(@PathVariable Long id) {
		Reservation reservation = this.reservationDao.find(id);
		if (reservation != null) {
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		} else {
			return new ResponseEntity<Reservation>(reservation, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Reservation> add(@RequestBody Reservation reservation) {
		this.reservationDao.create(reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Reservation> save(@PathVariable Long id, @RequestBody Reservation reservation) {
		reservation.setId(id);
		this.reservationDao.update(reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		this.reservationDao.delete(this.reservationDao.find(id));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
