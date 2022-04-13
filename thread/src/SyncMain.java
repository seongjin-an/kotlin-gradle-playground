
class Bank{
    private int money = 10000;

    public /*synchronized*/ void saveMoney(int save){
        int m = getMoney();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m + save);
    }
    public void minusMoney(int minus){
//        synchronized (this) {
            int m = getMoney();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setMoney(m - minus);
//        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
//1.메서 타입 앞에 synchronized: 어떤 쓰레드가 synchronized 메서드를 수행하는 동안 해당 메서드가 포함된 객체에 락을 건다.
//2.함수 내부 synchronized(obj){} 블럭: obj에다가 락을 건다.

class Park extends Thread{
    @Override
    public void run() {
        synchronized (SyncMain.myBank) {
            System.out.println("start save");
            SyncMain.myBank.saveMoney(3000);
            System.out.println("saveMoney(3000): " + SyncMain.myBank.getMoney());
        }
    }
}

class ParkWife extends Thread {
    @Override
    public void run() {
        synchronized (SyncMain.myBank) {
            System.out.println("start minus");
            SyncMain.myBank.minusMoney(1000);
            System.out.println("minusMoney(1000): " + SyncMain.myBank.getMoney());
        }
    }
}

public class SyncMain {
    public static Bank myBank = new Bank();
    public static void main(String[] args){
        Park p = new Park();
        p.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ParkWife pw = new ParkWife();
        pw.start();

    }
}
