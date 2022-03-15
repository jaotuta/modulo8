package br.com.letscode.finalprojectstarwars.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ChangeItems {

    private UUID id1;
    private UUID id2;
    private String item1;
    private int qtdItem1;
    private String item2;
    private int qtdItem2;

}
