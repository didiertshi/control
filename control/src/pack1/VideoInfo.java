package pack1;

public class VideoInfo {
	
	private String agri_youtube_id;
	private String agri_youtube_name;
	private String agri_youtube_param;
	private String agri_youtube_date;
	private String agri_youtube_desc;
	private String agri_youtube_page;
	private String agri_youtube_link;

	public String getAgri_youtube_page() {
		return agri_youtube_page;
	}
	public void setAgri_youtube_page(String agri_youtube_page) {
		this.agri_youtube_page = agri_youtube_page;
	}
	public String getAgri_youtube_id() {
		return agri_youtube_id;
	}
	public void setAgri_youtube_id(String agri_youtube_id) {
		this.agri_youtube_id = agri_youtube_id;
	}
	public String getAgri_youtube_name() {
		return agri_youtube_name;
	}
	public void setAgri_youtube_name(String agri_youtube_name) {
		this.agri_youtube_name = agri_youtube_name;
	}
	public String getAgri_youtube_param() {
		return agri_youtube_param;
	}
	public void setAgri_youtube_param(String agri_youtube_param) {
		this.agri_youtube_param = agri_youtube_param;
	}
	public String getAgri_youtube_date() {
		return agri_youtube_date;
	}
	public void setAgri_youtube_date(String agri_youtube_date) {
		this.agri_youtube_date = agri_youtube_date;
	}
	public String getAgri_youtube_desc() {
		return agri_youtube_desc;
	}
	public void setAgri_youtube_desc(String agri_youtube_desc) {
		this.agri_youtube_desc = agri_youtube_desc;
	}
	public String getAgri_youtube_link() {
		return agri_youtube_link;
	}
	public void setAgri_youtube_link(String agri_youtube_link) {
		this.agri_youtube_link = agri_youtube_link;
	}
	public VideoInfo(String agri_youtube_id,String agri_youtube_name,String agri_youtube_param,String agri_youtube_date,String agri_youtube_desc,String agri_youtube_page){
		this.agri_youtube_id = agri_youtube_id;
		this.agri_youtube_name = agri_youtube_name;
		this.agri_youtube_param = agri_youtube_param;
		this.agri_youtube_date = agri_youtube_date;
		this.agri_youtube_desc = agri_youtube_desc;
		this.agri_youtube_page = agri_youtube_page;
		this.agri_youtube_link = "https://www.youtube.com/embed/"+ agri_youtube_param;
	}
	}
