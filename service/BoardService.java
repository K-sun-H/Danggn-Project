package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.BoardDao;

import vo.BoardPageVO;
import vo.BoardVO;
import vo.MarketVO;
import vo.MyBoardPageVO;
import vo.MyMarketPageVO;

@Component
public class BoardService {
   @Autowired
   public BoardDao dao;

   private static final int COUNT_PER_PAGE = 10;
   private static final int COUNT_PER_PAGE2 = 8;
   
   public BoardPageVO makeBoardPage(int currentPage) {
      
      int totalCount = dao.selectCount();      
      
      int totalPage = totalCount/COUNT_PER_PAGE;
      
      if (totalCount%COUNT_PER_PAGE!=0) {
         totalPage++;
      }
      
      int startPage = (currentPage-1)/10*10+1;
      
      int endPage = startPage +9 ;
      if(totalPage < endPage) {
         
         endPage = totalPage;
      }
      
      int startRow = (currentPage-1) * COUNT_PER_PAGE;
      
      List<BoardVO> boardList=dao.selectList(startRow, COUNT_PER_PAGE);
      
      return new BoardPageVO(boardList,currentPage,startPage,endPage,totalPage);
   }
   public int write(BoardVO board,String loginId) {
      

      board.setReadCount(0); 
      board.setWriteDate(new Date()); 
      board.setWriter(loginId); 
      
      return dao.insert(board);
   }
   
   public BoardVO read(int boardNum, String loginId) {
      
      BoardVO board = dao.select(boardNum);
      if(loginId != null && loginId.equals(board.getWriter())) {
         return board;
      }else {

         dao.updateReadCount(boardNum);
         return dao.select(boardNum);
      }
   }
   
   public BoardVO readNoCount(int boardNum) {
      return dao.select(boardNum);
   }
   
   
   public boolean update(BoardVO board, String loginId) {
      BoardVO original = dao.select(board.getBoardNum());
      
      if(loginId != null&&loginId.equals(original.getWriter())) {
         board.setWriteDate(new Date());
         dao.update(board);
         return true;
         }else {
         return false;
      }
      
   }
   public boolean delete(int boardNum, String loginId) {
      BoardVO board = dao.select(boardNum);
   
      if(loginId != null&& loginId.equals(board.getWriter())) {
         dao.delete(boardNum);
         return true;
      }else {
         return false;
      }
   
   }
   
   
//   내 게시글 수
   public int myCount(String wrtier) {
      return dao.myCount(wrtier);
   }
   
   //내게시글수
   public MyBoardPageVO makemyBoardPage(int currentPage, String loginId) {
      
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
         
         int startRow2 = (currentPage-1) * COUNT_PER_PAGE2;
         
         List<BoardVO> marketList=dao.myBoardList(startRow2, COUNT_PER_PAGE2,loginId);
         
         return new MyBoardPageVO(marketList,currentPage,startPage,endPage,totalPage);
      }

   
}