/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.aluno;

/**
 *
 * @author yuryalencar
 */
public class Aluno {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private int matricula, telefoneContato;
    private String nomeCompleto, nomeResponsavel, endereco;
    private long rgResponsavel;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor da classe">
    
    /**
     * Construtor para cadastrar um aluno no sistema.
     * @param nomeCompleto - nomeCompleto do aluno a ser cadastrado no sistema.
     * @param nomeResponsavel - nomeCompleto do responsável pelo aluno cadastrado.
     * @param rgResponsavel - rg do responsável do aluno a ser cadastrado.
     */
    public Aluno(String nomeCompleto, String nomeResponsavel, long rgResponsavel){
        this.nomeCompleto = nomeCompleto;
        this.nomeResponsavel = nomeResponsavel;
        this.rgResponsavel = rgResponsavel;
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
     * @return the nomeResponsavel
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * @param nomeResponsavel the nomeResponsavel to set
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /**
     * @return the rgResponsavel
     */
    public long getRgResponsavel() {
        return rgResponsavel;
    }

    /**
     * @param rgResponsavel the rgResponsavel to set
     */
    public void setRgResponsavel(long rgResponsavel) {
        this.rgResponsavel = rgResponsavel;
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

    //</editor-fold>
    
}
