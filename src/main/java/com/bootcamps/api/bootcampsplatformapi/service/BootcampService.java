package com.bootcamps.api.bootcampsplatformapi.service;

import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import com.bootcamps.api.bootcampsplatformapi.entity.Curso;
import com.bootcamps.api.bootcampsplatformapi.entity.Mentoria;
import com.bootcamps.api.bootcampsplatformapi.exception.IdNaoEncontrado;

public interface BootcampService {

    Iterable<Bootcamp> buscarTodosOsBootcamps();

    Bootcamp buscarPorId(Long id) throws IdNaoEncontrado;

    void inserir(Bootcamp bootcamp);

    void atualizar(Long id, Bootcamp bootcamp);

    void adicionarCurso(Long id, Curso curso);

    void adicionarMentoria(Long id, Mentoria mentoria);

    void deletar(Long id);
}
