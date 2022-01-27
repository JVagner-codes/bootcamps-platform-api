package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFim;
    @OneToMany
    private Aluno alunosInscritos;
    @OneToMany
    private Conteudo conteudos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFim, bootcamp.dataFim) && Objects.equals(alunosInscritos, bootcamp.alunosInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataInicial, dataFim, alunosInscritos, conteudos);
    }
}
