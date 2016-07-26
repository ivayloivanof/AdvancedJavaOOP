package generics.genericboxcountmethoddoubles.io;

import generics.genericboxcountmethoddoubles.implementation.GenericBoxImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        GenericBoxImplementation<Double> box = new GenericBoxImplementation<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputCount; i++) {

            double data = Double.parseDouble(br.readLine());

            box.addGenericType(data);
        }

        double compareElement = Double.parseDouble(br.readLine());

        System.out.println(box.getCountOfGreaterElement(box.getCollection(), compareElement));
    }
}
