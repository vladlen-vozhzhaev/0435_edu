public class ATM {
    int money;
    public ATM(int money){
        this.money = money;
    }
    public synchronized void take(int amount, String user){
        if (money >= amount){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("Выдано: "+amount+"RUB Пользователю: "+user);
        }else{
            System.out.println("Денег нет!");
        }
    }
    public void info(){
        System.out.println("Остаток в ATM: "+money+"RUB");
    }
}

class MainAtm {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(500,"USER_1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(500,"USER_2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(500,"USER_3");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        atm.info();
    }
}
