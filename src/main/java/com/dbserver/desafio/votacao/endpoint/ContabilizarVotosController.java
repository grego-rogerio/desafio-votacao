package com.dbserver.desafio.votacao.endpoint;

import com.dbserver.desafio.votacao.endpoint.constant.EndpointURL;
import com.dbserver.desafio.votacao.endpoint.dto.PautaIdDTO;
import com.dbserver.desafio.votacao.endpoint.dto.VotosPautaDTO;
import com.dbserver.desafio.votacao.endpoint.mapper.VotosPautaParaVotosPautaDTOMapper;
import com.dbserver.desafio.votacao.endpoint.swagger.ContabilizarVotosControllerSwagger;
import com.dbserver.desafio.votacao.usecase.domain.VotosPauta;
import com.dbserver.desafio.votacao.usecase.assembleia.ContabilizarVotosUsecase;
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
public class ContabilizarVotosController implements ContabilizarVotosControllerSwagger {

    private final ContabilizarVotosUsecase contabilizarVotosUsecase;

    @PostMapping(value = EndpointURL.CONTABILIZAR_VOTOS_URL)
    public ResponseEntity<VotosPautaDTO> contabilizarVotos(@Valid @RequestBody PautaIdDTO PautaIdDTO) {

        log.info("[ContabilizarVotosController] Inicio da Contabilização dos Votos da Pauta, IdPauta: " + PautaIdDTO.getIdPauta());

        VotosPauta votosPautaResultado = contabilizarVotosUsecase.execute(PautaIdDTO.getIdPauta());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(VotosPautaParaVotosPautaDTOMapper.INSTANCE.map(votosPautaResultado));
    }
}
