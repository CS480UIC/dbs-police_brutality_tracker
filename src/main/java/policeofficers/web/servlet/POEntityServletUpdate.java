package policeofficers.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import policeofficers.dao.POEntityDao;
import policeofficers.domain.POEntity;

/**
 * Servlet implementation class UserServlet
 */

public class POEntityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public POEntityServletUpdate() {
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
		POEntityDao entity1dao = new POEntityDao();
		POEntity entity1 = null;

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

			if(entity1.getOfficerID()!=null){
				request.setAttribute("police_officers", entity1);
				request.getRequestDispatcher("/jsps/police_officers/police_officers_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/police_officers/police_officers_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			POEntity form = new POEntity();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setOfficerID(info.get(3));
			form.setOfficerName(info.get(2));
			form.setOfficerDepartment(info.get(4));
			form.setOfficerRank(info.get(5));

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
			request.setAttribute("police_officers", form);
			request.getRequestDispatcher("/jsps/police_officers/police_officers_read_output.jsp").forward(request, response);
		}
	}
}



