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

import infractions.dao.IEntityDao;
import infractions.domain.IEntity;

/**
 * Servlet implementation class UserServlet
 */

public class IEntityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IEntityServletUpdate() {
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

		String method = request.getParameter("method");
		IEntityDao entity1dao = new IEntityDao();
		IEntity entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByID(request.getParameter("username"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getInfractionID()!=null){
				request.setAttribute("infractions", entity1);
				request.getRequestDispatcher("/jsps/infractions/infractions_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/infractions/infractions_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			IEntity form = new IEntity();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			form.setInfractionID(info.get(2));
			form.setInfractionDate(info.get(3));
			form.setInfractionOfficer(info.get(4));
			form.setInfractionForce(info.get(5));
			form.setInfractionVictim(info.get(6));
			form.setInfractionReporter(info.get(7));
			form.setInfractionLocation(info.get(8));
			form.setInfractionDesc(info.get(9));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.setAttribute("infractions", form);
			request.getRequestDispatcher("/jsps/infractions/infractions_read_output.jsp").forward(request, response);
		}
	}
}



