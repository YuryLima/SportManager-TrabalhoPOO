/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class ListaTurmas implements CrudTurma {

    private ArrayList<Turma> listaEsportes = new ArrayList();

    /**
     * Método que retorna toda a lista de esportes.
     *
     * @return - retorna uma lista com todas as turmas que foram cadastradas.
     */
    public List<Turma> getLista() {
        return this.listaEsportes;
    }

    //<editor-fold defaultstate="collapsed" desc="Incluir">
    @Override
    public boolean incluir(Turma esporte) {
        return listaEsportes.add(esporte);
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
        for (Turma turm : listaEsportes) {
            if (turm.getModalidade() == esporte) {
                esp.add(turm);
            }
        }
        return esp;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Gravar e Ler Arquivo">
    
    @Override
    public void gravar() throws Exception{
        File outputFile = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"ListaTurmas.bin");
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream(outputFile));
        output.writeObject(Turma.getSequence());
        output.writeObject(this.listaEsportes);
        output.close();
    }
    
    @Override
    public void ler() throws Exception{
        File inputFile = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"ListaTurmas.bin");
        if(inputFile.exists()){
            ObjectInputStream input;
            input = new ObjectInputStream(new FileInputStream(inputFile));
            Turma.setSequence((int)input.readObject());
            this.listaEsportes = (ArrayList<Turma>) input.readObject();
            input.close();
        }
    }

    //</editor-fold>
    
}
