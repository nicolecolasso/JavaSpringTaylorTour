package com.taylorTours.cadastro_tour.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "taylor_tour")
@Entity

public class TaylorTour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome_tour", unique = true, length = 100, nullable = false)
    private String nome;

    @Column(name = "album_base", length = 200, nullable = false)
    private String albumBase;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "quantidade_shows")
    private Integer quantidadeShows;

    @Column(name = "faturamento_estimado")
    private Double faturamentoEstimado;
}
