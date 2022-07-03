package br.com.dbc.devland.model;

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
        return Arrays.stream(TemaPostagem.values()) //[VAGAS(1) , PROGRAMAS(2), PENSAMENTOS(3)]
                .filter(t -> t.getTema().equals(tema)) //[VAGAS(1)]
                .findFirst() //optional => VAGAS(1)
                .get();//VAGAS(1)
    }
}
