package pack1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

/**
 * Servlet implementation class Updatepw
 */
@WebServlet(description = "update user credentials to db", urlPatterns = { "/Updatepw" })
public class Updatepw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatepw() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
			String connectionURL = "jdbc:mysql://localhost:3306/agri";
			java.sql.Connection connection=null;
			ResultSet rs;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			// get the variable entered on the form
			
			String upass = request.getParameter("password");
			String uemail = request.getParameter("email");
			
			// email variables
			
			// Recipient's email ID needs to be mentioned.
		      String to = "didiertshi@gmail.com";
		   // Sender's email ID needs to be mentioned
		      String from = "info@ditelnetwork.com";
		   // Assuming you are sending email from localhost
		      String host = "smtpout.secureserver.net";
		   // Get system properties
		      Properties properties = System.getProperties();
		   // Setup mail server
		      properties.setProperty("mail.smtp.host", host);
		      properties.setProperty("mail.smtp.user", from);
		      properties.setProperty("mail.smtp.password", "admin");
		      properties.setProperty("mail.smtp.port", "80");
		      properties.setProperty("mail.smtp.auth", "true");
		      
		   // Get the default Session object.
		      Session session = Session.getDefaultInstance(properties,new Authenticator() {
		    	  protected PasswordAuthentication getPasswordAuthentication() {
	                  return new PasswordAuthentication(
	                          "info@ditelnetwork.com", "admin");// Specify the Username and the PassWord
	              }

	          
		      });
		      try {
					// Load the database driver
					Class.forName("com.mysql.jdbc.Driver");
					// Get a connection to the database
					connection = DriverManager.getConnection(connectionURL,"enfant1","!Muepu$2016!");
					// add data into the database
					
					to = uemail;
					String uname= request.getRemoteUser();
					
					
					
					// create the java mysql update preparedstatement
				      String query = "update account set password = ? , email= ? where user_name = ?";
				      PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
				      preparedStmt.setString (1, upass);
				      preparedStmt.setString(2, uemail);
				      preparedStmt.setString(3, uname);
				 
				      // execute the java preparedstatement
				      preparedStmt.executeUpdate();
				       
				      connection.close();
					
					// email part
					
					// Create a default MimeMessage object.
			          MimeMessage message = new MimeMessage(session);
			       // Set From: header field of the header.
			          message.setFrom(new InternetAddress(from)); 
			       // Set To: header field of the header.
			          message.addRecipient(Message.RecipientType.TO,
			                                   new InternetAddress(to));
			       // Set Subject: header field
			          message.setSubject("Account info!");
			       // Now set the actual message
			          message.setText("User Name :"+uname+" ;password :"+upass);
			       // Send message
			          Transport.send(message);
			          System.out.println("Sent message successfully....");   
			          out.println("Sent message successfully....");
					
		      }catch (MessagingException mex) {
		          mex.printStackTrace();
		      }catch(ClassNotFoundException e){
					out.println("could not load database driver:" + e.getMessage());
					
				}catch(SQLException e){
					out.println("SQLException caught:" + e.getMessage());
					
				}catch(Exception e){
					out.println(e);
				}finally {
					// Allways close the db connection
					try{
						if (connection != null) connection.close();
						
					}
					catch (SQLException ignored){
						out.println(ignored);
					}
			}
			
	}
}

