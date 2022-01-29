package com.bootcamps.api.bootcampsplatformapi.service.impl;

import com.bootcamps.api.bootcampsplatformapi.entity.Aluno;
import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import com.bootcamps.api.bootcampsplatformapi.entity.Endereco;
import com.bootcamps.api.bootcampsplatformapi.exception.AlunoNaoEncontradoComEsseId;
import com.bootcamps.api.bootcampsplatformapi.repository.AlunoRepository;
import com.bootcamps.api.bootcampsplatformapi.repository.BootcampRepository;
import com.bootcamps.api.bootcampsplatformapi.repository.EnderecoRepository;
import com.bootcamps.api.bootcampsplatformapi.service.AlunoService;
import com.bootcamps.api.bootcampsplatformapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private BootcampRepository bootcampRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Aluno> buscarTodosOsAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Iterable<Bootcamp> buscarTodosOsBootcampsDoAlunoPorId(Long id) throws AlunoNaoEncontradoComEsseId {
        Aluno aluno = buscarAlunoPorId(id);
        return aluno.getBootcampEscritos();
    }

    @Override
    public Aluno buscarAlunoPorId(Long id) throws AlunoNaoEncontradoComEsseId {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            return optionalAluno.get();
        }
        throw new AlunoNaoEncontradoComEsseId("Não existe Aluno com esse Id: " + id);
    }

    @Override
    public void inserir(Aluno aluno) {
        salvarAlunoComCep(aluno);
    }

    @Override
    public void atualizar(Long id, Aluno aluno) throws AlunoNaoEncontradoComEsseId {
        Optional<Aluno> clienteBD = alunoRepository.findById(id);
        if (clienteBD.isPresent()) {
            salvarAlunoComCep(aluno);
        } else {
            throw new AlunoNaoEncontradoComEsseId("Não existe Aluno com esse Id: " + id);
        }
    }

    @Override
    public void adicionarBootcampParaAluno(Long id, Bootcamp bootcamp) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        boolean existeBootcamp = bootcampRepository.existsById(bootcamp.getId());
        if (alunoOptional.isPresent() && existeBootcamp) {
            Aluno alunoEncontrado = alunoOptional.get();
            alunoEncontrado.getBootcampEscritos().add(bootcamp);
            bootcamp.getAlunosInscritos().add(alunoEncontrado);
            alunoRepository.save(alunoEncontrado);
            bootcampRepository.save(bootcamp);
        }
    }

    @Override
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    private void salvarAlunoComCep (Aluno aluno) {
        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        aluno.setEndereco(endereco);
        alunoRepository.save(aluno);
    }
}
