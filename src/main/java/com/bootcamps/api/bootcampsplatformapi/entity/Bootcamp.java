package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFim;
    @ManyToMany
    private Set<Aluno> alunosInscritos;
    @ManyToMany
    private Set<Curso> cursos;
    @ManyToMany
    private Set<Mentoria> mentorias;

}
