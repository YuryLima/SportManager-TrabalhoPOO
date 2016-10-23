/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.aluno;

import java.io.Serializable;
/**
 *
 * @author yuryalencar
 */
public class Aluno implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private int matricula, telefoneContato, idade;
    private String nomeCompleto, endereco;
    private long rg;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtores da classe">
    
    /**
     * Construtor para cadastrar um aluno no sistema.
     * @param nomeCompleto - nomeCompleto do aluno a ser cadastrado no sistema, tipo String.
     * @param rg - Documento para a identificação do aluno tipo long
     * @param idade - idade do aluno a ser adicionado tipo int
     */
    public Aluno(String nomeCompleto, long rg, int idade){
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.idade = idade;
    }

    /**
     * Construtor para cadastrar um aluno no sistema.
     * @param nomeCompleto - nomeCompleto do aluno a ser cadastrado no sistema tipo String.
     * @param idade - idade do aluno a ser adicionado tipo int
     */
    public Aluno(String nomeCompleto, int idade){
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    
    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @return the telefoneContato
     */
    public int getTelefoneContato() {
        return telefoneContato;
    }

    /**
     * @param telefoneContato the telefoneContato to set
     */
    public void setTelefoneContato(int telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //</editor-fold>
    
}
