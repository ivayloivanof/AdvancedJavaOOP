package generics.threeuple.io;

import generics.threeuple.contract.Threeuple;
import generics.threeuple.model.MyThreeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String info[] = br.readLine().split("\\s+");
        Threeuple<String, String, String> thr1 = new MyThreeuple<String, String, String>(info[0] + " " + info[1],
                info[2], info[3]);
        System.out.printf("%s -> %s -> %s\n", thr1.getItem1(), thr1.getItem2(), thr1.getItem3());

        info = br.readLine().split("\\s+");
        boolean drunk = info[2].equalsIgnoreCase("drunk") ? true : false;
        Threeuple<String, Integer, Boolean> thr2 = new MyThreeuple<String, Integer, Boolean>(info[0],
                Integer.parseInt(info[1]), drunk);
        System.out.printf("%s -> %d -> %s\n", thr2.getItem1(), thr2.getItem2(), thr2.getItem3());

        info = br.readLine().split("\\s+");
        br.close();
        Threeuple<String, Double, String> thr3 = new MyThreeuple<String, Double, String>(info[0],
                Double.parseDouble(info[1]), info[2]);
        System.out.printf("%s -> %.1f -> %s", thr3.getItem1(), thr3.getItem2(), thr3.getItem3());
    }
}
