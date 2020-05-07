public class Main{
    public static void main(String[] args) {
        System.out.println(Horse.info);
    }
}

interface AnimalInterface{
    void run();
    void say();
}


abstract class Animal implements AnimalInterface{
    private String name;
    private short age;
    public Animal(String name, short age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public short getAge() {
        return age;
    }
    public void run(){
        System.out.println("Животное "+this.name+" бежит");
    }
    public void run(int velocity){
        System.out.println("Животное "+this.name+" бежит со скоростью "+velocity+"км/ч");
    }
    public void say(){
        System.out.println("Животное "+this.name+" говорит");
    }
}

class Horse extends Animal{
    public static String info = "Это класс лошади";
    public Horse(String name, short age) {
        super(name,age);
    }
    @Override
    public void run(){
        System.out.println("Лошадь "+super.getName()+" скачет");
    }
    @Override
    public void run(int velocity){
        if (velocity < 65 && velocity > 0)
            System.out.println("Лошадь "+super.getName()+" скачет со скоростью"+velocity+"км/ч");
        else System.out.println("Лошадь не может бежать с такой скоростью");
    }
    @Override
    public void say(){
        System.out.println("Лошадь "+super.getName()+" игого");
    }
}

class Cat extends Animal{
    Cat (String name, short age){
        super(name,age);
    }
    @Override
    public void run(){
        System.out.println("Кот "+super.getName()+" бежит");
    }
    @Override
    public void say(){
        System.out.println("Кот "+super.getName()+" говорит: Мяу мяу");
    }
}
