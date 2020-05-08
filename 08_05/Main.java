public class Main  {
    public static void main(String[] args) {
        Person Alex = new Person("Alex",44);
        Alex.addCat("Murka",(short)4);
        System.out.println(Alex.cat.getName());
    }

}
class Person{
    String name;
    short age;
    Cat cat;
    public Person(String name, int age) {
        this.name = name;
        this.age = (short)age;
    }
    public String getName() { return name; }
    public short getAge() { return age; }
    public void addCat(String name, short age){
        cat = new Cat(name,age);
    }
    class Cat{
        String name;
        short age;
        public Cat(String name, short age) {
            this.name = name;
            this.age = age;
        }
        public String getName() { return name; }
        public short getAge() { return age; }
    }
}
