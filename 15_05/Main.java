public class Main {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(new MyRunnableClass());
        Thread t2 = new Thread(new MyRunnableClass());

        t1.start();
        t2.start();*/

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Поток: t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Поток: t2");
            }
        });

        t1.start();


        try {
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t2.start();

    }
}



class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<100; i++){
            System.out.println(i);
        }
    }
}

class MyThread extends Thread {
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println(i);
        }
    }
}
