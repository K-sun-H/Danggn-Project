package com.example.demo.repository.mapper;

import org.apache.ibatis.annotations.Param;

import vo.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO member);

	public MemberVO selectMember(String id);

	public int selectMemberNum(@Param("id") String id, @Param("password") String password);

	public int update(MemberVO member);

	public MemberVO select(int memberNum);

	public int delete(MemberVO member);
	
	
	//아이디,비번 찾기
	
	public int selectMemberNumpw(@Param("id") String id);
	
	public int selectMemberNum2(@Param("name") String name, @Param("phone") String phone);

	public MemberVO selectMember2(String phone);
	
	

}
