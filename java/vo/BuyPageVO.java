
package vo;

import java.util.List;

public class BuyPageVO {
   
   private List<MarketVO> marketList;
   private int currentPage;
   private int startPage;
   private int endPage;
   private int totalPage;

   
//////////////////////////////////////////////////////
   
public BuyPageVO(List<MarketVO> marketList, int currentPage, int startPage, int endPage, int totalPage) {
super();
this.marketList = marketList;
this.currentPage = currentPage;
this.startPage = startPage;
this.endPage = endPage;
this.totalPage = totalPage;
}

//////////////////////////////////////////////////////

public List<MarketVO> getMarketList() {
return marketList;
}


public void setMarketList(List<MarketVO> marketList) {
this.marketList = marketList;
}


public int getCurrentPage() {
return currentPage;
}


public void setCurrentPage(int currentPage) {
this.currentPage = currentPage;
}


public int getStartPage() {
return startPage;
}


public void setStartPage(int startPage) {
this.startPage = startPage;
}


public int getEndPage() {
return endPage;
}


public void setEndPage(int endPage) {
this.endPage = endPage;
}


public int getTotalPage() {
return totalPage;
}


public void setTotalPage(int totalPage) {
this.totalPage = totalPage;
}

//////////////////////////////////////////////////////

@Override
public String toString() {
   return "MarketPageVO [marketList=" + marketList + ", currentPage=" + currentPage + ", startPage=" + startPage
         + ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
}





}
