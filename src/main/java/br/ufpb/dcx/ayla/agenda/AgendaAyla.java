package br.ufpb.dcx.ayla.agenda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla {

    private Map<String, Contato> contatos;

    public AgendaAyla() {
        this.contatos = new HashMap<>();
    }

    public void salvarDados() {
        GravadorDeDados gravador = new GravadorDeDados();
        gravador.salvarContatos(this.contatos);
    }

    public void recuperarDados() {
        GravadorDeDados gravador = new GravadorDeDados();
        this.contatos = gravador.recuperarContatos();
    }

    public boolean cadastraContato(String nome, int dia, int mes) {
        if (this.contatos.containsKey(nome)) {
            throw new ContatolnexistenteException();
        }
        Contato contato = new Contato(nome, dia, mes);
        this.contatos.put(nome, contato);
        return true;
    }

    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> aniversariantes = new HashMap<String, Contato>().values();
        for (Contato contato : this.contatos.values()) {
            if (contato.getDiaAniversario() == dia && contato.getMesAniversario() == mes) {
                aniversariantes.add(contato);
            }
        }
        return aniversariantes;
    }

    public boolean removeContato(String nome) {
        if (!this.contatos.containsKey(nome)) {
            throw new ContatolnexistenteException();
        }
        this.contatos.remove(nome);
        return true;
    }
}

class Contato {

    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.diaAniversario = dia;
        this.mesAniversario = mes;
    }

    public int getDiaAniversario() {
        return this.diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public int getMesAniversario() {
        return this.mesAniversario;
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
        return diaAniversario == contato.diaAniversario &&
                mesAniversario == contato.mesAniversario &&
                nome.equals(contato.nome);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nome, diaAniversario, mesAniversario);
    }
}

