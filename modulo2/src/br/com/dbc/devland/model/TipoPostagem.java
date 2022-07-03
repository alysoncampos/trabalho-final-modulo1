package br.com.dbc.devland.main.model;

import java.util.Arrays;

public enum TipoPostagem {
    VAGAS(1),
    PROGRAMAS(2),
    PENSAMENTOS(3);

    private Integer tipo;

    TipoPostagem(Integer tipo) {
            this.tipo = tipo;
        }

    public Integer getTipo() {
            return tipo;
        }

    public static br.com.dbc.devland.main.model.TipoPostagem ofTema(Integer tipo){ // 1
        return Arrays.stream(br.com.dbc.devland.main.model.TipoPostagem.values()) //[VAGAS(1) , PROGRAMAS(2), PENSAMENTOS(3)]
                .filter(t -> t.getTipo().equals(tipo)) //[VAGAS(1)]
                .findFirst() //optional => VAGAS(1)
                .get();//VAGAS(1)
    }
}
