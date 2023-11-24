package com.eng.lgpd.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.eng.lgpd.dtos.ClientDTO;
import com.eng.lgpd.enums.Profiles;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_db")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String phone;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CLIENT_PERFIS")
	protected Set<Integer> profiles = new HashSet<>();
	
	public Client() {

	}
	
	public Client(ClientDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.phone = dto.getPhone();
	}

	public Client(Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty String email,
			@NotNull @NotEmpty String password, @NotNull @NotEmpty String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public Set<Profiles> getProfiles() {
		return profiles.stream().map(x -> Profiles.valueOf(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Profiles perfis) {
		this.profiles.add(perfis.getCode());
	}

}
