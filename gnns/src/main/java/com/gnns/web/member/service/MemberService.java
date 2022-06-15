package com.gnns.web.member.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.gnns.web.login.mapper.LoginMapper;
import com.gnns.web.login.model.MemberModel;
import com.gnns.web.member.mapper.SignUpMapper;
import com.gnns.web.member.mapper.UserCustom;


@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private SignUpMapper signUpMapper;
	
	@Autowired
	private LoginMapper loginMapper;
	
	
	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private boolean accountNonLocked = true;
	
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	    	
    	BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
    	MemberModel model = new MemberModel();
    	UserCustom userCustom = null;
    	String passwd = null;
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
 	  
		  model.setUserId(userId);
		  Optional<MemberModel> memberEntityWrapper = loginMapper.selectLoginMember(model); 
		  MemberModel memberEntity = memberEntityWrapper.orElse(null);
		  
		  if(memberEntity!=null && memberEntity.getMemType()!=null) {
			  passwd = bcryptPasswordEncoder.encode(memberEntity.getUserPw().trim());
			  
			  if(memberEntity.getMemType().contentEquals("chul")){
	        		 authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER_CHUL"));
	        	 }else if(memberEntity.getMemType().contentEquals("jung")) {
	        		 authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER_JUNG"));
	        	 }else {
	        		 authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
	        	 }
			  
			  	// 조회한 정보를 userCustom에 담는다.
	 			// 만약 파라미터를 추가해야한다면 UserCustom 을 먼저 수정한다.
	 			userCustom = new UserCustom(memberEntity.getUserId()
	 			        , passwd
	 			        , enabled
	 			        , accountNonExpired
	 			        , credentialsNonExpired
	 			        , accountNonLocked
	 			        , authorities
	 			        , memberEntity.getUserNm()
	 			        , memberEntity.getMemType()
	 			        , memberEntity.getShipperCd()
	 			        , memberEntity.getSalerCd()
					);
			  
		  }else {
			  
				  authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
				  
				  	// 조회한 정보를 userCustom에 담는다.
					// 만약 파라미터를 추가해야한다면 UserCustom 을 먼저 수정한다.
					userCustom = new UserCustom(memberEntity.getUserId()
					        , passwd
					        , enabled
					        , accountNonExpired
					        , credentialsNonExpired
					        , accountNonLocked
					        , authorities
					        , memberEntity.getUserNm()
					        , memberEntity.getMemType()
					        , memberEntity.getShipperCd()
					        , memberEntity.getSalerCd()
					); 
			  
				 
			 					
		  }
				  
	  
	return userCustom;
		 
    }

    public boolean save(MemberModel model) {
		try {
			signUpMapper.insertMember(model);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}