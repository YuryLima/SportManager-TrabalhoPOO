/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.listainterface;

//<editor-fold defaultstate="collapsed" desc="Importações">

import java.util.List;
import org.unipampa.sportmanager.aluno.Aluno;

//</editor-fold>

/**
 *
 * @author yuryalencar
 */
public interface CrudAluno {
    
    /**
     * Método para a inclusão de um aluno no sistema
     * @param a - Tipo:Aluno , aluno no qual vai ser inserido
     * no sistema
     * @return - Tipo:boolean, true caso tenha sido cadastrado com sucesso e false
     * caso tenha ocorrido algum problema.
     */
    public boolean incluir(Aluno a);
    
    /**
     * Método para a edição de um aluno já cadastrado no sistema.
     * @param matricula - Tipo:int, Matricula do aluno sendo que a matrícula é unica
     * @param a - Tipo:Aluno , novo objeto modificado para trocar com o que deseja ser
     * editado
     * @return - Tipo:boolean, true caso tenha sido editado com sucesso e false caso o
     * objeto não exista ou não seja possível editar
     */
    public boolean editar(int matricula ,Aluno a);
    
    /**
     * Método para excluir um aluno do sistema.
     * @param matricula -Tipo:int, Matricula do aluno que será excluído.
     * @return Tipo:boolean, true caso tenha sido excluído com sucesso e false caso
     * não exista o aluno com tal matricula ou ocorra algum erro.
     */
    public boolean excluir(int matricula);
    
    /**
     * Método para a busca de um aluno a partir do seu nome.
     * @param nome - Tipo:String, nome do aluno a ser buscado.
     * @return - Tipo:List<Aluno>, com os alunos que tem o nome
     * buscado.
     */
    public List<Aluno> buscarNome(String nome);
    
    /**
     * Método para a busca de um aluno a partir de sua matrícula.
     * @param matricula - Tipo:int, matricula do aluno a ser procurado no sistema.
     * @return - Tipo:Aluno, aluno no qual se tem a matricula procurada ou null caso o
     * mesmo não exista.
     */
    public Aluno buscarMatricula(int matricula);
    
    /**
     * Método para gravar a lista de turmas e um arquivo binário.
     */
    public void gravar()throws Exception;
    
    /**
     * Método para ler a lista gravada em disco.
     */
    public void ler()throws Exception;
}
