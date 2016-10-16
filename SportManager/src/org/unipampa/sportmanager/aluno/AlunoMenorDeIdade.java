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
     */
    public AlunoMenorDeIdade(String nomeCompleto, String nomeResponsavel, long rgResponsavel) {
        super(nomeCompleto);
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
     */
    public AlunoMenorDeIdade(String nomeCompleto, long rg,  String nomeResponsavel, long rgResponsavel
                    ,String endereco , int telefoneContato) {
        super(nomeCompleto, rg);
        this.nomeResponsavel = nomeResponsavel;
        this.rgResponsavel = rgResponsavel;
        setEndereco(endereco);
        setTelefoneContato(telefoneContato);
    }
    
    //</editor-fold>
    
}
