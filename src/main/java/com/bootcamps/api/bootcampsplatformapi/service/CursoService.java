package com.bootcamps.api.bootcampsplatformapi.service;

import com.bootcamps.api.bootcampsplatformapi.entity.Curso;

public interface CursoService {

    Iterable<Curso> buscarTodosOsCursos();

    Curso buscarPorId(Long id);

    void inserir(Curso curso);

    void atualizar(Long id, Curso curso);

    void deletar(Long id);
}
