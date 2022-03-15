package br.com.letscode.finalprojectstarwars.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_REBEL")
public class Rebelde implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private String position;
    @Column
    private Boolean traidor;
    @Column(nullable = false)
    private int arma;
    @Column(nullable = false)
    private int municao;
    @Column(nullable = false)
    private int agua;
    @Column(nullable = false)
    private int comida;

    public int getInvPoints() {
        return arma*4 + municao*3 + agua*2 + comida;
    }



}
