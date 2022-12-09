package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.BoardMapper;
import com.example.demo.repository.mapper.MarketMapper;

import vo.BoardVO;
import vo.MarketVO;

@Component
public class BoardDao {
   @Autowired
   private SqlSessionTemplate session;
   ///////////////////////////////////////
   public int insert(BoardVO board) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.insert(board);
   }
   
   public int selectCount() {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.selectTotalCount();
   }
   
   public BoardVO select(int boardNum) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.select(boardNum);
   }
   
   public List<BoardVO> selectList(int startRow, int count){
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.selectList(startRow, count);
   }
   
   public int updateReadCount(int boardNum) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.updateReadCount(boardNum);
   }
   
   public int update(BoardVO board) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.update(board);
   }
   
   public int delete(int boardNum) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.delete(boardNum);
   }
   
   
   public int myCount(String writer) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
      return mapper.selectMyCount(writer);
   }
   
   
   // 내 게시글
   public List<BoardVO>  myBoardList(int startRow2, int count2,String writer){
      BoardMapper mapper = session.getMapper(BoardMapper.class);
   return mapper.myBoardList(startRow2, count2,writer);
      }
   public int selectCount2(String writer) {
      BoardMapper mapper = session.getMapper(BoardMapper.class);
   return mapper.selectTotalCount2(writer);
      }
}