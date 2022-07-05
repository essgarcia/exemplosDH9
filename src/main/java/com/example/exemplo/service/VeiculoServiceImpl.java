package com.example.exemplo.service;

import com.example.exemplo.dto.VeiculoDTO;
import com.example.exemplo.model.Veiculo;
import com.example.exemplo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService{
    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDTO getVeiculo(String placa){
        VeiculoDTO veiculoDTO = new VeiculoDTO(veiculoRepository.getVeiculo(placa));
        return veiculoDTO;
    }

    @Override
    public List<VeiculoDTO> getAllVeiculos() {
        List<Veiculo> listVeiculos = veiculoRepository.getAllVeiculos();
        List<VeiculoDTO> listVeiculosDTO = listVeiculos.stream()
                .map(VeiculoDTO::new).collect(Collectors.toList());
        return listVeiculosDTO;
    }

    @Override
    public void saveVeiculo(Veiculo veiculo) {
        veiculoRepository.saveVeiculo(veiculo);
    }

    public List<VeiculoDTO> getAllOrderByValor(){
        List<Veiculo> list = veiculoRepository.getAllVeiculos();
        return list.stream()
                .sorted()
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
    }

    public List<VeiculoDTO> getAllOrderByModel(){
        List<Veiculo> list = veiculoRepository.getAllVeiculos();
        return list.stream()
                .sorted((v1, v2) -> v1.getModelo().compareTo(v2.getModelo()))
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> getByModel(String modelo) {
        List<Veiculo> list = veiculoRepository.getAllVeiculos();
        return list.stream()
                .filter(v -> v.getModelo().equals(modelo))
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
    }
}
