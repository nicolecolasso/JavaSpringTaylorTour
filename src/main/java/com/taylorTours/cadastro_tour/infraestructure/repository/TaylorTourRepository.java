package com.taylorTours.cadastro_tour.infraestructure.repository;

import com.taylorTours.cadastro_tour.infraestructure.entitys.TaylorTour;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaylorTourRepository extends JpaRepository<TaylorTour,Integer> {

    Optional<TaylorTour> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
