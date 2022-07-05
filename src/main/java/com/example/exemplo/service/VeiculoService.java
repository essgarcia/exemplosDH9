package com.example.exemplo.service;

import com.example.exemplo.dto.VeiculoDTO;
import com.example.exemplo.model.Veiculo;
import java.util.List;

public interface VeiculoService {

    VeiculoDTO getVeiculo(String placa);

    List<VeiculoDTO> getAllVeiculos();

    void saveVeiculo(Veiculo veiculo);

    List<VeiculoDTO> getAllOrderByValor();

    List<VeiculoDTO> getAllOrderByModel();
    List<VeiculoDTO> getByModel(String modelo);
}
