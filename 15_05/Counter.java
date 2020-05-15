public class Counter {
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000000; i++){
                    test.inc();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000000; i++){
                    test.dec();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(test.getC());
    }

}
class Test {
    int c;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public synchronized void inc(){c++;}
    public synchronized void dec(){c--;}
    public Test(){
        this.c = 0;
    }
}
