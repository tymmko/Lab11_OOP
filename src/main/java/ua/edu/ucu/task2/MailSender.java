package ua.edu.ucu.task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {

    private static final String SENDER_EMAIL = "tarasenko.pn@ucu.edu.ua";
    private static final String SENDER_NAME = "Tymofii Tarasenko";
    public static void sendMail(MailInfo info) throws MailjetSocketTimeoutException, MailjetException {
        String emailDetails = info.generate();

        MailjetClient mailjetClient = new MailjetClient(
                System.getenv("API_KEY"),
                System.getenv("API_SECRET"),
                new ClientOptions("v3.1"));

        JSONObject emailContent = new JSONObject()
                .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", SENDER_EMAIL)
                        .put("Name", SENDER_NAME))
                .put(Emailv31.Message.TO, new JSONArray().put(new JSONObject()
                        .put("Email", info.getClient().getEmail())
                        .put("Name", info.getClient().getName())))
                .put(Emailv31.Message.SUBJECT, "")
                .put(Emailv31.Message.TEXTPART, emailDetails)
                .put(Emailv31.Message.HTMLPART, "")
                .put(Emailv31.Message.CUSTOMID, "");

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray().put(emailContent));

        MailjetResponse response = mailjetClient.post(request);

        if (response.getStatus() == 200) {
            System.out.println("Email sent successfully");
        } else {
            System.out.println("Email failed to send with status: " + response.getStatus());
        }
    }
}
