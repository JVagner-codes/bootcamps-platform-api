package com.bootcamps.api.bootcampsplatformapi.controller;

import com.bootcamps.api.bootcampsplatformapi.entity.Aluno;
import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import com.bootcamps.api.bootcampsplatformapi.exception.IdNaoEncontrado;
import com.bootcamps.api.bootcampsplatformapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoRestController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> buscarTodosOsAlunos() {
        return ResponseEntity.ok(alunoService.buscarTodosOsAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
        } catch (IdNaoEncontrado idNaoEncontrado) {
            idNaoEncontrado.getStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Aluno aluno) {
        alunoService.inserir(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            alunoService.atualizar(id, aluno);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IdNaoEncontrado idNaoEncontrado) {
            idNaoEncontrado.printStackTrace();
        }
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> adicionarBootcampParaAluno(@PathVariable Long id, @RequestBody Bootcamp bootcamp) {
        alunoService.adicionarBootcampParaAluno(id, bootcamp);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
