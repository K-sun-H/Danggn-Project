package vo;

import java.util.Date;

public class MarketVO {
	
	private int marketNum;
	private String title;
	private String writer;
	private String price;
	private String content;
	private int readCount;
	private Date writeDate;
	private String filename;
	private String filepath2;
	private String buy;
	private String buyPeople;
	public MarketVO() {
		super();
	}
	public MarketVO(int marketNum, String title, String writer, String price, String content, int readCount,
			Date writeDate, String filename, String filepath2, String buy, String buyPeople) {
		super();
		this.marketNum = marketNum;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
		this.filename = filename;
		this.filepath2 = filepath2;
		this.buy = buy;
		this.buyPeople = buyPeople;
	}
	public MarketVO(String title, String writer, String price, String content, int readCount, Date writeDate,
			String filename, String filepath2, String buy, String buyPeople) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
		this.filename = filename;
		this.filepath2 = filepath2;
		this.buy = buy;
		this.buyPeople = buyPeople;
	}
	public int getMarketNum() {
		return marketNum;
	}
	public void setMarketNum(int marketNum) {
		this.marketNum = marketNum;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath2() {
		return filepath2;
	}
	public void setFilepath2(String filepath2) {
		this.filepath2 = filepath2;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getBuyPeople() {
		return buyPeople;
	}
	public void setBuyPeople(String buyPeople) {
		this.buyPeople = buyPeople;
	}
	@Override
	public String toString() {
		return "MarketVO [marketNum=" + marketNum + ", title=" + title + ", writer=" + writer + ", price=" + price
				+ ", content=" + content + ", readCount=" + readCount + ", writeDate=" + writeDate + ", filename="
				+ filename + ", filepath2=" + filepath2 + ", buy=" + buy + ", buyPeople=" + buyPeople + "]";
	}
	
	

	
	
	
	
}