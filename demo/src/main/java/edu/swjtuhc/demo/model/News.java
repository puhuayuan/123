package edu.swjtuhc.demo.model;

public class News {
     private int newsId;
     private int typeId;
     private String title;
     private String content;
     private String imgurl;
     private String datetime;
     private String author;
     private String state;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", typeId=" + typeId + ", title=" + title + ", content=" + content
				+ ", imgurl=" + imgurl + ", datetime=" + datetime + ", author=" + author + ", state=" + state + "]";
	}
	
     
     
}
