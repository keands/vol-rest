/*
package formation.web;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import formation.dao.EleveDao;
import formation.model.Eleve;

@WebService(serviceName="EleveWS")
public class EleveWS {
	
	@EJB
	private EleveDao eleveDao;
	
	@WebMethod
	public List<Eleve> geteleves() {
		return eleveDao.findAll();
	}
	
	@WebMethod(operationName="findeleve")
	public Eleve getEleve(@WebParam(name="eleveId") Long id) {
		return eleveDao.find(id);
	}
	
	@WebMethod
	public void createEleve(@WebParam(name="eleve") Eleve eleve) {
		eleveDao.create(eleve);
	}
	
	@WebMethod
	public void updateEleve(@WebParam(name="eleve") Eleve eleve) {
		eleveDao.update(eleve);
	}
	
	@WebMethod
	public void deleteEleve(@WebParam(name="eleveId") Long id) {
		eleveDao.delete(eleveDao.find(id));
	}
}

*/
