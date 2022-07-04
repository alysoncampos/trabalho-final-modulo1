package br.com.dbc.devland.model;

import java.util.Arrays;

public enum TipoEnum {
    RESIDENCIAL(1), COMERCIAL(2);

    private int tipo;

    TipoEnum(int tipo){
        this.tipo = tipo;
    }

    public Integer getTipo(){
        return this.tipo;
    }

    public static TipoEnum ofTipo(Integer tipo){
        return Arrays.stream(TipoEnum.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
