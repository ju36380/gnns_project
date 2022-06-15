package com.gnns.web.member.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.adminlogin.mapper.AdminLoginMapper;
import com.gnns.web.adminlogin.model.AdminLoginModel;
import com.gnns.web.login.mapper.LoginMapper;
import com.gnns.web.login.model.MemberModel;
import com.gnns.web.member.mapper.SignUpMapper;
import com.gnns.web.member.mapper.UserCustom;
import com.gnns.web.notice.model.NoticeModel;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	private SignUpMapper signUpMapper;
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private AdminLoginMapper adminLoginMapper; // (준혁) 21-10-21
	
	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private boolean accountNonLocked = true;
	
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	    	
    	BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
    	AdminLoginModel aModel = new AdminLoginModel(); // (준혁) 21-10-21
    	UserCustom userCustom = null;
    	String passwd = null;
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
 
	    
		  aModel.setUserid(userId);
		  Optional<AdminLoginModel> adminEntityWrapper = adminLoginMapper.adminId(aModel); 

		  AdminLoginModel adminEntity = adminEntityWrapper.orElse(null);
		  
		  if(adminEntity != null) {
			  passwd = bcryptPasswordEncoder.encode(adminEntity.getPwd().trim());
			  
			  authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			  authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER_CHUL"));
			  authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER_JUNG"));
			  
			  userCustom = new UserCustom(adminEntity.getUserid()
				        , passwd
				        , enabled
				        , accountNonExpired
				        , credentialsNonExpired
				        , accountNonLocked
				        , authorities
				        , adminEntity.getUserid()
				        , "admin"
				        , ""
				        , ""
					);
			}else {
				
				authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
				
				userCustom = new UserCustom(adminEntity.getUserid()
				        , passwd
				        , enabled
				        , accountNonExpired
				        , credentialsNonExpired
				        , accountNonLocked
				        , authorities
				        , adminEntity.getUserid()
				        , ""
				        , ""
				        , ""
					);
				
			}
		  
	return userCustom;
		 
    }

    

	
}