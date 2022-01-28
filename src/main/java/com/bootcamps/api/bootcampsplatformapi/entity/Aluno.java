package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;
    @ManyToMany
    private Set<Bootcamp> bootcampEscritos;

}
