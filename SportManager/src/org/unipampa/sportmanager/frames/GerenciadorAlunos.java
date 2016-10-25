/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.sportmanager.frames;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.unipampa.sportmanager.aluno.Aluno;
import org.unipampa.sportmanager.aluno.AlunoMenorDeIdade;
import org.unipampa.sportmanager.esportes.Esporte;
import org.unipampa.sportmanager.esportes.Turma;
import org.unipampa.sportmanager.listainterface.*;

/**
 *
 * @author yuryalencar
 */
public class GerenciadorAlunos extends javax.swing.JFrame {

    private ListaAlunos listaAlunos;
    private ListaTurmas listaTurmas;
    private boolean isEdit;
    
    //<editor-fold defaultstate="collapsed" desc="soNumeros, mudarAbas, listar(normal, nome, matricula), verificação, limparCampos, getCod, preencherCampos">
    
    private void preencherCampos(int cod){
        Aluno aluno = listaAlunos.buscarMatricula(cod);
        
        jTextFieldEnderecoAlunoDados.setText(aluno.getEndereco());
        jTextFieldNomeAlunoDados.setText(aluno.getNomeCompleto());
        jTextFieldRGAlunoDados.setText(String.valueOf(aluno.getRg()));
        jTextFieldIdadeAlunoDados.setText(String.valueOf(aluno.getIdade()));
        jFormattedTextFieldTelefoneAlunoDados.setText(String.valueOf(aluno.getTelefoneContato()));
        jLabelNroMatriculaAlunoDados.setText(String.valueOf(aluno.getMatricula()));
        
        if(aluno.getIdade() < 18) {
            AlunoMenorDeIdade alunoMenor = (AlunoMenorDeIdade) aluno;
            jTextFieldNomeRespAlunoMenorDados.setText(alunoMenor.getNomeResponsavel());
            jTextFieldRGRespAlunoMenorDados.setText(String.valueOf(alunoMenor.getRgResponsavel()));
        }
    }
    
    private void desativarCampos(int cod){
        Aluno aluno = listaAlunos.buscarMatricula(cod);
        
        jTextFieldEnderecoAlunoDados.setEnabled(false);
        jTextFieldNomeAlunoDados.setEnabled(false);
        jTextFieldIdadeAlunoDados.setEnabled(false);
        jTextFieldRGAlunoDados.setEnabled(false);
        jFormattedTextFieldTelefoneAlunoDados.setEnabled(false);
        jLabelNroMatriculaAlunoDados.setEnabled(false);
        
        if(aluno.getIdade() < 18) {
            jTextFieldNomeRespAlunoMenorDados.setEnabled(false);
            jTextFieldRGRespAlunoMenorDados.setEnabled(false);
            jTextFieldNomeRespAlunoMenorDados.setVisible(true);
            jTextFieldRGRespAlunoMenorDados.setVisible(true);
        } else {
            jLabelNomeRespAlunoMenorDados.setVisible(false);
            jLabelRGRespAlunoMenorDados.setVisible(false);
            jTextFieldNomeRespAlunoMenorDados.setVisible(false);
            jTextFieldRGRespAlunoMenorDados.setVisible(false);
        }
        
        jButtonSalvarAlunoDados.setVisible(false);
    }
    
    private void ativarCampos(){
        
        jTextFieldEnderecoAlunoDados.setEnabled(true);
        jTextFieldNomeAlunoDados.setEnabled(true);
        jTextFieldIdadeAlunoDados.setEnabled(true);
        jFormattedTextFieldTelefoneAlunoDados.setEnabled(true);
        jTextFieldRGAlunoDados.setEnabled(true);
        jLabelNroMatriculaAlunoDados.setEnabled(true);
        
        jTextFieldNomeRespAlunoMenorDados.setEnabled(true);
        jTextFieldRGRespAlunoMenorDados.setEnabled(true);
        jLabelNomeRespAlunoMenorDados.setVisible(true);
        jLabelRGRespAlunoMenorDados.setVisible(true);
        jTextFieldNomeRespAlunoMenorDados.setVisible(true);
        jTextFieldRGRespAlunoMenorDados.setVisible(true);
        
        jButtonSalvarAlunoDados.setVisible(true);
    }
    
    private void limparCampos(){
        jTextFieldEnderecoAlunoDados.setText("");
        jTextFieldIdadeAlunoDados.setText("");
        jTextFieldNomeAlunoDados.setText("");
        jTextFieldNomeRespAlunoMenorDados.setText("");
        jTextFieldRGAlunoDados.setText("");
        jTextFieldRGRespAlunoMenorDados.setText("");
        jFormattedTextFieldTelefoneAlunoDados.setText("");
    }
    
    private boolean verificacao(String message){
        int resposta = JOptionPane.showConfirmDialog(null, message, "Verificação",
                JOptionPane.YES_NO_OPTION);
        return resposta == JOptionPane.YES_OPTION;
    }
    
    private void listar(){
        DefaultListModel listModel = new DefaultListModel();
        List<Aluno> listaAlunos = this.listaAlunos.getLista();
        
        for (Aluno aluno : listaAlunos) {
            listModel.addElement(aluno.toString());
        }
        
        jListAlunos.setModel(listModel);
    }
    
    private void listarNome(){
        DefaultListModel listModel = new DefaultListModel();
        List<Aluno> listaAlunos = this.listaAlunos.buscarNome(jTextFieldBusca.getText());
        
        for (Aluno aluno : listaAlunos) {
            listModel.addElement(aluno.toString());
        }
        
        jListAlunos.setModel(listModel);
        
        if(listModel.isEmpty())
            JOptionPane.showMessageDialog(null, "Nenhum aluno foi encontrado!");
    }
    
    private void listarMatricula(){
        DefaultListModel listModel = new DefaultListModel();
        Aluno aluno = listaAlunos.buscarMatricula(Integer.parseInt(jTextFieldBusca.getText()));
        
        if(aluno != null){
            listModel.addElement(aluno.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        
        jListAlunos.setModel(listModel);
    }
    
    /**
     * Método para a verificação se no campo só contem numeros
     * @param evt - evento key
     */
    private void soNumeros(java.awt.event.KeyEvent evt){
        if(!(Character.isDigit(evt.getKeyChar()))){
            evt.consume();
        }
    }
    
    /**
     * Método para mudar de abas
     * @param saida - aba na qual se está
     * @param chegada - aba na qual se deseja ir
     */
    private void mudarAbas(int saida, int chegada){
        jTabbedPaneGerenciadorAlunos.setSelectedIndex(chegada);
        jTabbedPaneGerenciadorAlunos.setEnabledAt(saida, false);
        jTabbedPaneGerenciadorAlunos.setEnabledAt(chegada, true);
    }
    
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc="getCod">
    
    private int getCod(){
        String cod="", extract = jListAlunos.getSelectedValue();
        
        for (int i = 0; i < extract.length(); i++) {
            if(extract.charAt(i) == ' '){
                break;
            } else {
                cod += extract.charAt(i);
            }
        }
        
        return Integer.parseInt(cod);
    }

    //</editor-fold>
    
    /**
     * Creates new form GerenciadorAlunos
     */
    public GerenciadorAlunos(CrudAluno listaAlunos, CrudTurma listaTurmas) {
        initComponents();
        this.setTitle("Gerenciador de alunos");
        
        this.listaAlunos = (ListaAlunos) listaAlunos;
        this.listaTurmas = (ListaTurmas) listaTurmas;
        this.setLocationRelativeTo(null);
        
        jTabbedPaneGerenciadorAlunos.setEnabledAt(0, true);
        jTabbedPaneGerenciadorAlunos.setEnabledAt(1, false);
        jComboBoxModalidadeAlunoDados.setEnabled(false);
        
        jButtonDetalhesAluno.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
        for (Esporte modalidade : Esporte.values()) {
            jComboBoxModalidadeAlunoDados.addItem(modalidade.getEsporte());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneGerenciadorAlunos = new javax.swing.JTabbedPane();
        jPanelGerenciamento = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jLabelGerenciadorAlunos = new javax.swing.JLabel();
        jLabelAluno = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPaneAlunos = new javax.swing.JScrollPane();
        jListAlunos = new javax.swing.JList<>();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonDetalhesAluno = new javax.swing.JButton();
        jComboBoxTipoBusca = new javax.swing.JComboBox<>();
        jPanelAlunoDados = new javax.swing.JPanel();
        jTextFieldNomeAlunoDados = new javax.swing.JTextField();
        jLabelNomeAlunoDados = new javax.swing.JLabel();
        jTextFieldEnderecoAlunoDados = new javax.swing.JTextField();
        jComboBoxModalidadeAlunoDados = new javax.swing.JComboBox<>();
        jTextFieldRGAlunoDados = new javax.swing.JTextField();
        jLabelRGAlunoDados = new javax.swing.JLabel();
        jLabelMatriculaDados = new javax.swing.JLabel();
        jTextFieldIdadeAlunoDados = new javax.swing.JTextField();
        jLabelTelefoneAlunoDados = new javax.swing.JLabel();
        jLabelEnderecoAlunoDados = new javax.swing.JLabel();
        jLabelIdadeAlunoDados = new javax.swing.JLabel();
        jPanelAlunoMenorDeIdade = new javax.swing.JPanel();
        jLabelNomeRespAlunoMenorDados = new javax.swing.JLabel();
        jTextFieldNomeRespAlunoMenorDados = new javax.swing.JTextField();
        jLabelRGRespAlunoMenorDados = new javax.swing.JLabel();
        jTextFieldRGRespAlunoMenorDados = new javax.swing.JTextField();
        jFormattedTextFieldTelefoneAlunoDados = new javax.swing.JFormattedTextField();
        jButtonSalvarAlunoDados = new javax.swing.JButton();
        jButtonVoltarAlunoDados = new javax.swing.JButton();
        jLabelModalidadeAlunoDados = new javax.swing.JLabel();
        jLabelNroMatriculaAlunoDados = new javax.swing.JLabel();
        jScrollPaneModalidades = new javax.swing.JScrollPane();
        jListModalidades = new javax.swing.JList<>();
        jLabelLembreteIdade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabelGerenciadorAlunos.setText("Gerenciador de Alunos");

        jLabelAluno.setText("Aluno:");

        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });

        jListAlunos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListAlunosValueChanged(evt);
            }
        });
        jScrollPaneAlunos.setViewportView(jListAlunos);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonDetalhesAluno.setText("Detalhes");
        jButtonDetalhesAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalhesAlunoActionPerformed(evt);
            }
        });

        jComboBoxTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Matricula" }));
        jComboBoxTipoBusca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoBuscaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelGerenciamentoLayout = new javax.swing.GroupLayout(jPanelGerenciamento);
        jPanelGerenciamento.setLayout(jPanelGerenciamentoLayout);
        jPanelGerenciamentoLayout.setHorizontalGroup(
            jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGerenciamentoLayout.createSequentialGroup()
                        .addComponent(jButtonAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGerenciamentoLayout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDetalhesAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir))
                    .addGroup(jPanelGerenciamentoLayout.createSequentialGroup()
                        .addGroup(jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGerenciadorAlunos)
                            .addComponent(jScrollPaneAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelGerenciamentoLayout.setVerticalGroup(
            jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGerenciadorAlunos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jLabelAluno)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonDetalhesAluno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneGerenciadorAlunos.addTab("Gerenciamento", jPanelGerenciamento);

        jLabelNomeAlunoDados.setText("Nome Completo:*");

        jComboBoxModalidadeAlunoDados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModalidadeAlunoDadosItemStateChanged(evt);
            }
        });

        jTextFieldRGAlunoDados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRGAlunoDadosKeyTyped(evt);
            }
        });

        jLabelRGAlunoDados.setText("RG:");

        jLabelMatriculaDados.setText("Matricula:");

        jTextFieldIdadeAlunoDados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIdadeAlunoDadosFocusLost(evt);
            }
        });
        jTextFieldIdadeAlunoDados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdadeAlunoDadosKeyTyped(evt);
            }
        });

        jLabelTelefoneAlunoDados.setText("Telefone:");

        jLabelEnderecoAlunoDados.setText("Endereço:");

        jLabelIdadeAlunoDados.setText("Idade:*");

        jLabelNomeRespAlunoMenorDados.setText("Nome Responsavel:*");

        jLabelRGRespAlunoMenorDados.setText("RG do Responsavel:*");

        jTextFieldRGRespAlunoMenorDados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRGRespAlunoMenorDadosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlunoMenorDeIdadeLayout = new javax.swing.GroupLayout(jPanelAlunoMenorDeIdade);
        jPanelAlunoMenorDeIdade.setLayout(jPanelAlunoMenorDeIdadeLayout);
        jPanelAlunoMenorDeIdadeLayout.setHorizontalGroup(
            jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoMenorDeIdadeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRGRespAlunoMenorDados)
                    .addComponent(jLabelNomeRespAlunoMenorDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNomeRespAlunoMenorDados, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(jTextFieldRGRespAlunoMenorDados)))
        );
        jPanelAlunoMenorDeIdadeLayout.setVerticalGroup(
            jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoMenorDeIdadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeRespAlunoMenorDados)
                    .addComponent(jTextFieldNomeRespAlunoMenorDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAlunoMenorDeIdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRGRespAlunoMenorDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRGRespAlunoMenorDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            jFormattedTextFieldTelefoneAlunoDados.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonSalvarAlunoDados.setText("Salvar");
        jButtonSalvarAlunoDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlunoDadosActionPerformed(evt);
            }
        });

        jButtonVoltarAlunoDados.setText("Voltar");
        jButtonVoltarAlunoDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarAlunoDadosActionPerformed(evt);
            }
        });

        jLabelModalidadeAlunoDados.setText("Modalidade do aluno:");

        jScrollPaneModalidades.setViewportView(jListModalidades);

        javax.swing.GroupLayout jPanelAlunoDadosLayout = new javax.swing.GroupLayout(jPanelAlunoDados);
        jPanelAlunoDados.setLayout(jPanelAlunoDadosLayout);
        jPanelAlunoDadosLayout.setHorizontalGroup(
            jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                                .addComponent(jButtonVoltarAlunoDados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSalvarAlunoDados))
                            .addComponent(jPanelAlunoMenorDeIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlunoDadosLayout.createSequentialGroup()
                                .addComponent(jLabelIdadeAlunoDados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldIdadeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabelRGAlunoDados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRGAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabelTelefoneAlunoDados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTelefoneAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelEnderecoAlunoDados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldEnderecoAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelModalidadeAlunoDados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxModalidadeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelMatriculaDados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNroMatriculaAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNomeAlunoDados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNomeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPaneModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelLembreteIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAlunoDadosLayout.setVerticalGroup(
            jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelMatriculaDados)
                        .addComponent(jLabelNomeAlunoDados)
                        .addComponent(jTextFieldNomeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNroMatriculaAlunoDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLembreteIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdadeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdadeAlunoDados)
                    .addComponent(jTextFieldRGAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRGAlunoDados)
                    .addComponent(jFormattedTextFieldTelefoneAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefoneAlunoDados))
                .addGap(18, 18, 18)
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnderecoAlunoDados)
                    .addComponent(jTextFieldEnderecoAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModalidadeAlunoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModalidadeAlunoDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanelAlunoMenorDeIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlunoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlunoDadosLayout.createSequentialGroup()
                        .addComponent(jButtonVoltarAlunoDados)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlunoDadosLayout.createSequentialGroup()
                        .addComponent(jButtonSalvarAlunoDados)
                        .addGap(18, 18, 18))))
        );

        jTabbedPaneGerenciadorAlunos.addTab("Dados", jPanelAlunoDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneGerenciadorAlunos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneGerenciadorAlunos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdadeAlunoDadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdadeAlunoDadosKeyTyped
        // TODO add your handling code here:
        soNumeros(evt);
    }//GEN-LAST:event_jTextFieldIdadeAlunoDadosKeyTyped

    private void jTextFieldRGAlunoDadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGAlunoDadosKeyTyped
        // TODO add your handling code here:
        soNumeros(evt);
    }//GEN-LAST:event_jTextFieldRGAlunoDadosKeyTyped

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(jTextFieldBusca.getText().trim().equals("")){
            listar();
        } else {
            if(jComboBoxTipoBusca.getSelectedItem().toString().equals("Nome") && c != '\n' 
                    && (Character.isLetter(c) || Character.isDigit(c))){
                listarNome();
            } else if(jComboBoxTipoBusca.getSelectedItem().toString().equals("Matricula") && c != '\n'
                    && Character.isDigit(c)){
                listarMatricula();
            }
        }
    }//GEN-LAST:event_jTextFieldBuscaKeyReleased

    private void jComboBoxTipoBuscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoBuscaItemStateChanged
        // TODO add your handling code here:
        jTextFieldBusca.setText("");
    }//GEN-LAST:event_jComboBoxTipoBuscaItemStateChanged

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        new Inicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyTyped
        // TODO add your handling code here:
        if(jComboBoxTipoBusca.getSelectedItem().toString().equalsIgnoreCase("Matricula")){
            soNumeros(evt);
        }
    }//GEN-LAST:event_jTextFieldBuscaKeyTyped

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        isEdit = false;
        mudarAbas(0, 1);
        ativarCampos();
        jLabelNroMatriculaAlunoDados.setText(String.valueOf(Aluno.getSequence()));
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonVoltarAlunoDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarAlunoDadosActionPerformed
        // TODO add your handling code here:
        limparCampos();
        listar();
        mudarAbas(1, 0);
    }//GEN-LAST:event_jButtonVoltarAlunoDadosActionPerformed

    private void jTextFieldIdadeAlunoDadosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdadeAlunoDadosFocusLost
        // TODO add your handling code here:
        if(!jTextFieldIdadeAlunoDados.getText().trim().equals("") && Integer.parseInt(jTextFieldIdadeAlunoDados.getText()) < 18){
            jTextFieldNomeRespAlunoMenorDados.setVisible(true);
            jLabelNomeRespAlunoMenorDados.setVisible(true);
            jLabelRGRespAlunoMenorDados.setVisible(true);
            jTextFieldRGRespAlunoMenorDados.setVisible(true);
        } else if(!jTextFieldIdadeAlunoDados.getText().trim().equals("") && Integer.parseInt(jTextFieldIdadeAlunoDados.getText()) > 17){
            jTextFieldNomeRespAlunoMenorDados.setVisible(false);
            jLabelNomeRespAlunoMenorDados.setVisible(false);
            jLabelRGRespAlunoMenorDados.setVisible(false);
            jTextFieldRGRespAlunoMenorDados.setVisible(false);
        }
        
        if(jTextFieldIdadeAlunoDados.getText().trim().equals("")){
            jLabelLembreteIdade.setText("Campo idade obrigatório e necessário para buscar turmas");
            jComboBoxModalidadeAlunoDados.setEnabled(false);
        } else if(!jTextFieldIdadeAlunoDados.getText().trim().equals("")){
            jLabelLembreteIdade.setText("");
            jComboBoxModalidadeAlunoDados.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldIdadeAlunoDadosFocusLost

    private void jButtonSalvarAlunoDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlunoDadosActionPerformed
        // TODO add your handling code here:
        Aluno a=null;
        Turma t=null;
        Long rg = 0L; 
        long telefone=0;
        
        if(!jTextFieldRGAlunoDados.getText().trim().equals("")){
            rg = Long.parseLong(jTextFieldRGAlunoDados.getText().trim());
        }
        
        if(!jFormattedTextFieldTelefoneAlunoDados.getText().trim().equals("")){
            String aux="", telefoneString=jFormattedTextFieldTelefoneAlunoDados.getText().trim();
            for (int i = 0; i < telefoneString.length(); i++) {
                if(Character.isDigit(telefoneString.charAt(i))){
                    aux += telefoneString.charAt(i);
                }
            }
            telefone = Long.parseLong(aux);
        }
        //Verificando se o campo idade foi preenchido para que assim possa saber se o aluno
        //é menor de idade ou não
        if(!jTextFieldIdadeAlunoDados.getText().trim().equals("")){
            //Verificando a idade do aluno caso seja maior de idade cria um objeto aluno
            if(Integer.parseInt(jTextFieldIdadeAlunoDados.getText()) > 18){
                if(!jTextFieldNomeAlunoDados.getText().trim().equals("")){

                    a = new Aluno(jTextFieldNomeAlunoDados.getText(), Integer.parseInt(jTextFieldIdadeAlunoDados.getText()));
                    a.setEndereco(jTextFieldEnderecoAlunoDados.getText().trim());
                    a.setTelefoneContato(telefone);
                    a.setRg(rg);
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios(*)");
                }
            //Caso o aluno seja menor de idade     
            } else {
                //Verificando se os alunos menores de idade possuem os dados mínimos
                if(jTextFieldNomeAlunoDados.getText().trim().equals("") || jTextFieldNomeRespAlunoMenorDados.getText().trim().equals("")
                        || jTextFieldRGRespAlunoMenorDados.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios(*)");
                } else {
                    a = new AlunoMenorDeIdade(jTextFieldNomeAlunoDados.getText(), jTextFieldNomeRespAlunoMenorDados.getText()
                            , Long.parseLong(jTextFieldRGRespAlunoMenorDados.getText()), Integer.parseInt(jTextFieldIdadeAlunoDados.getText()));
                    a.setEndereco(jTextFieldEnderecoAlunoDados.getText().trim());
                    a.setTelefoneContato(telefone);
                    a.setRg(rg);
                }
            }
            
            if(isEdit && a != null){
                
                if(verificacao("Deseja realmente editar o aluno? Obs.: Esta ação modificará sua matricula")){
                    if(listaAlunos.editar(getCod(), a)){
                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Aluno editado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO 02 - OCORREU UM ERRO DURANTE A EDIÇÃO");
                    }

                    listar();
                    mudarAbas(1, 0);
                }
                
                
            } else if(a != null){
                
                if(listaAlunos.incluir(a)){
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO 01 - OCORREU UM ERRO DURANTE O CADASTRO");
                }
                    
                if(verificacao("Deseja cadastrar um novo aluno?")){
                        jLabelNroMatriculaAlunoDados.setText(String.valueOf(Aluno.getSequence()));
                } else {
                        listar();
                        mudarAbas(1, 0);
                }
            }
            
            if(a != null && !jListModalidades.isSelectionEmpty()){
                t = listaTurmas.buscarTurma(getCod());
                
                if(t.addAluno(a)){
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado na turma "+t.getTurma()+" com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO 03 - OCORREU UM ERRO DURANTE O CADASTRO DO ALUNO NA TURMA OU O MESMO JÁ ESTÁ CADASTRADO NA TURMA");
                }
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios(*)");
        }
    }//GEN-LAST:event_jButtonSalvarAlunoDadosActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        listaAlunos.excluir(getCod());
        listar();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        isEdit = true;
        ativarCampos();
        preencherCampos(getCod());
        mudarAbas(0, 1);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonDetalhesAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalhesAlunoActionPerformed
        // TODO add your handling code here:
        desativarCampos(getCod());
        preencherCampos(getCod());
        mudarAbas(0, 1);
    }//GEN-LAST:event_jButtonDetalhesAlunoActionPerformed

    private void jListAlunosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListAlunosValueChanged
        // TODO add your handling code here:
        if(!jListAlunos.isSelectionEmpty()){
            jButtonExcluir.setEnabled(true);
            jButtonEditar.setEnabled(true);
            jButtonDetalhesAluno.setEnabled(true);
        } else {
            jButtonExcluir.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonDetalhesAluno.setEnabled(false);
        }
    }//GEN-LAST:event_jListAlunosValueChanged

    private void jComboBoxModalidadeAlunoDadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModalidadeAlunoDadosItemStateChanged
        // TODO add your handling code here:
        DefaultListModel listModel2 = new DefaultListModel();
        List<Turma> listaTurmas = null;
        switch(jComboBoxModalidadeAlunoDados.getSelectedItem().toString()){
            case "Futebol":
                listaTurmas = this.listaTurmas.buscarEsporte(Esporte.verificarEsporte("Futebol"));
                break;
            case "Basquete":
                listaTurmas = this.listaTurmas.buscarEsporte(Esporte.verificarEsporte("Basquete"));
                break;
            case "Voleibol":
                listaTurmas = this.listaTurmas.buscarEsporte(Esporte.verificarEsporte("Voleibol"));
                break;
        }
        
        if(listaTurmas != null){
            for (Turma turma : listaTurmas) {
                if(turma.getQuantidadeAlunos() < turma.getMAX_ALUNO()){
                    listModel2.addElement(turma.toString());
                }
            }
        }    
    }//GEN-LAST:event_jComboBoxModalidadeAlunoDadosItemStateChanged

    private void jTextFieldRGRespAlunoMenorDadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGRespAlunoMenorDadosKeyTyped
        // TODO add your handling code here:
        soNumeros(evt);
    }//GEN-LAST:event_jTextFieldRGRespAlunoMenorDadosKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciadorAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciadorAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciadorAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciadorAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciadorAlunos(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonDetalhesAluno;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvarAlunoDados;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JButton jButtonVoltarAlunoDados;
    private javax.swing.JComboBox<String> jComboBoxModalidadeAlunoDados;
    private javax.swing.JComboBox<String> jComboBoxTipoBusca;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefoneAlunoDados;
    private javax.swing.JLabel jLabelAluno;
    private javax.swing.JLabel jLabelEnderecoAlunoDados;
    private javax.swing.JLabel jLabelGerenciadorAlunos;
    private javax.swing.JLabel jLabelIdadeAlunoDados;
    private javax.swing.JLabel jLabelLembreteIdade;
    private javax.swing.JLabel jLabelMatriculaDados;
    private javax.swing.JLabel jLabelModalidadeAlunoDados;
    private javax.swing.JLabel jLabelNomeAlunoDados;
    private javax.swing.JLabel jLabelNomeRespAlunoMenorDados;
    private javax.swing.JLabel jLabelNroMatriculaAlunoDados;
    private javax.swing.JLabel jLabelRGAlunoDados;
    private javax.swing.JLabel jLabelRGRespAlunoMenorDados;
    private javax.swing.JLabel jLabelTelefoneAlunoDados;
    private javax.swing.JList<String> jListAlunos;
    private javax.swing.JList<String> jListModalidades;
    private javax.swing.JPanel jPanelAlunoDados;
    private javax.swing.JPanel jPanelAlunoMenorDeIdade;
    private javax.swing.JPanel jPanelGerenciamento;
    private javax.swing.JScrollPane jScrollPaneAlunos;
    private javax.swing.JScrollPane jScrollPaneModalidades;
    private javax.swing.JTabbedPane jTabbedPaneGerenciadorAlunos;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldEnderecoAlunoDados;
    private javax.swing.JTextField jTextFieldIdadeAlunoDados;
    private javax.swing.JTextField jTextFieldNomeAlunoDados;
    private javax.swing.JTextField jTextFieldNomeRespAlunoMenorDados;
    private javax.swing.JTextField jTextFieldRGAlunoDados;
    private javax.swing.JTextField jTextFieldRGRespAlunoMenorDados;
    // End of variables declaration//GEN-END:variables
}
