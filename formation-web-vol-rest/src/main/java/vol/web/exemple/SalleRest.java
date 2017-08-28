/*package formation.web;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import formation.dao.SalleDao;
import formation.model.Salle;
import formation.model.SalleId;

@Path("/api/salles")
@Produces({ "application/json", "application/xml" })
public class SalleRest {
	
	@EJB
	private SalleDao salleDao;
	
	
	@Path("/")
	@GET
	public List<Salle> getSalles() {
		return salleDao.findAll();
	}
	
	@Path("/{nom-etage}")
	@GET
	public Salle getSalle(@PathParam("nom-etage") String nom) {
		String[] splitted = nom.split("-");
		return salleDao.find(new SalleId(splitted[0], Integer.parseInt(splitted[1]) ));
	}

	@Path("/{nom-etage-capacite}")
	@POST
	public void createSalle(@PathParam("nom-etage-capacite") String tosplit) {
		String[] splitted = tosplit.split("-");
		Salle salle = new Salle();
		salle.setCapacite(Integer.parseInt(splitted[2]));
		salle.setId(new SalleId( splitted[0], Integer.parseInt(splitted[1])));
		
		salleDao.create(salle);
	}
	
	@Path("/{nom-etage-capacite}")
	@PUT
	public void updateSalle(@PathParam("nom-etage-capacite") String tosplit ) {
		String[] splitted = tosplit.split("-");
		
		Salle salle = salleDao.find(new SalleId( splitted[0], Integer.parseInt(splitted[1])));
		
		salle.setCapacite(Integer.parseInt(splitted[2]));
		
		salleDao.update(salle);
		
		
	}
	
	@Path("/{nom}/{etage}")
	@DELETE
	public void deleteSalle(@PathParam("nom") String nom, @PathParam ("etage") int etage ) {
		Salle salle = salleDao.find(new SalleId(nom, etage));
		salleDao.delete(salle);
	}
	
}
*/