package com.taylorTours.cadastro_tour.controller;

import com.taylorTours.cadastro_tour.business.TaylorTourService;
import com.taylorTours.cadastro_tour.infraestructure.entitys.TaylorTour;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TaylorTourController {
    private final TaylorTourService tourService;

    @PostMapping
    public ResponseEntity<Void> salvarTour(@RequestBody TaylorTour tour){
        tourService.salvarTour(tour);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<TaylorTour> buscarTourPorNome(@RequestParam String nome){
        return ResponseEntity.ok(tourService.buscarTourPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTourPorNome(@RequestParam String nome){
        tourService.deletarTourPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarTourPorId(@RequestBody TaylorTour tour, @RequestParam Integer id){
        tourService.atualizarTourPorId(id, tour);
        return ResponseEntity.ok().build();
    }
}
