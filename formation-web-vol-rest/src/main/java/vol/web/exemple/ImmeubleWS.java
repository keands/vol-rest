/*package formation.web;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import formation.dao.ImmeubleDao;
import formation.model.Immeuble;

@WebService(serviceName="ImmeubleWS")
public class ImmeubleWS {
	
	@EJB
	private ImmeubleDao immeubleDao;
	
	@WebMethod
	public List<Immeuble> getImmeubles() {
		return immeubleDao.findAll();
	}
	
	@WebMethod(operationName="findImmeuble")
	public Immeuble getImmeuble(@WebParam(name="immeubleId") Long id) {
		return immeubleDao.find(id);
	}
	
	@WebMethod
	public void createImmeuble(@WebParam(name="immeuble") Immeuble immeuble) {
		immeubleDao.create(immeuble);
	}
	
	@WebMethod
	public void updateImmeuble(@WebParam(name="immeuble") Immeuble immeuble) {
		immeubleDao.update(immeuble);
	}
	
	@WebMethod
	public void deleteImmeuble(@WebParam(name="immeubleId") Long id) {
		immeubleDao.delete(immeubleDao.find(id));
	}
}
*/
