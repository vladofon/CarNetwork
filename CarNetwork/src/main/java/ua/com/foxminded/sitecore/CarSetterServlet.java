package ua.com.foxminded.sitecore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.foxminded.db.*;

@WebServlet("/garageAddForm")
public class CarSetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarSetterServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car = request.getParameter("input");
		DatabaseFacade.insert(car);
		response.sendRedirect("http://localhost:8080/CarNetwork/index.jsp");
	}

}