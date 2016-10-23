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

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public class ListaAlunos implements CrudAluno {
    
    private ArrayList <Aluno> listaAlunos = new ArrayList();

    //<editor-fold defaultstate="collapsed" desc="Implementados">
    
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
      
    //</editor-fold>
    
    
   
}
