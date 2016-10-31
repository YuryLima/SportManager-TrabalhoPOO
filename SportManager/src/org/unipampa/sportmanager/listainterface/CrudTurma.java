/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

//<editor-fold defaultstate="collapsed" desc="Importações">

import org.unipampa.sportmanager.esportes.Turma;
import java.util.List;
import org.unipampa.sportmanager.esportes.Esporte;

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public interface CrudTurma {
    
    /**
     * Método para incluir uma turma de qualquer 
     * esporte dentro do sistema SportManager
     * @param esporte - O objeto esporte que contém
     * a turma do determinado esporte a ser incluído
     * na lista.
     * @return - true caso o esporte tenha sido adicionado
     * com sucesso e false caso contrário.
     * Obs.: Não deve ser possível incluir 2 turmas com o
     * mesmo nome.
     */
    public boolean incluir(Turma esporte);
    
    /**
     * Método editar, recebe a turma que é única e troca
     * o objeto existente por um novo com os novos dados.
     * @param turma - Turma identificador único de turma não
     * pode deixar cadastrar duas com o mesmo nome.
     * @param esporte - Turma que foi editado(Objeto)
     * @return - true caso tem editado com sucesso e false
     * caso contrário.
     */
    public boolean editar(int turma, Turma esporte);
    
    /**
     * Método excluir, para tirar uma turma da lista.
     * @param turma - nome identificador da turma (único)
     * @return - true caso tenha excluído com sucesso e false
     * caso não tenha conseguido ou turma não encontrada
     */
    public boolean excluir(int turma);
    
    /**
     * Busca por turma sendo que turma é um identificador
     * único.
     * @param turma - turma específica a ser buscada.
     * @return - retorna o esporte ou null caso o mesmo
     * não tenha sido encontrado.
     */
    public Turma buscarTurma(int turma);
    
    /**
     * Método para a busca das turmas de acordo com o seu esporte
     * @param esporte
     * @return - Uma Lista com todas as turmas de um determinado
     * esporte
     */
    public List<Turma> buscarEsporte(Esporte esporte); 
    
    /**
     * Método para gravar a lista de turmas e um arquivo binário.
     */
    public void gravar()throws Exception;
    
    /**
     * Método para ler a lista gravada em disco.
     */
    public void ler()throws Exception;
}
