/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.aplicacao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.unipampa.sportmanager.frames.Inicial;
import org.unipampa.sportmanager.listainterface.CrudAluno;
import org.unipampa.sportmanager.listainterface.CrudTurma;
import org.unipampa.sportmanager.listainterface.ListaAlunos;
import org.unipampa.sportmanager.listainterface.ListaTurmas;
/**
 *
 * @author yuryalencar
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaAlunos listaAlunos = new ListaAlunos();
        ListaTurmas listaTurmas = new ListaTurmas();
        try {
            listaAlunos.ler();
            listaTurmas.ler();
        } catch (Exception ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Inicial(listaAlunos, listaTurmas).setVisible(true);
    }
    
}
