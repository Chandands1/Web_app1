package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveReg")
public class SaveRegistratiion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveRegistratiion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Get");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection
				 ("jdbc:mysql://localhost:3306/db1", "root", "*");
			 
			    Statement statement = connection.createStatement();
			    
			    statement.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
