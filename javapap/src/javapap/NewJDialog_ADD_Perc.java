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

/**
 *
 * @author FilipeC
 */
public class NewJDialog_ADD_Perc extends javax.swing.JDialog {
@Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(900, 235, 426, 340); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Creates new form NewJDialog_ADD_Perc
     */
    public NewJDialog_ADD_Perc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("adicionar Percurso");
        try {

            Javapap.ligacao = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapap", "root", "");
            Javapap.expressao = Javapap.ligacao.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        f();
    }

    private void f() {
        try {
            String SQL = "SELECT Nome_perc from percursos;";
            Javapap.resultado = Javapap.expressao.executeQuery(SQL);

            while (Javapap.resultado.next()) {
                String name = Javapap.resultado.getString("Nome_perc");
                jComboBox_Percs.addItem(name);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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

        jComboBox_Percs = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton_Ins_Perc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox_PE = new javax.swing.JCheckBox();
        jCheckBox_BIKE = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        getContentPane().add(jComboBox_Percs);
        jComboBox_Percs.setBounds(126, 31, 253, 26);

        jLabel1.setText("Percurso realizado:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 36, 114, 16);

        jButton_Ins_Perc.setText("Inserir Percurso");
        jButton_Ins_Perc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ins_PercActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Ins_Perc);
        jButton_Ins_Perc.setBounds(116, 135, 212, 142);

        jLabel2.setBackground(new java.awt.Color(60, 63, 0));
        jLabel2.setText("Modo de locomo????o");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(6, 79, 114, 16);

        jCheckBox_PE.setText("A p??");
        getContentPane().add(jCheckBox_PE);
        jCheckBox_PE.setBounds(138, 75, 53, 24);

        jCheckBox_BIKE.setText("De bicicleta");
        getContentPane().add(jCheckBox_BIKE);
        jCheckBox_BIKE.setBounds(209, 75, 94, 24);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Filipe Correia\\Desktop\\1-42.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-9, -4, 420, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Ins_PercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ins_PercActionPerformed

        if ((jCheckBox_PE.isSelected()) && (jCheckBox_BIKE.isSelected())) {

            
            jCheckBox_BIKE.setSelected(false);
            jCheckBox_PE.setSelected(false);
            

        } else if (jCheckBox_BIKE.isSelected()) {

            String id = Javapap.ID;
            String comboop = jComboBox_Percs.getSelectedItem().toString();

            try {
                String SQL = "SELECT * from percursos where Nome_perc = '" + comboop + "';";
                Javapap.resultado = Javapap.expressao.executeQuery(SQL);
                Javapap.resultado.next();
                String cidade = Javapap.resultado.getString("Cidade");
                String Km = Javapap.resultado.getString("Km");
                String ID_P = Javapap.resultado.getString("ID_Percurso");

                String SQLU = "INSERT INTO percurso_realizado (ID_user, cidade, locomocao, Km, ID_perc) VALUES ('" + id + "', '" + cidade + "', 'Bicicleta', '" + Km + "', '" + ID_P + "');";
                Javapap.expressao.executeUpdate(SQLU);
                jCheckBox_BIKE.setSelected(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } else if (jCheckBox_PE.isSelected()) {
            String id = Javapap.IDU;
            JOptionPane.showMessageDialog(null, Javapap.IDU);
            String comboop = jComboBox_Percs.getSelectedItem().toString();

            try {
                String SQL = "SELECT * from percursos where Nome_perc = '" + comboop + "';";
                Javapap.resultado = Javapap.expressao.executeQuery(SQL);
                Javapap.resultado.next();
                String cidade = Javapap.resultado.getString("Cidade");
                String Km = Javapap.resultado.getString("Km");
                String ID_P = Javapap.resultado.getString("ID_Percurso");

                String SQLU = "INSERT INTO percurso_realizado (ID_user, cidade, locomocao, Km, ID_perc) VALUES ('" + Javapap.IDU + "', '" + cidade + "', 'P??', '" + Km + "', '" + ID_P + "');";
                Javapap.expressao.executeUpdate(SQLU);
                jCheckBox_PE.setSelected(false);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Tens de escolher um modo de locomo????o");
        }


    }//GEN-LAST:event_jButton_Ins_PercActionPerformed

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
            java.util.logging.Logger.getLogger(NewJDialog_ADD_Perc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_ADD_Perc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_ADD_Perc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJDialog_ADD_Perc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog_ADD_Perc dialog = new NewJDialog_ADD_Perc(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Ins_Perc;
    private javax.swing.JCheckBox jCheckBox_BIKE;
    private javax.swing.JCheckBox jCheckBox_PE;
    private javax.swing.JComboBox<String> jComboBox_Percs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
