package com.example.exemplo.controller;

import com.example.exemplo.dto.VeiculoDTO;
import com.example.exemplo.model.Veiculo;
import com.example.exemplo.repository.VeiculoRepository;
import com.example.exemplo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private VeiculoService veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDTO> getVeiculoResponseEntity(@PathVariable String placa){
            return ResponseEntity.ok().body(veiculoService.getVeiculo(placa));
    }

    @GetMapping("/allorder")
    public ResponseEntity<List<VeiculoDTO>> getAllOrderByValor(){
        List<VeiculoDTO> v = veiculoService.getAllOrderByValor();
        return ResponseEntity.ok(v);
    }

    @GetMapping("/bymodel/{modelo}")
    public ResponseEntity<List<VeiculoDTO>> getAllByModel(@PathVariable String modelo){
        List<VeiculoDTO> v = veiculoService.getByModel(modelo);
        return ResponseEntity.ok(v);
    }

    @GetMapping("/allbymodel")
    public ResponseEntity<List<VeiculoDTO>> getAllOrderByModel(){
        List<VeiculoDTO> v = veiculoService.getAllOrderByModel();
        return ResponseEntity.ok(v);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VeiculoDTO>> getAllVeiculos(){
        List<VeiculoDTO> v = veiculoService.getAllVeiculos();
        return ResponseEntity.ok(v);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo novoVeiculo){
        veiculoService.saveVeiculo(novoVeiculo);
    }
}
