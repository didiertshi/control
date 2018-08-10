package pack1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
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
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@ManagedBean
@ViewScoped

public class bean {
	
	//Display Text page1
	public List getdispTexts(){
		String page = ""+1;
		ArrayList<TextInfo>  displTexts = new ArrayList<TextInfo>();
		displTexts= (ArrayList<TextInfo>) (new SearchText(page)).LText();
		
		return displTexts;
	}
	
	//Display Images page1
	
	public List getdispImages(){
		ArrayList  dispImages = new ArrayList();
		
		return dispImages;
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
}
