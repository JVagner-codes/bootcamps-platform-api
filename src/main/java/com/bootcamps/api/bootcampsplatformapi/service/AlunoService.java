package com.bootcamps.api.bootcampsplatformapi.service;

import com.bootcamps.api.bootcampsplatformapi.entity.Aluno;
import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import com.bootcamps.api.bootcampsplatformapi.exception.AlunoNaoEncontradoComEsseId;

public interface AlunoService {

    Iterable<Aluno> buscarTodosOsAlunos();

    Iterable<Bootcamp> buscarTodosOsBootcampsDoAlunoPorId(Long id) throws AlunoNaoEncontradoComEsseId;

    Aluno buscarAlunoPorId(Long id) throws AlunoNaoEncontradoComEsseId;

    void inserir(Aluno aluno);

    void atualizar(Long id, Aluno aluno) throws AlunoNaoEncontradoComEsseId;

    void adicionarBootcampParaAluno(Long id, Bootcamp bootcamp);

    void deletar(Long id);
}
