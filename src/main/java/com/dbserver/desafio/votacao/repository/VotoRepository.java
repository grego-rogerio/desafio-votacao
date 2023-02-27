package com.dbserver.desafio.votacao.repository;

import com.dbserver.desafio.votacao.repository.entity.VotoEntity;
import com.dbserver.desafio.votacao.usecase.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Integer> {
    List<VotoEntity> findByCpfAssociado(String cpfAssociado);
}
