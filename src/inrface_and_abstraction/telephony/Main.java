package inrface_and_abstraction.telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivanof on 7/15/16.
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] phoneNumbers = br.readLine().split("\\s+");
            String[] sites = br.readLine().split("\\s+");
            Smartphone smartphone = new Smartphone();

            for (String phoneNumber : phoneNumbers) {
                smartphone.call(phoneNumber);
            }

            for (String site : sites) {
                smartphone.browseInWEB(site);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Smartphone implements Callable, Browseable{

    private String number;
    private String url;

    public String getNumber() {
        return this.number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public String getUrl() {
        return this.url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void call(String number) {
        this.setNumber(number);
        String[] digits = this.getNumber().split("");
        for (String digit : digits) {
            try {
                Integer.parseInt(digit);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number!");
                return;
            }
        }

        System.out.printf("Calling... %s%n", this.getNumber());
    }

    @Override
    public void browseInWEB(String url) {
        this.setUrl(url);
        String[] digits = this.getUrl().split("");
        for (String digit : digits) {
            try {
                Integer.parseInt(digit);
                System.out.println("Invalid URL!");
                return;
            } catch (NumberFormatException ex) {

            }
        }

        System.out.printf("Browsing: %s!%n", this.getUrl());
    }
}

interface Callable {
    void call(String number);
}

interface Browseable {
    void browseInWEB(String url);
}