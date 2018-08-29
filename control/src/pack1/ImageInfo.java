package pack1;

public class ImageInfo {
	
	String gallery_image_id;
	String image_page;
	String image_name;
	String image_date;
	String image_file;
	String image_desc;
	
	public String getGallery_image_id() {
		return gallery_image_id;
	}
	public void setGallery_image_id(String gallery_image_id) {
		this.gallery_image_id = gallery_image_id;
	}
	public String getImage_page() {
		return image_page;
	}
	public void setImage_page(String image_page) {
		this.image_page = image_page;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getImage_date() {
		return image_date;
	}
	public void setImage_date(String image_date) {
		this.image_date = image_date;
	}
	public String getImage_file() {
		return image_file;
	}
	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}
	public String getImage_desc() {
		return image_desc;
	}
	public void setImage_desc(String image_desc) {
		this.image_desc = image_desc;
	}
	
	public ImageInfo(String gallery_image_id,String image_page,String image_name,String image_date,String image_file,String image_desc){
		this.gallery_image_id = gallery_image_id;
		this.image_date = image_date;
		this.image_desc = image_desc;
		this.image_file = image_file;
		this.image_name = image_name;
		this.image_page = image_page;
	}

}
