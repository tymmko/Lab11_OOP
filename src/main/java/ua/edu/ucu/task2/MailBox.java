package ua.edu.ucu.task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<MailInfo> infos = new ArrayList<>();
    private MailSender mailSender = new MailSender();

    public void addMailInfo(MailInfo maiInfo){
        if (infos.contains(maiInfo)){
            System.out.println("This request already exists");
        }
        else{
            infos.add(maiInfo);
        }
    }
    public void sendAll() throws MailjetSocketTimeoutException, MailjetException {
        for (MailInfo mail : infos) {
            MailSender.sendMail(mail);
        }
    }
}