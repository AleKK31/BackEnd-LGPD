package com.eng.lgpd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "respostas_db")
public class Respostas{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String resposta1;

    @NotNull
    @NotEmpty
    private String resposta2;

    @NotNull
    @NotEmpty
    private String resposta3;

    @NotNull
    @NotEmpty
    private String resposta4;

    @NotNull
    @NotEmpty
    private String resposta5;

    @NotNull
    @NotEmpty
    private String resposta6;

    @NotNull
    @NotEmpty
    private String resposta7;

    @NotNull
    @NotEmpty
    private String resposta8;

    @NotNull
    @NotEmpty
    private String resposta9;

    @NotNull
    @NotEmpty
    private String resposta10;
}