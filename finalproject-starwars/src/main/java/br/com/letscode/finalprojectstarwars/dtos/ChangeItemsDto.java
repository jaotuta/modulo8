package br.com.letscode.finalprojectstarwars.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ChangeItemsDto {

    @NotNull
    private UUID id1;
    @NotNull
    private UUID id2;
    @NotNull
    private String item1;
    @NotNull
    private int qtdItem1;
    @NotNull
    private String item2;
    @NotNull
    private int qtdItem2;

}
