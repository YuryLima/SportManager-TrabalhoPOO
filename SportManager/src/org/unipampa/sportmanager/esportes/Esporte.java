/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.esportes;

/**
 *
 * @author yuryalencar
 */
public abstract class Esporte {
    protected int turma,horario,quantTurma,quantAluno;
    protected final int MAX_TURMA,MAX_ALUNO;

    /**
     * 
     * @param turma
     * @param horario
     * @param quantTurma
     * @param quantAluno
     * @param MAX_TURMA
     * @param MAX_ALUNO 
     */
    public Esporte(int turma, int horario, int quantTurma, int quantAluno, int MAX_TURMA, int MAX_ALUNO) {
        this.turma = turma;
        this.horario = horario;
        this.quantTurma = quantTurma;
        this.quantAluno = quantAluno;
        this.MAX_TURMA = MAX_TURMA;
        this.MAX_ALUNO = MAX_ALUNO;
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
     * @return the quantTurma
     */
    public int getQuantTurma() {
        return quantTurma;
    }

    /**
     * @param quantTurma the quantTurma to set
     */
    public void setQuantTurma(int quantTurma) {
        this.quantTurma = quantTurma;
    }

    /**
     * @return the quantAluno
     */
    public int getQuantAluno() {
        return quantAluno;
    }

    /**
     * @param quantAluno the quantAluno to set
     */
    public void setQuantAluno(int quantAluno) {
        this.quantAluno = quantAluno;
    }

    /**
     * @return the maxTurma
     */
    public int getMaxTurma() {
        return MAX_TURMA;
    }

    /**
     * @return the MAX_ALUNO
     */
    public int getMAX_ALUNO() {
        return MAX_ALUNO;
    }
    

}
