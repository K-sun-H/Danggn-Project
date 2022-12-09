package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.service.MarketService;
import com.example.demo.service.MemberService;

import vo.BoardVO;
import vo.MemberVO;

@Controller
public class BoardController {
   
   @Autowired
   private BoardService service;
   @Autowired
   private MemberService service2;
   @Autowired
   private MarketService service3;
      
   @RequestMapping(value = "/board",method=RequestMethod.GET)
   public ModelAndView board(@RequestParam(defaultValue="1") int page) {
   
      ModelAndView mv = new ModelAndView();
      mv.addObject("boardPage",service.makeBoardPage(page));
      mv.setViewName("board_list");
      
      return mv;
   }
   
   
   
   @RequestMapping("/writeForm")
   public String writeForm(HttpSession session) {
      String loginId = (String)session.getAttribute("loginId");
      if(loginId!=null &&loginId.length()>0) {
         return "write_form";
      }else {
         return "";
      }
   }
   
   @RequestMapping(value ="/write", method=RequestMethod.POST)
   public String write(BoardVO board, HttpSession session) {
      String loginId =(String)session.getAttribute("loginId");
      
      if(loginId != null && loginId.length()>0) {
         service.write(board, loginId);
         return "write_result";
      }else {
         return "";
      }
   }
   
   @RequestMapping("read")
   public ModelAndView read(int boardNum, HttpSession session) {
      ModelAndView mv = new ModelAndView();
      
      String loginId = (String)session.getAttribute("loginId");
      BoardVO board = service.read(boardNum, loginId);
      
      mv.addObject("board", board);
      mv.setViewName("read");
      return mv;
   }
   
   @RequestMapping("/updateForm")
   public ModelAndView updateForm(int boardNum) {
      
      BoardVO board = service.readNoCount(boardNum);
      
      ModelAndView mv = new ModelAndView();
      mv.addObject("original", board);
      mv.setViewName("update_form");
      return mv;
   }
   
   @RequestMapping(value = "/update", method = RequestMethod.POST)
   public ModelAndView update(BoardVO board, HttpSession session) {
      String loginId = (String)session.getAttribute("loginId");
      
      boolean result = service.update(board, loginId);
      ModelAndView mv = new ModelAndView();
      
      if(result) {
         mv.addObject("boardNum", board.getBoardNum());
         mv.setViewName("update_success");
      }else {
         mv.setViewName("update_fail");
      }
      return mv;
   }
   
   @RequestMapping("/delete")
   public ModelAndView delete(int boardNum, HttpSession session) {
      String loginId = (String)session.getAttribute("loginId");
      boolean result = service.delete(boardNum, loginId);
      
      ModelAndView mv = new ModelAndView();
      mv.addObject("result" , result);
      mv.setViewName("delete_result");
      return mv;
}
   
   //내가쓴 게시글
   @RequestMapping(value = "/myBoard",method=RequestMethod.GET)
   public ModelAndView board2(@RequestParam(defaultValue="1") int page,HttpSession session) {
   
      ModelAndView mv = new ModelAndView();
      String loginId = (String)session.getAttribute("loginId");
      MemberVO member = service2.getMemberInfo(loginId);
      int totalcount = service.myCount(loginId);
      int buycount = service3.buyCount(loginId);
      int buysum = service3.buySum(loginId);
      mv.addObject("myCount", totalcount);
      mv.addObject("buyCount", buycount);
      mv.addObject("buySum", buysum);
      mv.addObject("memberInfo" , member);
      mv.addObject("myboardPage",service.makemyBoardPage(page,loginId));
      mv.setViewName("m_boardList");
      
      return mv;
   }
  
   
}
