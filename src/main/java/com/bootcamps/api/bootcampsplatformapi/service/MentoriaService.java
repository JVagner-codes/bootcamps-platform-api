package com.bootcamps.api.bootcampsplatformapi.service;

import com.bootcamps.api.bootcampsplatformapi.entity.Mentoria;

public interface MentoriaService {

    Iterable<Mentoria> buscarTodosAsMentorias();

    Mentoria buscarPorId(Long id);

    void inserir(Mentoria mentoria);

    void atualizar(Long id, Mentoria mentoria);

    void deletar(Long id);
}
