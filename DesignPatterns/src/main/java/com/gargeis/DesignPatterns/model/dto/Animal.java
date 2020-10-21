package com.gargeis.DesignPatterns.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Animal {
    private String nome;
    private Integer idade;
    private Caracteristica caracteristica;

}
