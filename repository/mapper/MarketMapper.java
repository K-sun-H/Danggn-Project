package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.MarketVO;

public interface MarketMapper {

   public int insert(MarketVO market);
   public int selectTotalCount();
   public List<MarketVO> selectList(@Param("startRow") int startRow, @Param("count") int count);
   public MarketVO select(int marketNum);
   public int updateReadCount(int marketNum);
   public int update(MarketVO market);
   public int delete(int marketNum);
   
   
   public int updatebuy(MarketVO market);
   
   public int selectBuyCount(@Param("buyPeople") String buyPeople);
   public int selectBuySum(@Param("buyPeople") String buyPeople);
   
   public List<MarketVO> readsort(@Param("count2") int count2);
   
   
   //내구매내역
   public List<MarketVO> myBuyList(@Param("startRow3") int startRow3, @Param("count3") int count3,@Param("buyPeople") String buyPeople);
   public int selectTotalCount2(@Param("buyPeople") String buyPeople);
   
   //내판매내역
   public List<MarketVO> myMarketList(@Param("startRow4") int startRow4, @Param("count4") int count4,@Param("writer") String writer);
   public int selectTotalCount3(@Param("writer") String writer);
}