package by.it.szamostyanin.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("=== Shop opened ===");
        int buyerNumber = 0;

        List<Buyer> buyers = new ArrayList<>();
        for (int time = 1; time <=120; time++) {
            System.out.println("Second "+time);
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start(); //запуск потока (покупателя)
                buyers.add(buyer);
            }
            Helper.sleep(1000);
        }
        Helper.sleep(2000);
        for (Buyer buyer : buyers) {
            try {
                buyer.join(); //main поток будет ожидать завершения потока buyer
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("=== Shop closed ===");
    }
}