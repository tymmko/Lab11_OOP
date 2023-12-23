package ua.edu.ucu.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MailInfo {
    @Getter @Setter
    private Client client;
    @Getter @Setter
    private MailCode mailcode;

    public String generate(){
        return mailcode.generateText(client);
    }
}