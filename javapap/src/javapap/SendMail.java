 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapap;

/**
 *
 * @author FilipeC
 */

import static com.sun.javafx.animation.TickCalculation.sub;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
public class SendMail {
        
    public static void send(String para, String assunto, String mensagem, final String user, final String pass_e) {
        
        Properties props = new Properties();
        
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        
        Session session = Session.getDefaultInstance(props, new Authenticator() {
           @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(user, pass_e);
            }
        
        
        
        
        }
        
        
        
        
        );
        try{
            Message message = new MimeMessage(session);
            
            message.setFrom( new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO , InternetAddress.parse(para));
            message.setSubject(assunto);
            message.setText(mensagem);
            Transport.send(message);
            
            JOptionPane.showMessageDialog(null, "Email enviado");
        }catch (MessagingException e){
            JOptionPane.showMessageDialog(null, "Algo aconteceu!");
            throw new RuntimeException(e);
        }
        
   }
}
