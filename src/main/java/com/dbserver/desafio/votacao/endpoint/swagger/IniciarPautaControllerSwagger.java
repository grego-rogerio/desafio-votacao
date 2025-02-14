package com.dbserver.desafio.votacao.endpoint.swagger;

import com.dbserver.desafio.votacao.endpoint.dto.PautaDuracaoDTO;
import com.dbserver.desafio.votacao.endpoint.dto.PautaSessaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IniciarPautaControllerSwagger {

    @Operation(summary = "Iniciar uma Pauta")
    ResponseEntity<PautaSessaoDTO> iniciarPauta(@RequestBody PautaDuracaoDTO pautaDuracaoDTO);
}
