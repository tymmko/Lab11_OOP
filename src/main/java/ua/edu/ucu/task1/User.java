package ua.edu.ucu.task1;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder @ToString
public class User {
    private String name;
    private int age; 
    private String gender;
    // @Singular
    // private List<Integer> grades; 

}
