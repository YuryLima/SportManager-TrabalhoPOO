/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.aplicacao;

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
        
        new Inicial(new ListaAlunos(), new ListaTurmas()).setVisible(true);
    }
    
}
