package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFim = null;
    @ManyToMany
    private Set<Aluno> alunosInscritos;
    @ManyToMany
    private Set<Curso> cursos;
    @ManyToMany
    private Set<Mentoria> mentorias;

}
