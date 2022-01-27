package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;
    @OneToMany
    private Bootcamp bootcampEscritos;

}
