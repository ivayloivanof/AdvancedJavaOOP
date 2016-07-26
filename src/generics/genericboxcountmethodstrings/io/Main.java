package generics.genericboxcountmethodstrings.io;

import generics.genericboxcountmethodstrings.implementation.GenericBoxImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        GenericBoxImplementation<String> box = new GenericBoxImplementation<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputCount; i++) {
            String data = br.readLine();
            box.addGenericType(data);
        }

        String compareElement = br.readLine();
        System.out.println(box.getCountOfGreaterElement(box.getCollection(), compareElement));
    }
}
