/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapap;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author FilipeC
 */
public class NewJDialog_Ins_Locais extends javax.swing.JDialog {
@Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(900, 235, 490, 380); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Creates new form NewJDialog_Ins_Locais
     */
    public NewJDialog_Ins_Locais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Inserir Locais");
        try {

            Javapap.ligacao = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapap", "root", "");
            Javapap.expressao = Javapap.ligacao.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_Ins = new javax.swing.JButton();
        jTextField_Cidade = new javax.swing.JTextField();
        jTextField_Local = new javax.swing.JTextField();
        jButton_Back = new javax.swing.JButton();
        jComboBox_Loc = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Regi??o");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(36, 30, 39, 16);

        jLabel2.setText("Cidade");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(36, 73, 39, 16);

        jLabel3.setText("Local");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(36, 125, 31, 16);

        jButton_Ins.setText("Inserir");
        jButton_Ins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Ins);
        jButton_Ins.setBounds(153, 199, 67, 32);
        getContentPane().add(jTextField_Cidade);
        jTextField_Cidade.setBounds(81, 69, 158, 24);
        getContentPane().add(jTextField_Local);
        jTextField_Local.setBounds(73, 121, 158, 24);

        jButton_Back.setText("Voltar ao menu");
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back);
        jButton_Back.setBounds(316, 242, 116, 32);

        jComboBox_Loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Norte", "Centro", "Sul" }));
        getContentPane().add(jComboBox_Loc);
        jComboBox_Loc.setBounds(81, 25, 158, 26);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Filipe Correia\\Desktop\\locais-magnificos-portugal-berlengas-2.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 480, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_InsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsActionPerformed
        try {
            String a = "";

            String Reg = jComboBox_Loc.getSelectedItem().toString();
            String Cidade = jTextField_Cidade.getText();
            String Local = jTextField_Local.getText();
            
            String SQL = "INSERT INTO local (Regiao, Cidades_Reg, ID_User, ID, Local) VALUES ('"+Reg+"', '"+Cidade+"', '2', NULL, '"+Local+"');";
            Javapap.expressao.executeUpdate(SQL);
            String SQL1 = "SELECT ID from local where Local = '" + Local + "';";
            Javapap.resultado = Javapap.expressao.executeQuery(SQL1);
            Javapap.resultado.next();
            Javapap.ID = Javapap.resultado.getString(1);
            jTextField_Cidade.setText(a);
            jTextField_Local.setText(a);
            jComboBox_Loc.setSelectedItem(a);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton_InsActionPerformed

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

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
            java.util.logging.Logger.getLogger(NewJDialog_Ins_Locais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_Ins_Locais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_Ins_Locais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_Ins_Locais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog_Ins_Locais dialog = new NewJDialog_Ins_Locais(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Ins;
    private javax.swing.JComboBox<String> jComboBox_Loc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField_Cidade;
    private javax.swing.JTextField jTextField_Local;
    // End of variables declaration//GEN-END:variables
}
