package com.example.exemplo.controller;

import com.example.exemplo.model.Veiculo;
import com.example.exemplo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculoResponseEntity(@PathVariable String placa){
        Veiculo v = veiculoRepository.getVeiculo(placa);

        if (v != null){
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> getAllVeiculos(){
        List<Veiculo> v = veiculoRepository.getAllVeiculos();
        return ResponseEntity.ok(v);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo novoVeiculo){
        veiculoRepository.saveVeiculo(novoVeiculo);
    }
}
