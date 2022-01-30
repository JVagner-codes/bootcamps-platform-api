package com.bootcamps.api.bootcampsplatformapi.service.impl;

import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import com.bootcamps.api.bootcampsplatformapi.entity.Curso;
import com.bootcamps.api.bootcampsplatformapi.entity.Mentoria;
import com.bootcamps.api.bootcampsplatformapi.exception.IdNaoEncontrado;
import com.bootcamps.api.bootcampsplatformapi.repository.BootcampRepository;
import com.bootcamps.api.bootcampsplatformapi.service.BootcampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BootcampServiceImpl implements BootcampService {

    @Autowired
    private BootcampRepository bootcampRepository;

    @Override
    public Iterable<Bootcamp> buscarTodosOsBootcamps() {
        return bootcampRepository.findAll();
    }

    @Override
    public Bootcamp buscarPorId(Long id) throws IdNaoEncontrado {
        Optional<Bootcamp> bootcampOptional = bootcampRepository.findById(id);
        if (bootcampOptional.isPresent()) {
            return bootcampOptional.get();
        }
        throw new IdNaoEncontrado("Não foi encontrado um Bootcamp com esse ID: " + id);
    }

    @Override
    public void inserir(Bootcamp bootcamp) {
        salvarBootcamp(bootcamp);
    }

    @Override
    public void atualizar(Long id, Bootcamp bootcamp) {
        boolean existeComId = bootcampRepository.existsById(id);
        if (existeComId) {
            salvarBootcamp(bootcamp);
        }
    }

    @Override
    public void adicionarCurso(Long id, Curso curso) {
        Optional<Bootcamp> bootcampOptional = bootcampRepository.findById(id);
        bootcampOptional.ifPresent(bootcamp -> {
            bootcamp.getCursos().add(curso);
            bootcampRepository.save(bootcamp);
        });
    }

    @Override
    public void adicionarMentoria(Long id, Mentoria mentoria) {
        Optional<Bootcamp> bootcampOptional = bootcampRepository.findById(id);
        bootcampOptional.ifPresent(bootcamp -> {
            bootcamp.getMentorias().add(mentoria);
            bootcampRepository.save(bootcamp);
        });
    }

    @Override
    public void deletar(Long id) {
        bootcampRepository.deleteById(id);
    }

    private void salvarBootcamp(Bootcamp bootcamp) {
        bootcampRepository.save(bootcamp);
    }
}
