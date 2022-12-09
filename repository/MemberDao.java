package com.example.demo.repository;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.MemberMapper;

import vo.MemberVO;

@Component
public class MemberDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public int insert(MemberVO member) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}
	
	public MemberVO select(String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectMember(id);
	}
	
	public int selectMemberNum(String id , String pw) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectMemberNum(id, pw);
	}
	
	public int updateMember(MemberVO member) {
	      MemberMapper mapper = session.getMapper(MemberMapper.class);
	      return mapper.update(member);
	   }
	   
	   public MemberVO selectMember(int memberNum) {
	      MemberMapper mapper = session.getMapper(MemberMapper.class);
	      return mapper.select(memberNum);
	   }
	   
	   public int deleteMember(MemberVO member) {
	      MemberMapper mapper = session.getMapper(MemberMapper.class);
	      return mapper.delete(member);
	   }
	   
//	   //비밀번호 찾기
//	   public MemberVO findPw(String id, String name) {
//		   MemberMapper mapper = session.getMapper(MemberMapper.class);
//		   return mapper.findPw(id, name);
//	   }
	   
	   //아이디 찾기
//	   public MemberVO select2(String name,String phone) {
//			MemberMapper mapper = session.getMapper(MemberMapper.class);
//			return mapper.selectMember2(name,phone);
//		}
	   
	   
	   public int select2(String name , String phone) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.selectMemberNum2(name, phone);
		}
	
	   
	   
	   public MemberVO selectMember2(String phone) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.selectMember2(phone);
		}
	   
	   
	   public int selectpw(String id) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.selectMemberNumpw(id);
		}
	   
	   
	
}
