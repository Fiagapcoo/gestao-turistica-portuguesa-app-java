package javapap;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gonçalo EEEEE... AJUDA! do Filipe
 */
public class Tabela {
    public static void Tabela(JTable jTable_perc){
        try {
                JOptionPane.showMessageDialog(null, Javapap.IDU);
            String SQL2 = "SELECT * FROM percurso_realizado where ID_user='"+Javapap.IDU+"'";
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewJDialog_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
