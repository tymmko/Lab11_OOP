package ua.edu.ucu.task1;

public class App 
{
    public static void main( String[] args ) {
        User user = Student.builder().name("Tymofii").age(18).grade(99).grade(80).grade(100).gender("m").build();
        System.out.println(user);
    }
}
