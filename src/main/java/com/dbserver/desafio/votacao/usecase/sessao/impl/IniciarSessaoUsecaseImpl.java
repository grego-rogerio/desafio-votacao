package com.dbserver.desafio.votacao.usecase.sessao.impl;

import com.dbserver.desafio.votacao.usecase.domain.Sessao;
import com.dbserver.desafio.votacao.usecase.sessao.IniciarSessaoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IniciarSessaoUsecaseImpl implements IniciarSessaoUsecase {

    private static final Integer DURACAO_EM_MINUTO = 1;

    private final Clock clock;

    public Sessao execute(Integer duracao) {

        if (duracao == null) {
            duracao = DURACAO_EM_MINUTO;
        }

        return Sessao
                .builder()
                .inicio(LocalDateTime.now(clock))
                .duracao(duracao)
                .build();
    }
}
