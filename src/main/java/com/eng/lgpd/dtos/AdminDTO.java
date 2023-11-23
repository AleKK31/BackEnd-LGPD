package com.eng.lgpd.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.eng.lgpd.enums.Profiles;
import com.eng.lgpd.models.Admin;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull(message = "O campo NOME esta vazio")
	private String name;
	@NotNull(message = "O campo EMAIL esta vazio")
	private String email;
	@NotNull(message = "O campo SENHA esta vazio")
	private String password;
	@NotNull
	private String phone;
	@NotNull
	protected Set<Integer> profiles = new HashSet<>();
	
	public AdminDTO() {
		super();
		addPerfis(Profiles.ADMIN);
	}
	
	public AdminDTO(Admin admin) {
		super();
		this.id = admin.getId();
		this.name = admin.getName();
		this.email = admin.getEmail();
		this.password = admin.getPassword();
		this.phone = admin.getPhone();
		addPerfis(Profiles.ADMIN);
	}
	
	
	public Set<Profiles> getProfiles() {
		return profiles.stream().map(x -> Profiles.valueOf(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Profiles perfis) {
		this.profiles.add(perfis.getCode());
	}

}
