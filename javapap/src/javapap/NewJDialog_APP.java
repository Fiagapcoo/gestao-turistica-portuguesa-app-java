/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapap;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

/**
 *
 * @author Filipe Correia
 */
public class NewJDialog_APP extends javax.swing.JDialog {

    public boolean carrega_tabela;

    public NewJDialog_APP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("aplicação");
        
        //f1();
        jButton_Carregar_TabelaActionPerformed(new ActionEvent(jButton_Carregar_Tabela, ActionEvent.ACTION_PERFORMED, ""));
        carrega_tabela = false;
        try {

            Javapap.ligacao = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapap", "root", "");
            Javapap.expressao = Javapap.ligacao.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tabela.Tabela(jTable_perc);
    }

    public void f1() {
        if (!carrega_tabela) {
            try {
                String SQL2 = "SELECT * FROM percurso_realizado where ID_user='" + Javapap.IDU + "'";
                Javapap.resultado = Javapap.expressao.executeQuery(SQL2);
                while (Javapap.resultado.next()) {
                    String ID_user = String.valueOf(Javapap.resultado.getInt("ID_user"));
                    String cidade = Javapap.resultado.getString("cidade");
                    String locomocao = Javapap.resultado.getString("locomocao");
                    String km = String.valueOf(Javapap.resultado.getInt("km"));
                    String ID_Perc = String.valueOf(Javapap.resultado.getInt("ID_Perc"));

                    String tbData[] = {ID_user, cidade, locomocao, km, ID_Perc};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_perc.getModel();
                    tblModel.addRow(tbData);
                    jTable_perc.setModel(tblModel);
                    carrega_tabela = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_perc = new javax.swing.JTable();
        jButton_PDF = new javax.swing.JButton();
        jButton_Carregar_Tabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable_perc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID User", "Cidade", "Locomoção", "Distancia(KM)", "ID Percurso"
            }
        ));
        jScrollPane2.setViewportView(jTable_perc);

        jButton_PDF.setText("Gerar pdf");
        jButton_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PDFActionPerformed(evt);
            }
        });

        jButton_Carregar_Tabela.setText("Carrega_Tabela");
        jButton_Carregar_Tabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Carregar_TabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jButton_Carregar_Tabela)
                .addGap(74, 74, 74)
                .addComponent(jButton_PDF)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton_PDF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton_Carregar_Tabela)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PDFActionPerformed
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("percurso.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(jTable_perc.getColumnCount());
            //adding table headers
            for (int i = 0; i < jTable_perc.getColumnCount(); i++) {
                pdfTable.addCell(jTable_perc.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < jTable_perc.getRowCount(); rows++) {
                for (int cols = 0; cols < jTable_perc.getColumnCount(); cols++) {
                    pdfTable.addCell(jTable_perc.getModel().getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.close();
            JOptionPane.showMessageDialog(null, "O seu ficheiro foi salvo com o nome: percurso.pdf ");
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException ex2) {
            JOptionPane.showMessageDialog(null, ex2);
        }


    }//GEN-LAST:event_jButton_PDFActionPerformed

    private void jButton_Carregar_TabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Carregar_TabelaActionPerformed
        if (!carrega_tabela) {
            try {
                String SQL2 = "SELECT * FROM percurso_realizado where ID_user='" + Javapap.IDU + "'";
                Javapap.resultado = Javapap.expressao.executeQuery(SQL2);
                while (Javapap.resultado.next()) {
                    String ID_user = String.valueOf(Javapap.resultado.getInt("ID_user"));
                    String cidade = Javapap.resultado.getString("cidade");
                    String locomocao = Javapap.resultado.getString("locomocao");
                    String km = String.valueOf(Javapap.resultado.getString("km"));
                    String ID_Perc = String.valueOf(Javapap.resultado.getString("ID_Perc"));

                    String tbData[] = {ID_user, cidade, locomocao, km, ID_Perc};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_perc.getModel();
                    tblModel.addRow(tbData);
                    jTable_perc.setModel(tblModel);
                    carrega_tabela = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_Carregar_TabelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog_APP dialog = new NewJDialog_APP(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Carregar_Tabela;
    private javax.swing.JButton jButton_PDF;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_perc;
    // End of variables declaration//GEN-END:variables
}