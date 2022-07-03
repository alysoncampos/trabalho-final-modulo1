package br.com.dbc.devland.repository;

public interface Manipulacao<TIPO> {
    void adicionar(TIPO objeto);
    void editar(Integer indice, TIPO objeto);
    void remover(Integer indice);
    void listar();
}
