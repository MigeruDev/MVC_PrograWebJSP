package Model.DAO;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;

import Model.VO.EmailVO;

public class Envio_Email {

	public static void sendFromGMail(EmailVO email) {
		

		/**
		 * Correo de envío
		 */
		String from = "benitocamelasmaria";
		email.setFrom(from);
		String pass = "a123456789.";
		email.setPass(pass);
		
		String[] to = email.getTo();
		
		String subject = "Reporte de Usuarios";
		email.setSubject(subject);
		
		String body = email.getBody();
        
		Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        //MimeMessage message = new MimeMessage(session);
        BodyPart texto = new MimeBodyPart();
        BodyPart adjunto = new MimeBodyPart();
        
        JFileChooser archivo = new JFileChooser();
        String nombre_ruta_archivo = "";
        String nombre_archivo = "";
        try {
            
            texto.setText(body);
            archivo.showOpenDialog(null);

            int seleccion = archivo.showOpenDialog(null);
            if(seleccion == JFileChooser.APPROVE_OPTION){
                File fichero = archivo.getSelectedFile();
                nombre_ruta_archivo = fichero.getAbsolutePath();
                nombre_archivo = fichero.getName();
            }
                    
                    
            adjunto.setDataHandler(new DataHandler
                (new FileDataSource(
                nombre_ruta_archivo)));
            adjunto.setFileName(nombre_archivo);
            
            //Multiparte para agrupar texto e imagen
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            
            //Se compone el correo
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            message.setContent(multiParte);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
	
	
}
