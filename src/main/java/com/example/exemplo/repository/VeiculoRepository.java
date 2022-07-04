package com.example.exemplo.repository;

import com.example.exemplo.model.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VeiculoRepository {

    private final String linkFile = "src/main/resource/dados.json";

    public Veiculo getVeiculo(String placa) {
        ObjectMapper map = new ObjectMapper();
        List<Veiculo> lista = null;
        try {
            lista = Arrays.asList
                    (map.readValue(new File(linkFile), Veiculo[].class));

            for (Veiculo v : lista){
                if (v.getPlaca().equals(placa)){
                    return v;
                }
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public List<Veiculo> getAllVeiculos() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Veiculo> listaVeic = null;
        try {
            listaVeic = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));

        } catch (Exception ex) {

        }
        return listaVeic;
    }
        public void saveVeiculo (Veiculo novoVeiculo){
            ObjectMapper map = new ObjectMapper();
            List<Veiculo> listaAtual = null;
            try {
                listaAtual = Arrays.asList
                        (map.readValue(new File(linkFile), Veiculo[].class));

                List<Veiculo> listaCopia = new ArrayList<>(listaAtual);
                listaAtual.add(novoVeiculo);
                map.writeValue(new File(linkFile), Veiculo[].class);
            } catch (Exception ex) {
                System.out.println("Erro");
            }
        }
}
