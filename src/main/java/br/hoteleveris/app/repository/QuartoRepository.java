package br.hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long>{

}
