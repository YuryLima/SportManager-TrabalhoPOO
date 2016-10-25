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
public class AlunoMenorDeIdade extends Aluno{
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    private String nomeResponsavel;
    private long rgResponsavel;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    /**
     * Construtor padrão que recebe apenas o mínimo
     * para o cadastro de um aluno menor de idade no
     * sistema
     * @param nomeCompleto - String nome completo do aluno
     * @param nomeResponsavel - String nome completo do responsável pelo mesmo
     * @param rgResponsavel - long documento do responsável pelo aluno
     * @param idade - Tipo:int idade do aluno.
     */
    public AlunoMenorDeIdade(String nomeCompleto, String nomeResponsavel, long rgResponsavel, int idade) {
        super(nomeCompleto, idade);
        this.nomeResponsavel = nomeResponsavel;
        this.rgResponsavel = rgResponsavel;
    }
    
    /**
     * Construtor que recebe todos os dados para efetuar
     * um cadastro de um aluno menor de idade no sistema
     * @param nomeCompleto - String nome completo do aluno
     * @param rg - long sendo que é o documento referente ao aluno
     * @param nomeResponsavel - String com o nome do responsável pelo mesmo
     * @param rgResponsavel - long com o documento do responsável
     * @param endereco - String contendo o endereço para do aluno
     * @param telefoneContato - int contendo o número de contato
     * @param idade - Tipo:int idade do aluno.
     */
    public AlunoMenorDeIdade(String nomeCompleto, long rg,  String nomeResponsavel, long rgResponsavel
                    ,String endereco , int telefoneContato, int idade) {
        super(nomeCompleto, rg, idade);
        this.nomeResponsavel = nomeResponsavel;
        this.rgResponsavel = rgResponsavel;
        super.setEndereco(endereco);
        super.setTelefoneContato(telefoneContato);
    }
    
     //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    
    /**
     * @return the nomeResponsavel
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * @return the rgResponsavel
     */
    public long getRgResponsavel() {
        return rgResponsavel;
    }

    /**
     * @param nomeResponsavel the nomeResponsavel to set
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /**
     * @param rgResponsavel the rgResponsavel to set
     */
    public void setRgResponsavel(long rgResponsavel) {
        this.rgResponsavel = rgResponsavel;
    }
    
    //</editor-fold>
    
}
