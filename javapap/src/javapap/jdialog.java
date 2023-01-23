/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapap;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author FilipeC
 */
public class jdialog {
    public static void f(JList jList1){
    try {
            DefaultListModel DML = new DefaultListModel();
            String SQL = "SELECT * from user";
            Javapap.resultado = Javapap.expressao.executeQuery(SQL);
            while (Javapap.resultado.next()) {
                String nome = Javapap.resultado.getString("Nome_user");
                DML.addElement(nome);
            }
            jList1.setModel(DML);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }}
}
