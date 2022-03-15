package br.com.letscode.finalprojectstarwars.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
public class Inventario {

    @Column(nullable = false)
    private int arma;
    @Column(nullable = false)
    private int municao;
    @Column(nullable = false)
    private int agua;
    @Column(nullable = false)
    private int comida;

}
