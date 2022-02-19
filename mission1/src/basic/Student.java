package basic;

public class Student extends AbstractPerson implements Person{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("저는 %s이고, 학생입니다.", getName()));
    }

}
