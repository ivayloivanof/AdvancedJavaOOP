package generics.genericboxinteger;

import generics.genericboxinteger.implementation.GenericBoximplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        GenericBoximplementation<Integer> box = new GenericBoximplementation<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputCount; i++) {
            int data = Integer.parseInt(br.readLine());
            box.addGenericType(data);
        }

        System.out.println(box.toString());
    }
}
