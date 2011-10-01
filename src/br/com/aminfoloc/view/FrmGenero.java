package br.com.aminfoloc.view;

import br.com.aminfoloc.helper.HibernateUtil;
import br.com.aminfoloc.helper.Util;
import br.com.aminfoloc.model.Genero;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class FrmGenero extends javax.swing.JFrame {

    DefaultTableModel modeloTabela;
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public FrmGenero() {
        initComponents();
        painelCadastro.setVisible(true);
        painelPesquisa.setVisible(false);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("CÓDIGO");
        modeloTabela.addColumn("DESCRIÇÃO");
        modeloTabela.setNumRows(0);
        tGenero.setModel(modeloTabela);
        crudNavegacao();
    }

    public void mudaPainel() {
        if (painelCadastro.isVisible()) {
            painelCadastro.setVisible(false);
            painelPesquisa.setVisible(true);
        } else {
            painelCadastro.setVisible(true);
            painelPesquisa.setVisible(false);
        }
        txtBuscar.setText("");
        crudNavegacao();
    }

    public void crudAdicao() {
        Util.ativar(this.painelCadastro);
        Util.limpar(this.painelCadastro);
        txtCodigo.setEditable(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnFechar.setEnabled(false);
    }

    public void crudEdicao() {
        Util.ativar(this.painelCadastro);
        txtCodigo.setEditable(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnFechar.setEnabled(false);
    }

    public void crudNavegacao() {
        Util.desativar(this.painelCadastro);
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnFechar.setEnabled(true);
        btnPesquisar.setEnabled(true);

        if (txtCodigo.getText().equals("")) {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
        } else {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }

    }

    public boolean generoJaExiste(String desc) {
        Session s= factory.openSession();
        List<Genero> generos = s.createCriteria(Genero.class).add(Restrictions.eq("descricao", desc)).list();

        s.clear();
        s.close();

        if (generos.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastro = new javax.swing.JPanel();
        tbGenero = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblDescricao1 = new javax.swing.JLabel();
        painelPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tGenero = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        tbGenero.setFloatable(false);
        tbGenero.setRollover(true);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        tbGenero.add(btnNovo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbGenero.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tbGenero.add(btnCancelar);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        tbGenero.add(btnSalvar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        tbGenero.add(btnExcluir);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        tbGenero.add(btnPesquisar);

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/fechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setFocusable(false);
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        tbGenero.add(btnFechar);

        lblDescricao.setText("Código:");

        lblDescricao1.setText("Descrição: ");

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao1)
                    .addComponent(lblDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addComponent(tbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao1))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(painelCadastro, "card3");

        tGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tGenero.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tGeneroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tGenero);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aminfoloc/recursos/pesquisa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        getContentPane().add(painelPesquisa, "card3");

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-450)/2, (screenSize.height-270)/2, 450, 270);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Session s= factory.openSession();
        List<Genero> lista = s.createCriteria(Genero.class).add(Restrictions.like("descricao", "%" + txtBuscar.getText() + "%")).list();
        s.clear();
        s.close();
        modeloTabela = new DefaultTableModel(null, new String[]{"CÓDIGO", "DESCRIÇÃO"});

        for (Genero g : lista) {
            modeloTabela.addRow(new Object[]{Integer.toString(g.getIdGenero()), g.getDescricao()});
        }

        tGenero.setModel(modeloTabela);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Session s= factory.openSession();

        if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A descrição não pode ser vazia.");
            txtDescricao.setFocusable(true);

        } else {
            Genero genero = new Genero();
            genero.setDescricao(txtDescricao.getText());

            if (!txtCodigo.getText().isEmpty()) {
                genero.setIdGenero(Integer.parseInt(txtCodigo.getText()));
                s.beginTransaction();
                s.update(genero);
                s.merge(genero);
                s.getTransaction().commit();
                txtCodigo.setText(Integer.toString(genero.getIdGenero()));
                txtDescricao.setText(genero.getDescricao());
                crudNavegacao();

            } else {

                if (generoJaExiste(txtDescricao.getText())) {
                    JOptionPane.showMessageDialog(null, "O genero já existe!");
                    txtDescricao.setFocusable(true);
                } else {
                    s.beginTransaction();
                    s.saveOrUpdate(genero);
                    s.merge(genero);
                    s.getTransaction().commit();
                    txtCodigo.setText(Integer.toString(genero.getIdGenero()));
                    txtDescricao.setText(genero.getDescricao());
                    crudNavegacao();
                }
            }
            s.close();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        mudaPainel();
}//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        System.exit(0);
}//GEN-LAST:event_btnFecharActionPerformed

    private void tGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tGeneroMouseClicked
        txtCodigo.setText(tGenero.getValueAt(tGenero.getSelectedRow(), 0).toString());
        txtDescricao.setText(tGenero.getValueAt(tGenero.getSelectedRow(), 1).toString());
        modeloTabela.setNumRows(0);
        mudaPainel();
    }//GEN-LAST:event_tGeneroMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        crudAdicao();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        crudEdicao();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        crudNavegacao();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        mudaPainel();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if(!txtCodigo.getText().isEmpty()){
            Session s= factory.openSession();

            Genero genero = new Genero();
            genero.setIdGenero(Integer.parseInt(txtCodigo.getText()));
            s.beginTransaction();
            s.delete(genero);
            s.getTransaction().commit();

            Util.limpar(painelCadastro);
            crudNavegacao();
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JTable tGenero;
    private javax.swing.JToolBar tbGenero;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
