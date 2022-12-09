package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.MarketDao;

import vo.BuyPageVO;
import vo.MarketPageVO;
import vo.MarketVO;
import vo.MyMarketPageVO;

@Component
public class MarketService {

    @Autowired
      public MarketDao dao;
      private static final int COUNT_PER_PAGE = 8;
      private static final int COUNT_PER_PAGE2=8;
      
      
      public MarketPageVO makeMarketPage(int currentPage) {
         
         int totalCount = dao.selectCount();      
         
         int totalPage = totalCount/COUNT_PER_PAGE;
         
         if (totalCount%COUNT_PER_PAGE!=0) {
            totalPage++;
         }
         
         int startPage = (currentPage-1)/8*8+1;
         
         int endPage = startPage +7 ;
         if(totalPage < endPage) {
            
            endPage = totalPage;
         }
         
         int startRow = (currentPage-1) * COUNT_PER_PAGE;
         
         List<MarketVO> marketList=dao.selectList(startRow, COUNT_PER_PAGE);
         
         return new MarketPageVO(marketList,currentPage,startPage,endPage,totalPage);
      }
      
      
//      public int write(MarketVO market,String loginId) {
//         
//
//         market.setReadCount(0); 
//         market.setWriteDate(new Date()); 
//         market.setWriter(loginId); 
//         
//         return dao.insert(market);
//      }
   
      public MarketVO read(int marketNum, String loginId) {
         
         MarketVO market = dao.select(marketNum);
         if(loginId != null && loginId.equals(market.getWriter())) {
            return market;
         }else {

            dao.updateReadCount(marketNum);
            return dao.select(marketNum);
         }
      }
      
      public int write(MarketVO market,String loginId, MultipartFile file) {
            
         String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/files";
         UUID uuid = UUID.randomUUID();
         String filename = uuid+"_"+file.getOriginalFilename();
         File saveFile = new File(projectpath,filename);
         try {
         file.transferTo(saveFile);
      } catch (IllegalStateException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
         market.setFilename(filename);
         market.setFilepath2("/files/"+filename);
         

         market.setReadCount(0); 
         market.setWriteDate(new Date()); 
         market.setBuy("판매중"); 
         market.setWriter(loginId); 
         
         return dao.insert(market);
         }
      
      public MarketVO readNoCount(int marketNum) {
         return dao.select(marketNum);
      }

      public boolean update(MarketVO market, String loginId) {
         MarketVO original = dao.select(market.getMarketNum());  
         
         if(loginId != null&&loginId.equals(original.getWriter())) {
            market.setWriteDate(new Date());
            dao.update(market);
            return true;
            }else {
            return false;
         }
         
      }
      public boolean delete(int marketNum, String loginId) {
         MarketVO market = dao.select(marketNum);
      
         if(loginId != null&& loginId.equals(market.getWriter())) {
            dao.delete(marketNum);
            return true;
         }else {
            return false;
         }
      
      }
      
      
      
      //구매하기
      public boolean updatebuy(MarketVO market, String loginId) {
         MarketVO original = dao.select(market.getMarketNum());    
            
         if(loginId != null&& !loginId.equals(original.getWriter())) {
            market.setBuyPeople(loginId);
            dao.updatebuy(market);
               return true;
               }else {
               return false;
            }
            
         }
      
   //   내 구매 수

      public int buyCount(String buyPeople) {
         return dao.buyCount(buyPeople);
      }
      
      
      //   내 구매 금액

         public int buySum(String buyPeople) {
            return dao.buySum(buyPeople);
         }
         
         
         //조회수 정렬
         int count2 = 6;
         public List<MarketVO> readsort(int count2){
         
            return dao.readsort(count2);
         }
            
         
         //구매내역
         public BuyPageVO makemyBuyPage(int currentPage, String loginId) {
            
               int totalCount = dao.selectCount2(loginId);
               
               int totalPage = totalCount/COUNT_PER_PAGE2;
               
               if (totalCount%COUNT_PER_PAGE2!=0) {
                  totalPage++;
               }
               
               int startPage = (currentPage-1)/8*8+1;
               
               int endPage = startPage +7 ;
               if(totalPage < endPage) {
                  
                  endPage = totalPage;
               }
               
               int startRow3 = (currentPage-1) * COUNT_PER_PAGE2;
               
               List<MarketVO> marketList=dao.myBuyList(startRow3, COUNT_PER_PAGE2,loginId);
               
               return new BuyPageVO(marketList,currentPage,startPage,endPage,totalPage);
            }
         
         
         //판매내역
         public MyMarketPageVO makemyMarketPage(int currentPage, String loginId) {
            
               int totalCount = dao.selectCount3(loginId);
               
               int totalPage = totalCount/COUNT_PER_PAGE2;
               
               if (totalCount%COUNT_PER_PAGE2!=0) {
                  totalPage++;
               }
               
               int startPage = (currentPage-1)/8*8+1;
               
               int endPage = startPage +7 ;
               if(totalPage < endPage) {
                  
                  endPage = totalPage;
               }
               
               int startRow4 = (currentPage-1) * COUNT_PER_PAGE2;
               
               List<MarketVO> marketList=dao.myMarketList(startRow4, COUNT_PER_PAGE2,loginId);
               
               return new MyMarketPageVO(marketList,currentPage,startPage,endPage,totalPage);
            }
   }
