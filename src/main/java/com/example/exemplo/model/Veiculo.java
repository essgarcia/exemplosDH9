package com.example.exemplo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Comparable<Veiculo>{
    private String placa;
    private String modelo;
    private String renavam;
    private double preco;

    @Override
    public int compareTo(Veiculo o) {
        if(this.preco > o.getPreco()){
            return 1;
        }if(this.preco < o.getPreco()) {
            return -1;
        }
        return 0;
    }
}
