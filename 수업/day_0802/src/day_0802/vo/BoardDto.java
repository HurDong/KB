package day_0802.vo;

import java.util.Date;

public class BoardDto {
	private int no;
	private String title, writer;
	private Date regDate;
	private String content;

	public BoardDto() {
	}

	public BoardDto(int no, String title, String writer, Date regDate, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "no=" + no + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate + ", content=" + content;
	}

}
