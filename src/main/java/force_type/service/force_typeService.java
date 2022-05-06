package force_type.service;


import force_type.dao.force_typeDao;
import force_type.domain.force_type;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class force_typeService {
	private force_typeDao entity1Dao = new force_typeDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(force_type form) throws force_typeException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		force_type entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new force_typeException("This user name has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(force_type form) throws force_typeException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		force_type user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new force_typeException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new force_typeException(" The password is not right");
		
	}
}
