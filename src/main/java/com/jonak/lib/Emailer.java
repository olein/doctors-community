package com.jonak.lib;

/**
 * Created by Fahim on 09/11/2014.
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class Emailer extends ActionSupport {

    private static String from = "jucse2014@gmail.com";
    private static String password = "jucse192014";
    private static String to = " ";
    private static String subject = "No reply please";
    private static String body;

    static Properties properties = new Properties();
    static
    {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    public static String sendEmail(int timestamp)
    {
        String result = "success";
        try
        {
            Session session = Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication
                        getPasswordAuthentication() {
                            return new
                                    PasswordAuthentication(from, password);
                        }});

            to = ServletActionContext.getRequest().getParameter("email");

            body = "please click the following link: "+ "http://localhost:8080/DoctorCommunity/resetpassword?key="+timestamp+
                    "\n"+"If you did not request for password request then click the following link:'"+
                    "http://localhost:8080/DoctorCommunity/nopasswordreset?key="+timestamp;

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        }
        catch(Exception e)
        {
            result = "error";
            e.printStackTrace();
        }
        return result;
    }





    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Emailer.properties = properties;
    }
}