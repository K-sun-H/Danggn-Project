package vo;

import java.util.Date;

public class BoardVO {
	
	private int boardNum;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	private Date writeDate;
	
	/////////////////////////////////////////////////
	
	public BoardVO(int boardNum, String title, String writer, String content, int readCount, Date writeDate) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}
	
	
	public BoardVO(String title, String writer, String content, int readCount, Date writeDate) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}
	
	

	public BoardVO() {
		super();
	}


	/////////////////////////////////////////////////////

	public int getBoardNum() {
		return boardNum;
	}


	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}


	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", readCount=" + readCount + ", writeDate=" + writeDate + "]";
	}
	
	
	
	

}
