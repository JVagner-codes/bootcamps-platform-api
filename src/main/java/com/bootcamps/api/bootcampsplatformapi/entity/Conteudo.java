package com.bootcamps.api.bootcampsplatformapi.entity;

import lombok.Data;

@Data
public abstract class Conteudo {

    private String titulo;
    private String descricao;
    private Double xpAGanhar;

    public abstract Double calculaXp();
}
