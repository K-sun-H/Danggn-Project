package com.example.demo.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.service.MarketService;
import com.example.demo.service.MemberService;

import vo.MarketVO;
import vo.MemberVO;


@Controller
public class MarketController {
   @Autowired
      private MarketService service;
   @Autowired
      private MemberService service2;
   @Autowired
      private BoardService service3;
   
         
      @RequestMapping(value = "/market",method=RequestMethod.GET)
      public ModelAndView market(@RequestParam(defaultValue="1") int page) {
      
         ModelAndView mv = new ModelAndView();
         mv.addObject("marketPage",service.makeMarketPage(page));
         mv.setViewName("market_list");
         
         return mv;
      }
      
   
      
     
      
   
      
      @RequestMapping("/m_writeForm")
      public String writeForm(HttpSession session) {
         String loginId = (String)session.getAttribute("loginId");
         if(loginId!=null &&loginId.length()>0) {
            return "m_write_form";
         }else {
            return "";
         }
      }
      
      @RequestMapping(value ="/m_write", method=RequestMethod.POST)
      public String write(MarketVO market, HttpSession session, MultipartFile file) throws Exception {
         String loginId =(String)session.getAttribute("loginId");
         
         if(loginId != null && loginId.length()>0) {
            service.write(market, loginId,file);
            return "m_write_result";
         }else {
            return "";
         }
      }
      
//      @RequestMapping(value ="/m_write", method=RequestMethod.POST)
//      public String write(MarketVO market, HttpSession session) {
//         String loginId =(String)session.getAttribute("loginId");
//         
//         if(loginId != null && loginId.length()>0) {
//            service.write(market, loginId);
//            return "m_write_result";
//         }else {
//            return "";
//         }
//      }
      
      
      @RequestMapping("m_read")
      public ModelAndView read(int marketNum, HttpSession session) {
         ModelAndView mv = new ModelAndView();
         
         String loginId = (String)session.getAttribute("loginId");
         MarketVO market = service.read(marketNum, loginId);
         
         mv.addObject("market",market);
         mv.setViewName("m_read");
         
         return mv;
      }
      
      @RequestMapping("/m_updateForm")
      public ModelAndView updateForm(int marketNum) {
         
         MarketVO market = service.readNoCount(marketNum);
         
         ModelAndView mv = new ModelAndView();
         mv.addObject("original", market);
         mv.setViewName("m_update_form");
         return mv;
      }
      
      @RequestMapping(value = "/m_update", method = RequestMethod.POST)
      public ModelAndView update(MarketVO market, HttpSession session) {
         String loginId = (String)session.getAttribute("loginId");
         
         boolean result = service.update(market, loginId);
         ModelAndView mv = new ModelAndView();
         
         if(result) {
            mv.addObject("marketNum", market.getMarketNum());
            mv.setViewName("m_update_success");
         }else {
            mv.setViewName("m_update_fail");
         }
         return mv;
      }
      
      @RequestMapping("/m_delete")
      public ModelAndView delete(int marketNum, HttpSession session) {
         String loginId = (String)session.getAttribute("loginId");
         boolean result = service.delete(marketNum, loginId);
         
         ModelAndView mv = new ModelAndView();
         mv.addObject("result" , result);
         mv.setViewName("m_delete_result");
         return mv;
   }
      
      @RequestMapping("/myStore")
      public String storeForm() {
         return "my_store";
      }
      
      
//      //판매내역
//      @RequestMapping(value = "/myMarket",method=RequestMethod.GET)
//      public ModelAndView Mymarket(@RequestParam(defaultValue="1") int page) {
//      
//         ModelAndView mv = new ModelAndView();
//         mv.addObject("marketPage",service.makeMarketPage(page));
//         mv.setViewName("m_marketList");
//         
//         return mv;
//      }
      
      
      
      
      
      //구매하기
      @RequestMapping("/m_buy")
      public ModelAndView updatebuy(MarketVO market, HttpSession session) {
         String loginId = (String)session.getAttribute("loginId");
         
         boolean result2 = service.updatebuy(market, loginId);
         ModelAndView mv = new ModelAndView();
         
         if(result2) {
               mv.addObject("marketNum", market.getMarketNum());
               mv.setViewName("m_buy_result");
            }
         return mv;
   }
      
      
      //구매내역
      @RequestMapping(value ="/buylist",method=RequestMethod.GET)
      public ModelAndView Mybuylist(@RequestParam(defaultValue="1") int page,HttpSession session) {   
      
         ModelAndView mv = new ModelAndView();
         String loginId = (String)session.getAttribute("loginId");
          MemberVO member = service2.getMemberInfo(loginId);
          
          int buycount = service.buyCount(loginId);
          int buysum = service.buySum(loginId);
          int totalcount = service3.myCount(loginId);
          
          mv.addObject("buyCount", buycount);
          mv.addObject("buySum", buysum);
          mv.addObject("myCount", totalcount);
          mv.addObject("memberInfo" , member);
          
         mv.addObject("buyPage",service.makemyBuyPage(page,loginId));
         mv.setViewName("m_buyList");
         
         return mv;
      }
      
      
      
      
      //판매내역
      @RequestMapping(value = "/myMarket",method=RequestMethod.GET)
      public ModelAndView Mymarketlist(@RequestParam(defaultValue="1") int page,HttpSession session) {   
      
         ModelAndView mv = new ModelAndView();
         String loginId = (String)session.getAttribute("loginId");
          MemberVO member = service2.getMemberInfo(loginId);
          
          int buycount = service.buyCount(loginId);
          int buysum = service.buySum(loginId);
          int totalcount = service3.myCount(loginId);
          
          mv.addObject("buyCount", buycount);
          mv.addObject("buySum", buysum);
          mv.addObject("myCount", totalcount);
          mv.addObject("memberInfo" , member);
          
         mv.addObject("myMarketPage",service.makemyMarketPage(page,loginId));
         mv.setViewName("m_marketList");
         
         return mv;
      }
     
//      //판매내역
//      @RequestMapping(value = "/myMarket",method=RequestMethod.GET)
//      public ModelAndView Mymarket(@RequestParam(defaultValue="1") int page) {
//      
//         ModelAndView mv = new ModelAndView();
//         mv.addObject("marketPage",service.makeMarketPage(page));
//         mv.setViewName("m_marketList");
//         
//         return mv;
//      }

      
   }


