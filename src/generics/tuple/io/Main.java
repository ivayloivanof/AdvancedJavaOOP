package generics.tuple.io;

import generics.tuple.contract.Tuple;
import generics.tuple.model.MyTuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String info[] = br.readLine().split("\\s+");
        Tuple<String, String> tup1 = new MyTuple<String, String>(info[0] + " " + info[1], info[2]);
        System.out.printf("%s -> %s\n", tup1.getItem1(), tup1.getItem2());

        info = br.readLine().split("\\s+");
        Tuple<String, Integer> tup2 = new MyTuple<String, Integer>(info[0], Integer.parseInt(info[1]));
        System.out.printf("%s -> %d\n", tup2.getItem1(), tup2.getItem2());

        info = br.readLine().split("\\s+");
        br.close();
        Tuple<Integer, Double> tup3 = new MyTuple<Integer, Double>(Integer.parseInt(info[0]),
                Double.parseDouble(info[1]));
        System.out.printf("%d -> %s", tup3.getItem1(), tup3.getItem2());
    }
}
