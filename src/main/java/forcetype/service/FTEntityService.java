package forcetype.service;


import forcetype.dao.FTEntityDao;
import forcetype.domain.FTEntity;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class FTEntityService {
	private FTEntityDao entityDao = new FTEntityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(FTEntity form) throws FTEntityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		FTEntity entity1 = entityDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new FTEntityException("This user name has been registered!");
		entityDao.add(form);
	}
}
