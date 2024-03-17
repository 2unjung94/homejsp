package pkg02_request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class MyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");
	  
	  String strNumber = request.getParameter("number");
	  int number = Integer.parseInt(strNumber);
	  System.out.println(number);
	  
	  String strNumber2 = request.getParameter("number2");
	  double number2 = Double.parseDouble(strNumber2);
	  System.out.println(number2);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
