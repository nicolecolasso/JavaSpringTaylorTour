package com.taylorTours.cadastro_tour.business;

import com.taylorTours.cadastro_tour.infraestructure.entitys.TaylorTour;
import com.taylorTours.cadastro_tour.infraestructure.repository.TaylorTourRepository;
import org.springframework.stereotype.Service;

@Service
public class TaylorTourService {
    private final TaylorTourRepository repository;

    public TaylorTourService(TaylorTourRepository repository) {
        this.repository = repository;
    }

    public void salvarTour(TaylorTour tour){
        repository.saveAndFlush(tour);
    }

    public TaylorTour buscarTourPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado!")
        );
    }
}
