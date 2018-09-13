package pack1;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class SearchVideo {
	
	java.sql.Connection con = null;
	String url = "jdbc:mysql://localhost:3306/agri";
	String driver ="com.mysql.jdbc.Driver";
	String userName ="enfant1";
	String password="!Muepu$2016!";
	int sumcount =0;
	java.sql.Statement st;
	
	String page;
	
	public SearchVideo(String page){
		this.page = page;
	}
	
	public List LVideo(){
		ArrayList<VideoInfo> theVList = new ArrayList<VideoInfo>();
		  try{
			  String query1 = "select * from agri_youtube where agri_youtube_page  = '"+page+"'";
			  Class.forName(driver).newInstance();
				con = DriverManager.getConnection(url,userName,password);
				st = con.createStatement();
				java.sql.ResultSet rs = st.executeQuery(query1);
				while (rs.next()){
					theVList.add(new VideoInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
				}
				rs.close();
	            st.close();
	            con.close();
		  }catch(Exception ex){
			  System.out.print(ex);
		  }
		
		
		return theVList;
		
	}
	
	public List<SelectItem> getVVideos(){
		
		String query1 = "select * from agri_youtube where agri_youtube_page  = '"+page+"'";
		
		ArrayList<SelectItem> videos = new ArrayList<SelectItem>();
		try{
			videos.add(new SelectItem("0","--- Selectioner video ---"));
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,userName,password);
			st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query1);
			while (rs.next()){
				videos.add(new SelectItem(rs.getString(1),rs.getNString(2)));
			}
		}catch(Exception ex){
			System.out.print(ex);
			
		}
		
		return videos;
		
	}

}
