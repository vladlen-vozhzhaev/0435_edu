/*
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должен возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.*/
public class Main {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return null;
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return null;
    }

    static class School /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
