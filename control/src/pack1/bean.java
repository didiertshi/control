package pack1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@ManagedBean
@ViewScoped

public class bean {
	
	// Connection SQL
	java.sql.Connection con = null;
	String url = "jdbc:mysql://localhost:3306/agri";
	String driver ="com.mysql.jdbc.Driver";
	String userName ="enfant1";
	String password="!Muepu$2016!";
	int sumcount =0;
	java.sql.Statement st;
	
	//Text ID
	private String vtext;
	//Text value
	private String selectedTpage1;
	// new text value
	private String ntext;
	
	private String vimage;
	private String nimagedesc;
	
	private UploadedFile uploadeImage;
	
	private String imageName;
	
	private Date date;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	public UploadedFile getUploadeImage() {
		return uploadeImage;
	}

	public void setUploadeImage(UploadedFile uploadeImage) {
		this.uploadeImage = uploadeImage;
	}

	public String getNimagedesc() {
		return nimagedesc;
	}

	public void setNimagedesc(String nimagedesc) {
		this.nimagedesc = nimagedesc;
	}
	
	// Image Value
	private String selectedIpage1;
	
	public String getSelectedIpage1() {
		
		String query1 ="select * from agri.agri_gallery_image where gallery_image_id = '"+vimage+"'";
		try{
			Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query1);
                rs.next();
                selectedIpage1 = "/../../../agri_images/"+rs.getString(5);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		return selectedIpage1;
	}

	public void setSelectedIpage1(String selectedIpage1) {
		this.selectedIpage1 = selectedIpage1;
	}

	public String getVimage() {
		return vimage;
	}

	public void setVimage(String vimage) {
		this.vimage = vimage;
		
	}

	
	
	public String getNtext() {
		return ntext;
	}

	public void setNtext(String ntext) {
		this.ntext = ntext;
	}

	

	public String getSelectedTpage1() {
		
        String query1 ="select * from agri.agri_text where agri_text_id = '"+vtext+"'";
		
		try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query1);
                rs.next();
                selectedTpage1 = rs.getString(3);
    		
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		
		return selectedTpage1;
	}

	public void setSelectedTpage1(String selectedTpage1) {
		this.selectedTpage1 = selectedTpage1;
	}

	public String getVtext() {
		return vtext;
	}

	public void setVtext(String vtext) {
		this.vtext = vtext;
	}

	//Display Text page1
	public List getdispTexts(){
		String page = ""+1;
		ArrayList<TextInfo>  displTexts = new ArrayList<TextInfo>();
		displTexts= (ArrayList<TextInfo>) (new SearchText(page)).LText();
		
		return displTexts;
	}
	// itemlist of text page1
	
	public List<SelectItem> getiTextes(){
		String page = ""+1;
		ArrayList<SelectItem> itextes = new ArrayList<SelectItem>();
		itextes =   (ArrayList<SelectItem>) (new SearchText(page)).getVTextes();
		
		return itextes;
	}
	//Display Images page1
	
	public List getdispImages(){
		String page = ""+1;
		ArrayList<ImageInfo>  dispImages = new ArrayList<ImageInfo>();
		dispImages = (ArrayList<ImageInfo>)(new SearchImage(page).LImage());
		return dispImages;
	}
	
	// itemlist of image page1
	public List<SelectItem> getiImages(){
		String page = ""+1;
		ArrayList<SelectItem> iimages = new ArrayList<SelectItem>();
		iimages = (ArrayList<SelectItem>) (new SearchImage(page)).getVImages();
		
		return iimages;
	}
	//Change Image
	public void submitIp1() throws IOException{
		
		String query = "update agri.agri_gallery_image set image_date = ? ,image_file = ?,image_desc= ? where gallery_image_id = '"+vimage+"'";
		File file = null;
		OutputStream output = null;
		// Prepare filename prefix and suffix for an unique filename in upload folder.
        String prefix = FilenameUtils.getBaseName(uploadeImage.getName());
        String suffix = FilenameUtils.getExtension(uploadeImage.getName());
        
        try{
        	// Create file with unique name in upload folder and write to it.
        	file = File.createTempFile(prefix + "_", "." + suffix, new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/agri_images"));
        	 output = new FileOutputStream(file);
        	 IOUtils.copy(uploadeImage.getInputStream(), output);
        	 imageName = file.getName();
        	 
        	       FacesContext.getCurrentInstance().addMessage("country", new FacesMessage(
                     FacesMessage.SEVERITY_INFO, "File upload succeed!", null));
        }finally{
        	IOUtils.closeQuietly(output);	
        	
        }
        
      //update record to mysql for image on page 1
        String strDate = dateFormat.format(date);
        
        try{
        	Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			preparedStmt.setString (1, strDate);
			preparedStmt.setString (2, imageName);
			preparedStmt.setString (2, nimagedesc);
			preparedStmt.executeUpdate();
			con.close();
			
        }catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
        
	}
	
	// Display Videos page1
	
	public List getdispVideos(){
		ArrayList  dispVideos = new ArrayList();
		
		return dispVideos;
	}
	
	// Display Files page1
	public List getdispFiles(){
		ArrayList  dispFiles = new ArrayList();
		
		return dispFiles;
	}
	
	//submit text 
	public void submittext(){
		String query = "update agri_text set text_value = ?  where agri_text_id = ?";
		
		try{
			Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			preparedStmt.setString (1, ntext);
			preparedStmt.setString(2, vtext);
			preparedStmt.executeUpdate();
			
			
            
            con.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	// End Page 1

	
}
