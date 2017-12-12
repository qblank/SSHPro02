package cn.qblank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity //映射到数据表中
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2 ,max = 10)
	private String author;
	@Size(min = 2 ,max = 64)
	private String bookname;
	//出版社
	private String publishConpany;
	//出版日期
	private Date publishDate;
	@Size(min = 2 , max = 64)
	private String info;
	@Size(min = 2, max = 64)
	private String booktype;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublishConpany() {
		return publishConpany;
	}
	public void setPublishConpany(String publishConpany) {
		this.publishConpany = publishConpany;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public Book(Long id, String author, String bookname, String publishConpany, Date publishDate, String info,
			String booktype) {
		super();
		this.id = id;
		this.author = author;
		this.bookname = bookname;
		this.publishConpany = publishConpany;
		this.publishDate = publishDate;
		this.info = info;
		this.booktype = booktype;
	}
	public Book(){}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", bookname=" + bookname + ", publishConpany=" + publishConpany
				+ ", publishDate=" + publishDate + ", info=" + info + ", booktype=" + booktype + "]";
	}
	
	
	
}
