package infractions.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infractions.dao.IEntityDao;
import infractions.domain.IEntity;


/**
 * Servlet implementation class UserServlet
 */

public class IEntityServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IEntityServletRead() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IEntity IEntity = null;
		IEntityDao entity1Dao = new IEntityDao();
		System.out.println("asdf");
		
		try {
			IEntity = entity1Dao.findByID(request.getParameter("infractions_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(!IEntity.getInfractionID().equals(null)) {
					System.out.println(IEntity);
					request.setAttribute("infractions", IEntity);
					request.getRequestDispatcher("/jsps/infractions/infractions_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/infractions/infractions_read_output.jsp").forward(request, response);
		}
	}
}



