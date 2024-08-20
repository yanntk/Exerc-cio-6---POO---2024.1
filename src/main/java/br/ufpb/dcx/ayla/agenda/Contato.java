package br.ufpb.dcx.ayla.agenda;

import java.util.Objects;

public class Contato {
    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int diaAniversario, int mesAniversario) {
        this.nome = nome;
        this.diaAniversario = diaAniversario;
        this.mesAniversario = mesAniversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public int getMesAniversario() {
        return mesAniversario;
    }

    public void setMesAniversario(int mesAniversario) {
        this.mesAniversario = mesAniversario;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", diaAniversario=" + diaAniversario +
                ", mesAniversario=" + mesAniversario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return diaAniversario == contato.diaAniversario && mesAniversario == contato.mesAniversario && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, diaAniversario, mesAniversario);
    }
}

