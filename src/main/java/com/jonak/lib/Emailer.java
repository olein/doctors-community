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

    private String from;
    private String password;
    private String to;
    private String subject;
    private String body;
    private Properties properties;

    public Emailer() throws Exception
    {
        // from detail
        // will be changed later
        this.from = "jucse2014@gmail.com";
        this.password = "jucse192014";

        this.properties = new Properties();
    }

    public void send() throws Exception
    {
        try
        {
            // set smtp details
            this.properties.put("mail.smtp.host", "smtp.gmail.com");
            this.properties.put("mail.smtp.socketFactory.port", "465");
            this.properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            this.properties.put("mail.smtp.auth", "true");
            this.properties.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance( this.properties,
                                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication
                        getPasswordAuthentication() { return new PasswordAuthentication( from, password ); }}
                                );
            // set mail property
            Message message = new MimeMessage( session );
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.to));
            message.setSubject(this.subject);
            message.setContent( this.body, "text/html; charset=utf-8" );
            // send mail
            Transport.send(message);
        } catch(Exception e) {
            e.printStackTrace();
        }
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
}