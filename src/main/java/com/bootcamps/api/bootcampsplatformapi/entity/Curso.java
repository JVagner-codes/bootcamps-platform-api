package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Curso extends Conteudo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cargaHoraria;

    @Override
    public Double calculaXp() {
        return getXpAGanhar() + 200;
    }
}
