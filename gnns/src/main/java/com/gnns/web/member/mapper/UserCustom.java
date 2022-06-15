package com.gnns.web.member.mapper;

import java.util.Collection;

import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok 사용
// Security 에서 사용되는 User 에서 파라미터를 추가함.
//@Data         // constructor 도중 에러가 발생하므로 사용하지 않음
@Getter @Setter @ToString
public class UserCustom extends User {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    // 유저의 정보를 더 추가하고 싶다면 이곳과, 아래의 생성자 파라미터를 조절해야 한다.
    /** 멤버이름 */
	public String userNm;
    /**구분*/
	public String memType;
    /**출하주코드*/
	public String shipperCd;	
	/**중도매인코드*/
	public String salerCd;
	

    public UserCustom(
    		String username
    		, String password
            , boolean enabled
            , boolean accountNonExpired
            , boolean credentialsNonExpired
            , boolean accountNonLocked
            , Collection authorities
            , String userNm
            , String memType
            , String shipperCd
            , String salerCd
            ) 
    {
    	
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userNm = userNm;
        this.memType = memType;
        this.shipperCd = shipperCd;
        this.salerCd = salerCd;
    }
}