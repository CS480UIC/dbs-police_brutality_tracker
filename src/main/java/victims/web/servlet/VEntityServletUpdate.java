package victims.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import victims.dao.VEntityDao;
import victims.domain.VEntity;

/**
 * Servlet implementation class UserServlet
 */

public class VEntityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VEntityServletUpdate() {
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
		VEntityDao entity1dao = new VEntityDao();
		VEntity entity1 = null;

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

			if(entity1.getVictimID()!=null){
				request.setAttribute("victims", entity1);
				request.getRequestDispatcher("/jsps/victims/victims_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/victims/victims_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			VEntity form = new VEntity();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setVictimID(info.get(3));
			form.setVictimName(info.get(2));
			form.setVictimEthnicity(info.get(4));
			form.setVictimAddress(info.get(6));
			form.setVictimGender(info.get(5));

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
			request.setAttribute("victims", form);
			request.getRequestDispatcher("/jsps/victims/victims_read_output.jsp").forward(request, response);
		}
	}
}



