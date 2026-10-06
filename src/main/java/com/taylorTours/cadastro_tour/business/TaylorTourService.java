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

    public void deletarTourPorNome(String nome){
        repository.deleteByNome(nome);
    }

    public void atualizarTourPorId(Integer id, TaylorTour tour){
        TaylorTour tourEntity = repository.findById(id).orElseThrow(() ->
            new RuntimeException("Turnê não encontrada"));
        TaylorTour tourAtualizada = TaylorTour.builder()
                .nome(tour.getNome() != null ? tour.getNome() :
                    tourEntity.getNome())
                .albumBase(tour.getAlbumBase() != null ? tour.getAlbumBase() :
                    tourEntity.getAlbumBase())
                .dataInicio(tour.getDataInicio() != null ? tour.getDataInicio() :
                        tourEntity.getDataInicio())
                .quantidadeShows(tour.getQuantidadeShows() != null ? tour.getQuantidadeShows() :
                        tourEntity.getQuantidadeShows())
                .faturamentoEstimado(tour.getFaturamentoEstimado() != null ? tour.getFaturamentoEstimado() :
                        tourEntity.getFaturamentoEstimado())
                .id(tourEntity.getId())
                .build();
        repository.saveAndFlush(tourAtualizada);
    }


}
