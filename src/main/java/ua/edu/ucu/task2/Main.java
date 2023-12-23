package ua.edu.ucu.task2;
import com.mailjet.client.errors.*;

public class Main {
    public static void main(String[] args) {
        try {
            MailBox mailbox = new MailBox();
            Client client = new Client("Tim", "tim@email.com", Gender.MALE, 18);
            MailInfo mailInfo = new MailInfo(client, new HappyBirthdayMailCode());
            mailbox.addMailInfo(mailInfo);
            mailbox.sendAll();
        } catch (MailjetSocketTimeoutException | MailjetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
