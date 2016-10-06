/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

import org.unipampa.sportmanager.esportes.Esporte;
import java.util.ArrayList;
/**
 *
 * @author yuryalencar
 */
public interface CrudTurmas {
    
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
    public boolean incluir(Esporte esporte);
    
    /**
     * Método editar, recebe a turma que é única e troca
     * o objeto existente por um novo com os novos dados.
     * @param turma - Turma identificador único de turma não
     * pode deixar cadastrar duas com o mesmo nome.
     * @param esporte - Esporte que foi editado(Objeto)
     * @return - true caso tem editado com sucesso e false
     * caso contrário.
     */
    public boolean editar(String turma, Esporte esporte);
    
    /**
     * Método excluir, para tirar uma turma da lista.
     * @param turma - nome identificador da turma (único)
     * @return - true caso tenha excluído com sucesso e false
     * caso não tenha conseguido ou turma não encontrada
     */
    public boolean excluir(String turma);
    
    /**
     * Busca por turma sendo que turma é um identificador
     * único.
     * @param turma - turma específica a ser buscada.
     * @return - retorna o esporte ou null caso o mesmo
     * não tenha sido encontrado.
     */
    public Esporte buscarTurma(String turma);
    
    /**
     * Método para buscar todas as turmas de um certo horário.
     * @param horario - horário a ser buscado dentro do sistema.
     * @return - retorna uma lista com todas as turmas que são
     * do mesmo horário buscado.
     */
    public ArrayList<Esporte> buscarHorario(int horario);
}
