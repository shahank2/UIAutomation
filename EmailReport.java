package com.utilities;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class EmailReport //To email TestNG (emailable Report.html) file to intended recipient list after execution of Test Suite

{


    public void sendEmail() throws IOException, MessagingException //Method to connect to mail server, load new email, type "To", "From" list: Attach report file and send it to recipient list

    {    // Get session object


        try{
            Properties props = new Properties();
            props.put("mail.smtp.host", "mailhost.xxxx.com");
            props.put("mail.smtp.auth", "false");
            props.put("mail.debug", "true");
            props.put("mail.smtp.port", "25");
            Session session = Session.getDefaultInstance(props);

           // Part two is attachment
            BodyPart messageBodyPart = new MimeBodyPart();
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("ankit.shah.6@xxxx.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("ankit.shah.6@xxxx.com"));
            msg.setSubject("Selenium Test Report");
            msg.setText("Test Report");

            Multipart multipart = new MimeMultipart();
            String basePath = System.getProperty("user.dir");
            String filename = basePath + "/test-output/emailable-report.html";
//            String filename = basePath + "/Selenium-emailable-report.html";
            System.out.println("Output File name " + filename);
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            msg.setContent(multipart );

            // Send message
            Transport.send(msg);
            System.out.println("Sent message successfully....");
           }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}