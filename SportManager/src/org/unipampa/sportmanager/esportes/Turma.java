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

    private int turma, horario, menorIdade, maiorIdade;
    private List<Aluno> alunos;
    private Esporte modalidade;
    private final int MAX_ALUNO;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    
    /**
     * Construtor para a criação de uma turma de esportes
     * @param horario - Tipo:int horario no qual será ministrada as aulas
     * ou jogos
     * @param modalidade - Tipo:Esporte se refere a qual esporte vai ser ministrada
     * as aulas
     * @param MAX_ALUNO - Tipo:int se refere à quantidade máxima de alunos desta turma
     * o número deve ser superior à 0
     * @param menorIdade - Tipo:int se refere à menor idade da faixa aceita pelo
     * sistema o número não pode ser negativo e nem menor do que 3
     * @param maiorIdade - Tipo:int se refere à maior idade da faixa aceita pelo
     * sistema o número não pode ser negativo e nem menor do que 4 
     */
    public Turma(int horario, Esporte modalidade, int MAX_ALUNO, int menorIdade, int maiorIdade) {
        if(MAX_ALUNO < 0 || menorIdade < 3 || maiorIdade < 4 || maiorIdade<menorIdade || maiorIdade>100){
            throw new IllegalArgumentException("Número informado inválido");
        }
        this.turma = sequence++;
        this.modalidade = modalidade;
        this.horario = horario;
        this.MAX_ALUNO = MAX_ALUNO;
        this.alunos = new ArrayList<>();
        this.menorIdade = menorIdade;
        this.maiorIdade = maiorIdade;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="AddAluno and removeAluno">
    
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
        if(getAlunos().size()<getMAX_ALUNO())
            return getAlunos().add(aluno);
        return false;
    }
    
    /**
     * Método para a exclusão de um aluno da turma
     * @param matricula - Tipo:Int a matricula do aluno
     * que deseja ser retirado da turma
     * @return - true caso tenha sido removido com sucesso,
     * ou false caso não tenha conseguido encontrar o mesmo
     * na lista, ou caso tenha ocorrido algum erro na sua exclusão.
     */
    public boolean removeAluno(int matricula){
        for (Aluno aluno : alunos) {
            if(aluno.getMatricula() == matricula) {
                return alunos.remove(aluno);
            }
        }
        return false;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">

    /**
     * @return the sequence
     */
    public static int getSequence() {
        return sequence;
    }
    
    /**
     * @return the menorIdade
     */
    public int getMenorIdade() {
        return menorIdade;
    }

    /**
     * @return the maiorIdade
     */
    public int getMaiorIdade() {
        return maiorIdade;
    }

    /**
     * @return the alunos
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @return the modalidade
     */
    public Esporte getModalidade() {
        return modalidade;
    }
    
    /**
     * @return the MAX_ALUNO
     */
    public int getMAX_ALUNO() {
        return MAX_ALUNO;
    }
        
    /**
     * 
     * @return - um inteiro com a quantidade
     * de alunos cadastrados na turma.
     */
    public int getQuantidadeAlunos(){
        return getAlunos().size();
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
     * @param menorIdade the menorIdade to set
     */
    public void setMenorIdade(int menorIdade) {
        this.menorIdade = menorIdade;
    }

    /**
     * @param maiorIdade the maiorIdade to set
     */
    public void setMaiorIdade(int maiorIdade) {
        this.maiorIdade = maiorIdade;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(Esporte modalidade) {
        this.modalidade = modalidade;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="toString">
    
    public String toString(){
        return this.turma+" - "+this.modalidade.getEsporte()+" - MAXIMO DE ALUNOS: "+this.MAX_ALUNO+" - ALUNOS: "+getQuantidadeAlunos();
    }
    
    //</editor-fold>

}
