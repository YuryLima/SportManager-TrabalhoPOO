/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.util.ArrayList;
import java.util.List;
import org.unipampa.sportmanager.aluno.Aluno;
import org.unipampa.sportmanager.esportes.Esporte;
import org.unipampa.sportmanager.esportes.Turma;

//</editor-fold>
/**
 *
 * @author yuryalencar
 */
public class ListaTurmas implements CrudTurmas {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ArrayList<Turma> listaEsportes = new ArrayList<>();

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Implementados">
    /**
     * Método que retorna toda a lista de esportes.
     *
     * @return - retorna uma lista com todas as turmas que foram cadastradas.
     */
    public ArrayList<Turma> getLista() {
        return this.listaEsportes;
    }

    //<editor-fold defaultstate="collapsed" desc="Incluir">
    @Override
    public boolean incluir(Turma esporte) {
        listaEsportes.add(esporte);
        return true;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Editar">
    @Override
    public boolean editar(int turma, Turma esporte) {

        for (Turma turm : listaEsportes) {
            if (turm.getTurma() == turma) {
                listaEsportes.set(turma, esporte);
                return true;
            }
        }
        return false;
    }
    //</editor-fold

    //<editor-fold defaultstate="collapsed" desc="Excluir">
    @Override
    public boolean excluir(int turma) {
        for (Turma help : listaEsportes) {
            if (help.getTurma() == turma) {
                listaEsportes.remove(help);
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Buscar Turma">
    @Override
    public Turma buscarTurma(int turma) {
        for (Turma turm : listaEsportes) {
            if (turm.getTurma() == turma) {
                return turm;
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="BuscarEsporte">
    @Override
    public List<Turma> buscarEsporte(Esporte esporte) {
        List<Turma> esp = new ArrayList<>();
        for (int i = 0; i < listaEsportes.size(); i++) {
            //if (listaEsportes.get(i).get) {
             return esp;   
            }
        return null;
    
        }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Buscar Horario">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="OrdenarTurma">
    @Override
    public void ordenarTurma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Não implementados">
    @Override
    public ArrayList<Turma> buscarHorario(int horario) {
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
