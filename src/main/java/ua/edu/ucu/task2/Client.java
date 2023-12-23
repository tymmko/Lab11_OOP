package ua.edu.ucu.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

enum Gender {
    MALE, FEMALE;
}
@AllArgsConstructor
@Setter @Getter
public class Client {
    private static int counter = 0;
    private String name;
    private String email;
    private Gender gender;
    private int id;
    private int age;

    public Client(String name, String email, Gender gender, int age) {
        this.id = ++counter;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }
}