package com.gargeis.DesignPatterns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO")
    private Integer id;

    @Column(name="NOME")
    private String nome;

    @Column(name="IDADE")
    private Integer idade;

}
