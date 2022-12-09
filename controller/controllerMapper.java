
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

import vo.MarketVO;
import vo.MemberVO;


@Controller
public class controllerMapper {
   
   @Autowired
   private MemberService service;
   @Autowired
   private BoardService service2;
   @Autowired
   private MarketService service3;

   
   @RequestMapping("/joinForm")
   public String joinForm() {
      return "join_form";
   }

   
   @RequestMapping("/join")
   public String join(MemberVO member,HttpSession session) {
      if(service.join(member)) {
         return "join_success";
      }else {
         return "join_fail";
      }
   }
   
   @RequestMapping("/login")
   public String login(String id, @RequestParam("password") String pw, HttpSession session) {
      if(service.login(id, pw)) {
         session.setAttribute("loginId", id);
         return "login_success";
      }else {
         return "login_fail";
      }
   }
   
   @RequestMapping(value = "/myPage",method=RequestMethod.GET)
   public ModelAndView mypage(@RequestParam(defaultValue="1") int page, HttpSession session) {
      
      ModelAndView mv = new ModelAndView();
      
      String loginId = (String)session.getAttribute("loginId");
      
      if(loginId != null && loginId.length() > 0) {
         //로그인 정보 있음
         MemberVO member = service.getMemberInfo(loginId);
         int totalcount = service2.myCount(loginId);
         int buycount = service3.buyCount(loginId);
         int buysum = service3.buySum(loginId);
         
         mv.addObject("myCount", totalcount);
         mv.addObject("buyCount", buycount);
         mv.addObject("buySum", buysum);
         mv.addObject("memberInfo" , member);
         mv.addObject("boardPage",service2.makeBoardPage(page));
         mv.setViewName("my_page");
      }else {
         System.out.println("로그인 정보 없음");
      }
      return mv;
   }
   
   
   
   
//   @RequestMapping(value = "/myWrite",method=RequestMethod.GET)
//   public ModelAndView board(@RequestParam(defaultValue="1") int page) {
//   
//      ModelAndView mv = new ModelAndView();
//      
//      mv.addObject("boardPage",service.makeBoardPage(page));
//      mv.setViewName("board_list");
//      
//      return mv;
//   }
//   
   
//   @RequestMapping(value = "/myPage",method=RequestMethod.GET)
//   public ModelAndView board(@RequestParam(defaultValue="1") int page) {
//   
//      ModelAndView mv = new ModelAndView();
//      mv.addObject("boardPage",service2.makeBoardPage(page));
//      mv.setViewName("my_page");
//      
//      return mv;
//   }
   
   
   
   @RequestMapping("/myData")
   public ModelAndView mydata(HttpSession session) {
      
      ModelAndView mv = new ModelAndView();
      
      String loginId = (String)session.getAttribute("loginId");
      
      if(loginId != null && loginId.length() > 0) {
         //로그인 정보 있음
         MemberVO member = service.getMemberInfo(loginId);
         mv.addObject("memberInfo" , member);
         mv.setViewName("my_data");
      }else {
         System.out.println("로그인 정보 없음");
      }
      return mv;
   }
   
   
   @RequestMapping("/logout")
   public String logout(HttpSession session) {
      //세션 무효화.
      session.invalidate();
      return "logout";
   }
   
   
   //회원정보 수정
   
   @RequestMapping("/mydataupdateForm")
   public ModelAndView mydataupdateForm(int memberNum,HttpSession session) {
      String loginId = (String)session.getAttribute("loginId");
      MemberVO member = service.getMemberInfo(loginId);
      ModelAndView mv = new ModelAndView("mydataupdate_form");
      mv.addObject("original", service.readMember(memberNum));
      mv.addObject("memberInfo" , member);
      int totalcount = service2.myCount(loginId);
      int buycount = service3.buyCount(loginId);
      int buysum = service3.buySum(loginId);
      mv.addObject("myCount", totalcount);
      mv.addObject("buyCount", buycount);
      mv.addObject("buySum", buysum);
      return mv;
   }
   
   
   @RequestMapping("/mydataupdate")
   public ModelAndView mydataupdate(MemberVO member) {
      ModelAndView mv = new ModelAndView();
      int result = service.modifyMember(member);
      System.out.println(result);
      
      mv.addObject("updateMemberNum", member.getMemberNum());
      mv.addObject("mydataupdateResult" , result);
      mv.setViewName("mydataupdate_result");
      return mv;
   }
   
   
   //회원 탈퇴
   @RequestMapping("/mydatadeleteForm")
   public ModelAndView mydatadeleteForm(int memberNum,HttpSession session) {
         String loginId = (String)session.getAttribute("loginId");

      MemberVO member = service.getMemberInfo(loginId);
      ModelAndView mv = new ModelAndView("mydatadelete_form");
      mv.addObject("memberInfo" , member);

      mv.addObject("original2", service.readMember(memberNum));
      int totalcount = service2.myCount(loginId);
      int buycount = service3.buyCount(loginId);
      int buysum = service3.buySum(loginId);
      mv.addObject("myCount", totalcount);
      mv.addObject("buyCount", buycount);
      mv.addObject("buySum", buysum);
      return mv;
   }

   
   
   @RequestMapping("/mydatadelete")
   public ModelAndView mydatadelete(MemberVO member) {
      ModelAndView mv = new ModelAndView();

      int result = service.deleteMember(member);
      
      mv.addObject("deleteMemberNum", member.getMemberNum());
      mv.addObject("mydatadeleteResult", result);
      mv.setViewName("mydatadelete_result");
      return mv;
   }
   
   //비번찾기 화면
   @RequestMapping("/findForm")
   public String findForm() {
      return "find_form";
   }
   
   //비번찾기
   @RequestMapping("/findPw")
   public ModelAndView findPw(@RequestParam("id") String id) {
	   ModelAndView mv = new ModelAndView();
	
	   if(service.getPwInfocount(id)) {
   
   MemberVO result = service.getPwInfo(id);
   mv.addObject("pwInfo",result);
   mv.setViewName("find_Pw");
	   }else {
		   mv.setViewName("findpw_fail");
	   }
   return mv;
   }
  
 
   
   //아이디찾기 화면
   @RequestMapping("/findIdForm")
   public String findIdForm() {
      return "findId_form";
   }
   

   //아이디찾기
   @RequestMapping("/findId")
   public ModelAndView findId(@RequestParam("name") String name,@RequestParam("phone") String phone) {
   	   ModelAndView mv = new ModelAndView();
   	   
   	   if(service.getIdInfo(name, phone)) {
   		   
   		MemberVO result = service.getIdInfo2(phone);
        mv.addObject("memberInfo2" ,result);
   	         mv.setViewName("find_Id");
         
      }else {
    	  mv.setViewName("find_fail");
         
      }
   	   return mv;
   }
   

   
   //홈화면
   @RequestMapping("/home")
   public ModelAndView readsort() {
	   ModelAndView mv = new ModelAndView("home");
	   mv.addObject("readsort", service3.readsort(6));
	   return mv;
   }
//   public String home() {
//      return "home";
//   }
   
   //회사소개
   @RequestMapping("/about")
   public String about() {
      return "about";
   }
   
   
   
   
}

