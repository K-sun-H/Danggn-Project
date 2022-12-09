package com.example.demo.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.MemberDao;

import vo.MemberVO;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	//회원가입
	

		public boolean join(MemberVO member) throws DuplicateKeyException {
			member.setWriteDate(new Date());
			try {
				if (dao.insert(member) > 0) {

					return true;
				} else {
					return false;
				}
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
			} finally {
				System.out.println("에러");
			}
			return false;
		}
		
	
	//로그인
	public boolean login(String id, String pw) {
		if(dao.selectMemberNum(id, pw)== 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public MemberVO getMemberInfo(String loginId) {
		return dao.select(loginId);
	}
	
	
	//회원정보 수정
	   public int modifyMember(MemberVO member) {
	      return dao.updateMember(member);
	   }
	   
	   public MemberVO readMember(int memberNum) {
	      return dao.selectMember(memberNum);
	   }
	   
	   
	   //회원탈퇴
	   public int deleteMember(MemberVO member) {
	      return dao.deleteMember(member);
	   }
	   
	   //비번찾기
	   public boolean getPwInfocount(String id) {
			if(dao.selectpw(id) == 1) {
				return true;
			}else {
				return false;
			}
		}
	   
	   
	   public MemberVO getPwInfo(String id) {
		   return dao.select(id);
	   }
	   
	   //아이디 찾기
//	   public MemberVO getIdInfo(String name,String phone) {
//		   return dao.select2(name,phone);
//	   }
	
	   public boolean getIdInfo(String name,String phone) {
			if(dao.select2(name, phone) ==1) {
				return true;
			}else {
				return false;
			}
		}
	
	   public MemberVO getIdInfo2(String phone) {
		   return dao.selectMember2(phone);
	   }
	
}








