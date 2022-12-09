package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.BoardMapper;
import com.example.demo.repository.mapper.MarketMapper;

import vo.MarketVO;

@Component
public class MarketDao {
   @Autowired
   
   private SqlSessionTemplate session;
   ///////////////////////////////////////
   public int insert(MarketVO market) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.insert(market);
   }
   
   public int selectCount() {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.selectTotalCount();
   }
   
   public MarketVO select(int marketNum) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.select(marketNum);
   }
   
   public List<MarketVO> selectList(int startRow, int count){
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.selectList(startRow, count);
   }
   
   public int updateReadCount(int marketNum) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.updateReadCount(marketNum);
   }
   
   public int update(MarketVO market) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.update(market);
   }
   
   public int delete(int marketNum) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.delete(marketNum);
   }
   
   
//   구매하기
   public int updatebuy(MarketVO market) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.updatebuy(market);
   }
   
   
   //내 구매 글 갯수
   public int buyCount(String buyPeople) {
      MarketMapper mapper = session.getMapper(MarketMapper.class);
      return mapper.selectBuyCount(buyPeople);
   }
   
   //내 구매 총액
      public int buySum(String buyPeople) {
         MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.selectBuySum(buyPeople);
      }
      
   
   //조회수 정렬
      public List<MarketVO> readsort(int count2){
         MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.readsort(count2);
      }


   //내 구매내역
      public List<MarketVO> myBuyList(int startRow3, int count3,String buyPeople){
         MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.myBuyList(startRow3, count3,buyPeople);
      }
      public int selectCount2(String buyPeople) {
         MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.selectTotalCount2(buyPeople);
      }
      
      //판매내역
      public List<MarketVO> myMarketList(int startRow4, int count4,String writer){
            MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.myMarketList(startRow4, count4,writer);
            }
      public int selectCount3(String writer) {
         MarketMapper mapper = session.getMapper(MarketMapper.class);
         return mapper.selectTotalCount3(writer);
            }
   

}