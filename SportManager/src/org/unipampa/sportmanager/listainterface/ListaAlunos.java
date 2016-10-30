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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import org.unipampa.sportmanager.esportes.Turma;

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public class ListaAlunos implements CrudAluno {
    
    private ArrayList <Aluno> listaAlunos = new ArrayList();
    
    //<editor-fold defaultstate="collapsed" desc="Incluir">
    @Override
    public boolean incluir(Aluno a) {
        listaAlunos.add(a);
        return true;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Editar">
   @Override
    public boolean editar(int matricula, Aluno a) {
        for (Aluno jacaRed : listaAlunos) {
            if(jacaRed.getMatricula() == matricula){
                listaAlunos.set(matricula, a);
                return true;
            }
        }
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Excluir">
    @Override
    public boolean excluir(int matricula) {
        for (Aluno help : listaAlunos) {
            if(help.getMatricula() == matricula){
                listaAlunos.remove(help);
                return true;
            }
        }
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Buscar Nome">
    @Override
    public List<Aluno> buscarNome(String nome) {
        List<Aluno> name = new ArrayList<>();
        for (int i = 0; i < listaAlunos.size(); i++) {
            if(listaAlunos.get(i).getNomeCompleto().toLowerCase().contains(nome.toLowerCase())){
                name.add(listaAlunos.get(i));
            }    
        }
        return name;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BuscarMatricula">
    @Override
    public Aluno buscarMatricula(int matricula) {
        for (Aluno mat : listaAlunos) {
            if(mat.getMatricula() == matricula){
                return mat;
            }
         }
        return null;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getLista">
    
    /**
     * Método para pegar toda a lista de alunos
     * @return - retorna a lista de alunos
     */
    public List<Aluno> getLista(){
        return this.listaAlunos;
    }
    
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Gravar e Ler Arquivo">
    
    @Override
    public void gravar() throws Exception{
        File outputFile = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"ListaAlunos.bin");
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream(outputFile));
        output.writeObject(Aluno.getSequence());
        output.writeObject(listaAlunos);
        output.close();
    }
    
    @Override
    public void ler() throws Exception{
        File inputFile = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"ListaAlunos.bin");
        if(inputFile.exists()){
            ObjectInputStream input;
            input = new ObjectInputStream(new FileInputStream(inputFile));
            Aluno.setSequence((Integer)input.readObject());
            this.listaAlunos = (ArrayList<Aluno>) input.readObject();
            input.close();
        }
    }
    
    //</editor-fold>
    
}
