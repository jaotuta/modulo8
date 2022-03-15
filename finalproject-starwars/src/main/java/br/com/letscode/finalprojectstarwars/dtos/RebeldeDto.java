package br.com.letscode.finalprojectstarwars.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RebeldeDto {

    @NotBlank
    private String name;
    @NotBlank
    private String age;
    @NotBlank
    private String genre;
    @NotBlank
    private String position;
    private Boolean traidor;
    @NotNull
    private int arma;
    @NotNull
    private int municao;
    @NotNull
    private int agua;
    @NotNull
    private int comida;



}
