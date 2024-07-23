package com.itwill.springboot3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Getter @ToString @EqualsAndHashCode
@Entity @Table(name = "locations")
public class Location {
	
	@Id @Column(name = "location_id")
	private Integer id;

	private String city;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
//	private Character countryId;
	
	private String postalCode;
	
	@Column(name = "STATE_PROVINCE")
	private String state;
	
	@Column(name = "STREET_ADDRESS")
	private String street;
	
}
