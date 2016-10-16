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
public enum Esporte {
    
    //Modalidades que o sistema gerencia turmas
    FUTEBOL("Futebol"),
    BASQUETE ("Basquete"),
    VOLEIBOL("Voleibol");
    
    private final String esporte;
    
    /**
     * Construtor para que se possa
     * inicializar as Strings dos esportes
     * @param esporte - Recebe a String respectiva
     * do seu esporte
     */
    private Esporte(String esporte){
        this.esporte = esporte;
    }
    
    /**
     * Método para a verificação de um
     * esporte.
     * @return - uma String contendo a
     * modalidade do esporte.
     */
    public String getEsporte(){
        return this.esporte;
    }
    
    /**
     * Método para garantir qual o esporte
     * será adicionado em uma turma
     * @param esporte - String contendo a
     * modalidade a ser buscada
     * @return - Esporte, ou seja, a modalidade
     * requisitada através do parâmetro.
     */
    public static Esporte verificarEsporte(String esporte){
        switch(esporte){
            case "Futebol":
                return Esporte.FUTEBOL;
            case "Basquete":
                return Esporte.BASQUETE;
            case "Voleibol":
                return Esporte.VOLEIBOL;
            default:
                throw new VerifyError("Não foi possível encontrar o esporte requisitado");
        }
    }
}
