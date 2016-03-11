/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.logic.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Отправка почты
 *
 * @author apopovkin
 */
public class mail {

    /**
     * Отправка письма по электронной почте
     * @param hostName имя хоста
     * @param host Ip хоста
     * @param fromMailUser адрес отправителя
     * @param toMailUser адрес получателя
     * @param subject тема
     * @param content "text/html; charset=windows-1251"
     * @param text текст сообщения
     */
    public void doMail(String hostName, String host, String fromMailUser, String toMailUser, String subject, String content, String text) {

        Properties properties = System.getProperties();
        properties.setProperty(hostName, host);
        Session session1 = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session1);
            message.setFrom(new InternetAddress(fromMailUser));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toMailUser));
            message.setSubject(subject);
            message.setContent(text, "text/html; charset=UTF-8");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
