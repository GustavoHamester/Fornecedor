/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.telas;

import br.senac.conexaoBD.Conexao;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jdk.nashorn.internal.objects.NativeRegExp;
import net.proteanit.sql.DbUtils;


public class frm_Buscar extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement ps = null;//prepara a consulta para fornecer parametros
    ResultSet rs = null;

    public frm_Buscar() {
        initComponents();
        conexao = Conexao.Conector();
    }
    frm_Contatos carregaSelecionado = new frm_Contatos();

    private void selecionaDadoFiltrado() {
        int index = tbLista.getSelectedRow();
        TableModel model = tbLista.getModel();
        String id = model.getValueAt(index, 0).toString();
        String nome = model.getValueAt(index, 1).toString();
        String telefone = model.getValueAt(index, 2).toString();
        String email = model.getValueAt(index, 3).toString();
        String sexo = model.getValueAt(index, 4).toString();
        String endereco = model.getValueAt(index, 5).toString();
        String bairro = model.getValueAt(index, 6).toString();
        String cidade = model.getValueAt(index, 7).toString();
        String cep = model.getValueAt(index, 8).toString();
        String uf = model.getValueAt(index, 9).toString();

        carregaSelecionado.setVisible(true);
        carregaSelecionado.pack();
        carregaSelecionado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregaSelecionado.txtID.setText(id);
        carregaSelecionado.txtNome.setText(nome);
        carregaSelecionado.txtTelefone.setText(telefone);
        carregaSelecionado.txtEmail.setText(email);
        switch (sexo) {
            case "Masculino":
                carregaSelecionado.cbSexo.setSelectedIndex(0);
                break;
            case "Feminino":
                carregaSelecionado.cbSexo.setSelectedIndex(1);
                break;
            default:
                carregaSelecionado.cbSexo.setSelectedIndex(-1);
                break;
        }
        carregaSelecionado.txtEndereco.setText(endereco);
        carregaSelecionado.txtBairro.setText(bairro);
        carregaSelecionado.txtCidade.setText(cidade);
        carregaSelecionado.txtCEP.setText(cep);
        switch (uf) {
            case "AC":
                carregaSelecionado.cbUF.setSelectedIndex(0);
                break;
            case "AM":
                carregaSelecionado.cbUF.setSelectedIndex(1);
                break;
            case "RR":
                carregaSelecionado.cbUF.setSelectedIndex(2);
                break;
            case "PA":
                carregaSelecionado.cbUF.setSelectedIndex(3);
                break;
            case "AP":
                carregaSelecionado.cbUF.setSelectedIndex(4);
                break;
            case "TO":
                carregaSelecionado.cbUF.setSelectedIndex(5);
                break;
            case "MA":
                carregaSelecionado.cbUF.setSelectedIndex(6);
                break;
            case "PI":
                carregaSelecionado.cbUF.setSelectedIndex(7);
                break;
            case "CE":
                carregaSelecionado.cbUF.setSelectedIndex(8);
                break;
            case "RN":
                carregaSelecionado.cbUF.setSelectedIndex(9);
                break;
            case "PB":
                carregaSelecionado.cbUF.setSelectedIndex(10);
                break;
            case "PE":
                carregaSelecionado.cbUF.setSelectedIndex(11);
                break;
            case "AL":
                carregaSelecionado.cbUF.setSelectedIndex(12);
                break;
            case "SE":
                carregaSelecionado.cbUF.setSelectedIndex(13);
                break;
            case "BA":
                carregaSelecionado.cbUF.setSelectedIndex(14);
                break;
            case "MG":
                carregaSelecionado.cbUF.setSelectedIndex(15);
                break;
            case "ES":
                carregaSelecionado.cbUF.setSelectedIndex(16);
                break;
            case "RJ":
                carregaSelecionado.cbUF.setSelectedIndex(17);
                break;
            case "SP":
                carregaSelecionado.cbUF.setSelectedIndex(18);
                break;
            case "PR":
                carregaSelecionado.cbUF.setSelectedIndex(19);
                break;
            case "SC":
                carregaSelecionado.cbUF.setSelectedIndex(20);
                break;
            case "RS":
                carregaSelecionado.cbUF.setSelectedIndex(21);
                break;
            case "MS":
                carregaSelecionado.cbUF.setSelectedIndex(22);
                break;
            case "MT":
                carregaSelecionado.cbUF.setSelectedIndex(23);
                break;
            case "GO":
                carregaSelecionado.cbUF.setSelectedIndex(24);
                break;
            case "DF":
                carregaSelecionado.cbUF.setSelectedIndex(25);
                break;
        }
        dispose();
    }

    private void pesquisar_usuario() {
        String sql = "Select * From contatos Where nome_contato like = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtBuscar.getText() + "%");
            rs = ps.executeQuery();
            tbLista.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void carregaDadosTabelaPesquisarContato() {
        String sql = "Select * from contatos";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            tbLista.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLista);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSelecionar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        pesquisar_usuario();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregaDadosTabelaPesquisarContato();
    }//GEN-LAST:event_formWindowOpened

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        selecionaDadoFiltrado();
    }//GEN-LAST:event_btnSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
