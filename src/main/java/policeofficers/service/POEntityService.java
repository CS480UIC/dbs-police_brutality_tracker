package policeofficers.service;


import java.util.List;

import policeofficers.dao.POEntityDao;
import policeofficers.domain.POEntity;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class POEntityService {
	private POEntityDao entityDao = new POEntityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(POEntity form) throws POEntityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		POEntity entity1 = entityDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new POEntityException("This user name has been registered!");
		entityDao.add(form);
	}
	
	public List<Object> q1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q1();
		
	}
}
