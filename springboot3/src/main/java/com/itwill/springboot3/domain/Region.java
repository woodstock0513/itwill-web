package com.itwill.springboot3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString @Getter @EqualsAndHashCode @NoArgsConstructor
@Entity @Table(name = "regions")
public class Region {
	
	@Id @Column(name = "region_id")
	private Integer id;
	
	private String regionName;
	

}
