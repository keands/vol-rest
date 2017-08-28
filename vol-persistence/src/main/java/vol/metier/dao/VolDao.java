package vol.metier.dao;

import java.util.List;

import vol.metier.model.Aeroport;
import vol.metier.model.Vol;

public interface VolDao extends Dao<Vol, Long> {
	List<Vol> findAllByAeroport(Aeroport aeroport);

}
