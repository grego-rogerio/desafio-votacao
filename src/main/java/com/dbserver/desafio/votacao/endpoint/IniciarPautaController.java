package com.dbserver.desafio.votacao.endpoint;

import com.dbserver.desafio.votacao.endpoint.constant.EndpointURL;
import com.dbserver.desafio.votacao.endpoint.swagger.IniciarPautaControllerSwagger;
import com.dbserver.desafio.votacao.usecase.domain.Pauta;
import com.dbserver.desafio.votacao.usecase.pauta.IniciarPautaUsecase;
import com.dbserver.desafio.votacao.endpoint.dto.PautaDuracaoDTO;
import com.dbserver.desafio.votacao.endpoint.dto.PautaSessaoDTO;
import com.dbserver.desafio.votacao.endpoint.mapper.PautaParaPautaSessaoDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class IniciarPautaController implements IniciarPautaControllerSwagger {

    private final IniciarPautaUsecase iniciarPautaUsecase;

    @PostMapping(value = EndpointURL.INICIAR_PAUTA_URL)
    public ResponseEntity<PautaSessaoDTO> iniciarPauta(@Valid @RequestBody PautaDuracaoDTO pautaDuracaoDTO) {

        log.info("[IniciarPautaController] Inicio da abertura da Pauta, IdPauta: " + pautaDuracaoDTO.getIdPauta());

        Pauta pautaIniciada = iniciarPautaUsecase.execute(
                                                    pautaDuracaoDTO.getIdPauta(),
                                                    pautaDuracaoDTO.getDuracaoSessao());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PautaParaPautaSessaoDtoMapper.INSTANCE.map(pautaIniciada));
    }
}
