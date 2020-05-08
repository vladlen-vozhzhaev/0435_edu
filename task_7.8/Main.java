/* Добавить одну операцию по преобразованию типа, чтобы на экран вывелось 9
short number = 9;
char zero = '0';
int nine = (zero + number);*/

public class Main {
    public static void main(String[] args) {
        short number = 9;
        char zero = '0';
        int nine = (zero + number);
        System.out.println(nine);
    }
}
