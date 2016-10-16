/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.esportes;

//<editor-fold defaultstate="collapsed" desc="Importações">

import java.util.List;
import java.util.ArrayList;
import org.unipampa.sportmanager.aluno.Aluno;

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public class Turma {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private static int sequence=0;
    private int turma, horario;
    private List<Aluno> alunos;
    private Esporte modalidade;
    private final int MAX_ALUNO;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    
    /**
     * Construtor para a criação de uma turma de esportes
     * @param horario - horario no qual será ministrada as aulas
     * ou jogos
     * @param modalidade
     * @param MAX_ALUNO 
     */
    public Turma(int horario, Esporte modalidade, int MAX_ALUNO) {
        this.turma = sequence++;
        this.modalidade = modalidade;
        this.horario = horario;
        this.MAX_ALUNO = MAX_ALUNO;
        this.alunos = new ArrayList<>();
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="AddAluno">
    
    /**
     * Método para adicionar um aluno
     * na turma escolhida
     * @param aluno - (Aluno) aluno a ser
     * cadastrado na turma
     * @return - retorna true caso sejá possível e false
     * caso nao tenha conseguido ou já tenha fechado o max de
     * alunos na turma.
     */
    public boolean addAluno(Aluno aluno){
        if(alunos.size()<MAX_ALUNO)
            return alunos.add(aluno);
        return false;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    
    /**
     * 
     * @return - um inteiro com a quantidade
     * de alunos cadastrados na turma.
     */
    public int getQuantidadeAlunos(){
        return alunos.size();
    }
    
    /**
     * @return the turma
     */
    public int getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(int turma) {
        this.turma = turma;
    }

    /**
     * @return the horario
     */
    public int getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * @return the MAX_ALUNO
     */
    public int getMAX_ALUNO() {
        return MAX_ALUNO;
    }
    
    //</editor-fold>
    
}
