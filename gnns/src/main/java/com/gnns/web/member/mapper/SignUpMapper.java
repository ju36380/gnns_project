package com.gnns.web.member.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.notice.model.NoticeModel;

@Mapper
public interface SignUpMapper {
	/**
	 * 아이디 중복
	 * @param param
	 * @return
	 */
	public Integer idCheck(MemberModel model);
	
	/**
	 * 회원가입
	 * @param param
	 * @return
	 */
	public Integer insertMember(MemberModel model);
	
	public Optional<MemberModel> findByUserId(String userId);

	public String idSearch(MemberModel model); // 21-10-13 준혁 추가

	public String passSearch(MemberModel model); // 21-10-13 준혁 추가

	public Integer passUpdate(MemberModel model); // 21-10-13 준혁 추가

	public List<MemberModel> getManagement(MemberModel model); // 21-10-18 준혁 추가

	public MemberModel getMemberListCount(MemberModel model); // 21-10-18 준혁 추가

	public MemberModel getMemberRead(MemberModel model); // 21-10-18 준혁 추가

	public Integer updateMember(MemberModel model);

	public Integer memberDelete(int seq);


}
