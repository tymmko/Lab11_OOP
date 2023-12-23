package ua.edu.ucu.task2;

public interface MailCode {
    String generateText(Client client);
}

class HappyBirthdayMailCode implements MailCode {
    public String generateText(Client client) {
        return "Happy Birthday " + client.getName() + "!";
    }
}
