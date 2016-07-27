package iterator_and_comparators.pet_clinics;

import iterator_and_comparators.pet_clinics.models.Clinic;
import iterator_and_comparators.pet_clinics.models.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Pet> pets = new LinkedHashMap<>();
        HashMap<String, Clinic> clinics = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] param = reader.readLine().split("\\s+");

            switch (param[0]){
                case "Create":
                    if (param[1].equals("Pet")){
                        String name = param[2];
                        int age = Integer.valueOf(param[3]);
                        String kind = param[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.put(name, pet);
                    } else if (param[1].equals("Clinic")){
                        String name = param[2];
                        int roomsCount = Integer.valueOf(param[3]);
                        try {
                            Clinic clinic = new Clinic(roomsCount);
                            clinics.put(name, clinic);
                        } catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;

                case "Add":
                    Pet pet = pets.get(param[1]);
                    Clinic clinic = clinics.get(param[2]);
                    System.out.println(clinic.add(pet));
                    break;

                case "Release":
                    System.out.println(clinics.get(param[1]).release());
                    break;

                case "HasEmptyRooms":
                    System.out.println(clinics.get(param[1]).hasEmptyRooms());
                    break;

                case "Print":
                    if (param.length == 2) {
                        System.out.println(clinics.get(param[1]).print());
                    } else if (param.length == 3) {
                        System.out.println(clinics.get(param[1]).print(Integer.parseInt(param[2])));
                    }
                    break;
            }
        }
    }
}
