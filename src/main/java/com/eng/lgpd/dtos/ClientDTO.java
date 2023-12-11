package com.eng.lgpd.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.eng.lgpd.enums.Profiles;
import com.eng.lgpd.models.Client;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDTO implements Serializable {

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
    protected Set<String> profiles = new HashSet<>();  // Alteração aqui

    public ClientDTO() {
        super();
        addPerfis(Profiles.CLIENT);
    }

    public ClientDTO(Client cliente) {
        super();
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.email = cliente.getEmail();
        this.password = cliente.getPassword();
        this.phone = cliente.getPhone();
        addPerfis(Profiles.CLIENT);
    }

    public Set<Profiles> getProfiles() {
        return profiles.stream().map(x -> Profiles.valueOf(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Profiles perfis) {
        this.profiles.add(perfis.name());  // Alteração aqui
    }
}
