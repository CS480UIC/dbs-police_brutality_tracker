package victims.service;


import java.util.List;

import victims.dao.VEntityDao;
import victims.domain.VEntity;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class VEntityService {
	private VEntityDao entityDao = new VEntityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(VEntity form) throws VEntityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		VEntity entity1 = entityDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new VEntityException("This user name has been registered!");
		entityDao.add(form);
	}
	
	public List<Object> q2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q2();
		
	}
	
	public List<Object> q3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q3();
		
	}
}
