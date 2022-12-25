package security_jwt.demo.model;

import lombok.Getter;

@Getter
public enum Role {
	USER("ROLE_USER"),
	MANAGER("ROLE_MANAGER"),
	ADMIN("ROLE_ADMIN"),
	;

	private String role;

	Role(String role) {
		this.role = role;
	}
}
