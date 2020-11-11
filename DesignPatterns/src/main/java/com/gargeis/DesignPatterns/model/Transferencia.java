package com.gargeis.DesignPatterns.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // BUILDER PATTERN
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime datahora;

    @ManyToOne
    private Conta fonte;

    @ManyToOne
    private Conta destino;

    private BigDecimal valor;

}
