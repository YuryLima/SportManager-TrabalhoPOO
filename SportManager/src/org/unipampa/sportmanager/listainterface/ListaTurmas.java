/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

import java.util.ArrayList;
import org.unipampa.sportmanager.esportes.Esporte;

/**
 *
 * @author yuryalencar
 */
public class ListaTurmas implements CrudTurmas{

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private ArrayList<Esporte> listaEsportes = new ArrayList<>();
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Implementados">
    
    /**
     * Método que retorna toda a lista
     * de esportes.
     * @return - retorna uma lista com todas
     * as turmas que foram cadastradas.
     */
    public ArrayList<Esporte> getLista(){
        return this.listaEsportes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Não implementados">
    
    @Override
    public boolean incluir(Esporte esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(String turma, Esporte esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Esporte buscarTurma(String turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Esporte> buscarHorario(int horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //</editor-fold>
    
}
