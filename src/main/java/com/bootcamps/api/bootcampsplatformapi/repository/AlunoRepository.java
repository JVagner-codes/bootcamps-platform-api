package com.bootcamps.api.bootcampsplatformapi.repository;

import com.bootcamps.api.bootcampsplatformapi.entity.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}
