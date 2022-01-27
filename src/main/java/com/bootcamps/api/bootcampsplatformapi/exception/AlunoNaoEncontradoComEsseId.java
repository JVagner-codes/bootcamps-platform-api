package com.bootcamps.api.bootcampsplatformapi.exception;

import java.io.IOException;

public class AlunoNaoEncontradoComEsseId extends IOException {

    public AlunoNaoEncontradoComEsseId(String mensagem) {
        super(mensagem);
    }
}
