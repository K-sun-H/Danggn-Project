package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.BoardVO;

public interface BoardMapper {
   
   public int insert(BoardVO board);
   public int selectTotalCount();
   public List<BoardVO> selectList(@Param("startRow") int startRow, @Param("count") int count);
   public BoardVO select(int boardNum);
   public int updateReadCount(int baordNum);
   public int update(BoardVO board);
   public int delete(int boardNum);
   
   public int selectMyCount(@Param("writer") String writer);
   
   //내가쓴게시글
   public List<BoardVO> myBoardList(@Param("startRow2") int startRow2, @Param("count2") int count2,@Param("writer") String writer);
   public int selectTotalCount2(@Param("writer") String writer);

}