package com.wrapper;


import com.utilities.EmailReport;
import org.testng.ISuite;
import org.testng.reporters.EmailableReporter;
import org.testng.xml.XmlSuite;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by shahank2 on 12/2/2016.
 */
public class SendEmailListener extends EmailableReporter //Listener to override generateReport method to force it to generate report immediately after Test Execution is complete

{

    @Override
    public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir){
        super.generateReport(xml, suites, outdir);
        EmailReport emailResult = new EmailReport();
        try {
            emailResult.sendEmail();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Listener finished");
    }

}
