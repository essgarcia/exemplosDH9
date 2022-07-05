package com.example.exemplo.dto;

import com.example.exemplo.model.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoDTO {
    private String placa;
    private String modelo;
    private double preco;

    public VeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.preco = veiculo.getPreco();
    }
}
