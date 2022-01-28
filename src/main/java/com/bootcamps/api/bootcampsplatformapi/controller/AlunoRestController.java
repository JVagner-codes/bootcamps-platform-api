package com.bootcamps.api.bootcampsplatformapi.controller;

import com.bootcamps.api.bootcampsplatformapi.entity.Aluno;
import com.bootcamps.api.bootcampsplatformapi.exception.AlunoNaoEncontradoComEsseId;
import com.bootcamps.api.bootcampsplatformapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
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
        } catch (AlunoNaoEncontradoComEsseId alunoNaoEncontradoComEsseId) {
            alunoNaoEncontradoComEsseId.getStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Aluno aluno) {
        alunoService.inserir(aluno);
        return ResponseEntity.ok().build();
    }

    @PutMapping({"/{idBootcamp}"})
    public ResponseEntity<Aluno> adicionarBootcampParaAluno(@PathVariable Long idBootcamp, @RequestBody Aluno aluno) {
        alunoService.adicionarBootcampParaAluno(idBootcamp, aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
