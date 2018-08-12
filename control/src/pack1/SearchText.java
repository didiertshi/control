package pack1;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class SearchText {
	java.sql.Connection con = null;
	String url = "jdbc:mysql://localhost:3306/agri";
	String driver ="com.mysql.jdbc.Driver";
	String userName ="enfant1";
	String password="!Muepu$2016!";
	int sumcount =0;
	java.sql.Statement st;
	
	String page;
	public SearchText(String page){
		this.page = page;
	}
	
	public List LText(){
		ArrayList<TextInfo>  theTList = new ArrayList<TextInfo>();
		
		try{
			String query1 = "select * from agri_text where text_page = '"+page+"'";
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,userName,password);
			st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query1);
			while (rs.next()){
				theTList.add(new TextInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			rs.close();
            st.close();
            con.close();
			
		}catch(Exception ex){
			 System.out.println(ex.getMessage());
		}
		
		return theTList;
	}
	
	public List<SelectItem>  getVTextes(){
		
		String query1 = "select * from agri_text where text_page = '"+page+"'";
		ArrayList<SelectItem> textes = new ArrayList<SelectItem>();
		
		try{
			textes.add(new SelectItem("0","--- Selectioner texte ---"));
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,userName,password);
			st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query1);
			while (rs.next()){
				textes.add(new SelectItem(rs.getString(1),rs.getString(2)));
			}
			rs.close();
            st.close();
            con.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return textes;
	}

}
