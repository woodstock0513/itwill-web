package com.itwill.springboot5.domain;

public enum MemberRole {
	USER("ROLE_USER"),  //public static final MemberRole USER  = new MemberRole("ROLE_USER");랑 같음
	ADMIN("ROLE_ADMIN");
	
	private String authority;
	
	//주의:enum의 생성자는 항상 private. private 수식어는 생략!
	MemberRole(String authority){
		this.authority = authority;
	}
	
	public String getAuthority() {
		return this.authority;
	}

}
