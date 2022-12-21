package meta.security.config.auth;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료가 되면 시큐리티 session을 만들어줍니다 (Security Context Holder)
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 됨.
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session => Authentication => UserDetails

import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import meta.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// 이렇게 UserDetails를 implements하면 Authentication안에 PrincipalDetails를 넣을 수 있음
@Getter
public class PrincipalDetails implements UserDetails {

	private User user; // 콤포지션

	public PrincipalDetails(User user) {
		this.user = user;
	}

	// 해당 유저의 권한을 return 해야함
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList();
		collect.add((GrantedAuthority) () -> user.getRole().getValue());
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
