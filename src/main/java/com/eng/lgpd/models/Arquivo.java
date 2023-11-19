package com.eng.lgpd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doc_db")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
	@NotEmpty
    private String nome;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] dados;

    @Override
    public String toString() {
        return "Arquivo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
    
}
