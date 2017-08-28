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

import formation.dao.ImmeubleDao;
import formation.model.Immeuble;

@Path("/api/immeubles")
@Produces({ "application/json", "application/xml" })
public class ImmeubleRest {
	@EJB
	private ImmeubleDao immeubleDao;

	@Path("/")
	@GET
	public List<Immeuble> getImmeubles() {
		return immeubleDao.findAll();
	}

	@Path("/{immeubleId}")
	@GET
	public Immeuble getImmeuble(@PathParam("immeubleId") Long id) {
		return immeubleDao.find(id);
	}

	@Path("/")
	@POST
	public void createImmeuble(Immeuble immeuble) {
		immeubleDao.create(immeuble);
	}

	@Path("/{immeubleId}")
	@PUT
	public void updateImmeuble(Immeuble immeuble, @PathParam("immeubleId") Long id) {
		immeubleDao.update(immeuble);
	}

	@Path("/{immeubleId}")
	@DELETE
	public void deleteImmeuble(@PathParam("immeubleId") Long id) {
		immeubleDao.delete(immeubleDao.find(id));
	}
}
*/