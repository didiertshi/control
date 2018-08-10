package pack1;

public class TextInfo {
	
	String agri_text_id;
	String text_name;
	String text_value;
	String text_page;
	String text_location;
	String text_section;
	
	public String getAgri_text_id() {
		return agri_text_id;
	}

	public void setAgri_text_id(String agri_text_id) {
		this.agri_text_id = agri_text_id;
	}

	public String getText_name() {
		return text_name;
	}

	public void setText_name(String text_name) {
		this.text_name = text_name;
	}

	public String getText_value() {
		return text_value;
	}

	public void setText_value(String text_value) {
		this.text_value = text_value;
	}

	public String getText_page() {
		return text_page;
	}

	public void setText_page(String text_page) {
		this.text_page = text_page;
	}

	public String getText_location() {
		return text_location;
	}

	public void setText_location(String text_location) {
		this.text_location = text_location;
	}

	public String getText_section() {
		return text_section;
	}

	public void setText_section(String text_section) {
		this.text_section = text_section;
	}

	
	
	public TextInfo(String agri_text_id,String text_name,String text_value,String text_page,String text_location,String text_section){
		this.agri_text_id = agri_text_id;
		this.text_name = text_name;
		this.text_value = text_value;
		this.text_page = text_page;
		this.text_location = text_location;
		this.text_section = text_section;
		
	}

}
