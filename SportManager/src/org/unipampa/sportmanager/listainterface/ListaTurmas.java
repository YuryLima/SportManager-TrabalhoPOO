/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

//<editor-fold defaultstate="collapsed" desc="Importações">

import java.util.ArrayList;
import java.util.List;
import org.unipampa.sportmanager.esportes.Esporte;
import org.unipampa.sportmanager.esportes.Turma;

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public class ListaTurmas implements CrudTurmas{

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private ArrayList<Turma> listaEsportes = new ArrayList<>();
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Implementados">
    
    /**
     * Método que retorna toda a lista
     * de esportes.
     * @return - retorna uma lista com todas
     * as turmas que foram cadastradas.
     */
    public ArrayList<Turma> getLista(){
        return this.listaEsportes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Não implementados">
    
    @Override
    public boolean incluir(Turma esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(String turma, Turma esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turma buscarTurma(String turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> buscarEsporte(Esporte esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Turma> buscarHorario(int horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ordenarTurma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ordenarQuantidadeAlunos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> ordenarQuantidadeAlunos(Esporte esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    //</editor-fold>

}
