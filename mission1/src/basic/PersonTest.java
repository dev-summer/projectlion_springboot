package basic;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Student("Amy", 20);
        person1.speak();

        Person person2 = new Lecturer("Sam", 50);
        person2.speak();

        // 이지영 jyerin0812@gmail.com 미션 다시 작성하여 제출합니다.

        List<Person> everyone = new ArrayList<>();
        everyone.add(person1);
        everyone.add(person2);

        for (Person person: everyone) {
            person.speak();
        }
    }
}
