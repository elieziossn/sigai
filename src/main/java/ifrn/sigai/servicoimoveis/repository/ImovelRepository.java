package ifrn.sigai.servicoimoveis.repository;

import ifrn.sigai.servicoimoveis.model.Imovel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

}
