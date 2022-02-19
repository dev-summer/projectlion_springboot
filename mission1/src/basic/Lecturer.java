package basic;

public class Lecturer extends AbstractPerson{

    public Lecturer(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("저는 " + getName() + "이고, 강사입니다.");
    }

}
