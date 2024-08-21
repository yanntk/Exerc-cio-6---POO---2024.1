package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaAylaTest {

    @Test
    void testCadastraPesquisaERemoveContato() {
        AgendaAyla agenda = new AgendaAyla();
        assertTrue(agenda.cadastraContato("João", 10, 12));
        assertTrue(agenda.pesquisaAniversariantes(10, 12).contains(new Contato("João", 10, 12)));
        assertTrue(agenda.removeContato("João"));
        assertFalse(agenda.pesquisaAniversariantes(10, 12).contains(new Contato("João", 10, 12)));
    }
}