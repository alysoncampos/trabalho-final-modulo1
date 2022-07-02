package br.com.dbc.devland.main.model;

import java.util.Arrays;

public enum TemaPostagem {
    VAGAS(1),
    PROGRAMAS(2),
    PENSAMENTOS(3);

    private Integer tema;

    TemaPostagem(Integer tema) {
        this.tema = tema;
    }

    public Integer getTema() {
        return tema;
    }

    public static TemaPostagem ofTema(Integer tema){ // 1
        return Arrays.stream(TemaPostagem.values()) //[RESIDENCIAL(1) , COMERCIAL(2)]
                .filter(t -> t.getTema().equals(tema)) //[RESIDENCIAL(1)]
                .findFirst() //optional => RESIDENCIAL(1)
                .get();//RESIDENCIAL(1)
    }
}
