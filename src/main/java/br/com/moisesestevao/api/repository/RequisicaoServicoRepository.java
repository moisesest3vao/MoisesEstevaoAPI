package br.com.moisesestevao.api.repository;

import br.com.moisesestevao.api.model.RequisicaoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoServicoRepository extends JpaRepository<RequisicaoServico, Long> {
}
