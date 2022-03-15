package br.com.letscode.finalprojectstarwars.controllers;


import br.com.letscode.finalprojectstarwars.dtos.ChangeItemsDto;
import br.com.letscode.finalprojectstarwars.dtos.RebeldeDto;
import br.com.letscode.finalprojectstarwars.models.ChangeItems;
import br.com.letscode.finalprojectstarwars.models.Inventario;
import br.com.letscode.finalprojectstarwars.models.Rebelde;
import br.com.letscode.finalprojectstarwars.services.ExercitoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/starwars")
public class ExercitoController {

    final ExercitoServices exercitoServices;

    public ExercitoController(ExercitoServices exercitoServices) {
        this.exercitoServices = exercitoServices;
    }


    @PostMapping
    public ResponseEntity<Object> saveRebelde (@RequestBody @Valid RebeldeDto rebeldeDto){

        var rebelde = new Rebelde();
        BeanUtils.copyProperties(rebeldeDto, rebelde);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercitoServices.save(rebelde));
    }

    @GetMapping()
    public ResponseEntity<List<Rebelde>> getAllRebels() {
        return ResponseEntity.status(HttpStatus.OK).body(exercitoServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneRebel(@PathVariable(value = "id") UUID id) {
        Optional<Rebelde> rebeldeOptional = exercitoServices.findById(id);
        if (!rebeldeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rebelde não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(rebeldeOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRebel(@PathVariable(value = "id") UUID id) {
        Optional<Rebelde> rebeldeOptional = exercitoServices.findById(id);
        if (!rebeldeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rebelde não encontrado");
        }
        exercitoServices.delete(rebeldeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Rebelde excluido");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRebel(@PathVariable(value = "id") UUID id,
                                              @RequestBody@Valid RebeldeDto rebeldeDto){
        Optional<Rebelde> rebeldeOptional = exercitoServices.findById(id);
        if (!rebeldeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rebelde não encontrado");
        }
        var rebelde = new Rebelde();
        BeanUtils.copyProperties(rebeldeDto, rebelde);
        rebelde.setId(rebeldeOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(exercitoServices.save(rebelde));
    }

    @PutMapping("/changeitems")
    public ResponseEntity<Object> changeItems (@RequestBody ChangeItemsDto changeItemsDto){
        var changeItems = new ChangeItems();
        BeanUtils.copyProperties(changeItemsDto, changeItems);

        Optional<Rebelde> rebelde1Optional = exercitoServices.findById(changeItemsDto.getId1());
        Optional<Rebelde> rebelde2Optional = exercitoServices.findById(changeItemsDto.getId2());

        if (!rebelde1Optional.isPresent() || !rebelde2Optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rebelde(s) não encontrado(s)");
        }
        if (!exercitoServices.validTransaction(changeItems.getItem1(), changeItems.getItem2())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Troca não permitida");
        }

        return ResponseEntity.status(HttpStatus.OK).body(changeItems);
    }


}
