package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class GravadorDeDadosTest {


    @Test
    void testarGravacao() throws IOException {
        File arquivoContatos = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if (arquivoContatos.exists()){
            arquivoContatos.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse (arquivo.exists());
        HashMap<String, Contato> contatosMap = new HashMap<>();
        contatosMap.put("Ayla", new Contato("Ayla", 5, 18));
        contatosMap = new HashMap<>();
        gravadorDeDados.salvarContatos (contatosMap);
        assertTrue(arquivo.exists());
        HashMap<String, Contato> contatosRecuperados = gravadorDeDados.recuperarContatos();
        Contato c1 = contatosRecuperados.get("Ayla");
        assertEquals( 5, c1.getDiaAniversario());
        assertEquals( 18, c1.getMesAniversario());
        arquivo.delete();
    }
}