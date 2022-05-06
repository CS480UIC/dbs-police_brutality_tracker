package infractions.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infractions.domain.IEntity;
import infractions.dao.IEntityDao;
import entity1.service.Entity1Exception;
import entity1.service.Entity1Service;


/**
 * Servlet implementation class UserServlet
 */

public class IEntityServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IEntityServletCreate() {
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
		Entity1Service entity1service = new Entity1Service();
		Map<String,String[]> paramMap = request.getParameterMap();
		IEntity form = new IEntity();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setInfractionID(info.get(0));
		form.setInfractionDate(info.get(1));
		form.setInfractionOfficer(info.get(2));
		form.setInfractionForce(info.get(3));
		form.setInfractionVictim(info.get(4));
		form.setInfractionReporter(info.get(5));
		form.setInfractionLocation(info.get(6));
		form.setInfractionDesc(info.get(7));
		//form.setInfractionCount(info.get(8));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Entity1Exception e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
