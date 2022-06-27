package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class ContaDev extends Conta implements Impressao, Manipulacao<ContaDev> {

    private static String tipo = "DEV";
    private String cpf;
    private String curriculo;

    public ContaDev(Usuario usuario, String cpf, String curriculo) {
        super(usuario);
        this.cpf = cpf;
        this.curriculo = curriculo;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        ContaDev.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    @Override
    public void adicionar(ContaDev objeto) {
        getListaContas().add(objeto);
    }

    @Override
    public void editar(Integer indice, ContaDev objeto) {
        ContaDev devProcurado = (ContaDev) getListaContas().get(indice);
        devProcurado.set(objeto.getTelefone());
        devProcurado.setStack(objeto.getStack());
        devProcurado.setEmail(objeto.getEmail());
    }

    public void editarCV(Integer indice, ContaDev objeto) {
        ContaDev devProcurado = (ContaDev) getListaDeUser().get(indice);
        if (objeto.cv == null) {
            devProcurado.cv = getCv();
        } else {
            devProcurado.setCv(objeto.getCv());
        }
    }

    @Override
    public void remover(Integer indice) {
        getListaDeUser().remove(indice.intValue());
    }

    @Override
    public void listar() {
        if (getListaDeUser().size() < 1){
            System.out.println("Nenhum cadastro encontrado");
            System.exit(0);
        }else {
            for (int i = 0; i < getListaDeUser().size(); i++) {
                System.out.println("id=" + i + " | " + getListaDeUser().get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Nome do Dev: " + getNome() + '\'' + " | " +
                "E-Mail: " + getEmail() + '\'' + " | " +
                "Telefone: " + getTelefone() + '\'' + " | " +
                "CPF: " + cpf + '\'' + " | " +
                "Stack: " + stack + '\'' + " | ";
    }

    @Override
    public void imprimir(Integer indice, Object objeto) {
        ContaDev devProcurado = (ContaDev) getListaDeUser().get(indice);
        System.out.println("\nSeu curriculo \n-----------------\n" + devProcurado.getCv()+"\n");
    }
}
