package infractions.service;


import java.util.List;

import infractions.dao.IEntityDao;
import infractions.domain.IEntity;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class IEntityService {
	private IEntityDao entityDao = new IEntityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(IEntity form) throws IEntityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		IEntity entity1 = entityDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new IEntityException("This user name has been registered!");
		entityDao.add(form);
	}
	
	public List<Object> q4() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q4();
		
	}
	
	public List<Object> q5() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q5();
		
	}
	
	public List<Object> q6() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q6();
		
	}
	
	public List<Object> q8() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entityDao.q8();
		
	}

}
