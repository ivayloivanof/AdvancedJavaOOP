package enumerations_and_anotations.custom_enum_anotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by ivanof on 7/26/16.
 */
public class Main {

    public static void main(String[] args) {
        Class<Main> mainClass = Main.class;
        Method[] methods = mainClass.getDeclaredMethods();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String annotationType = br.readLine();

            for (Method method : methods) {
                if (Objects.equals(annotationType, "Rank")) {
                    Rank annotation = method.getAnnotation(Rank.class);
                    if(annotation != null) {
                        System.out.printf("Type = %s, Description = %s%n", annotation.type(), annotation.description());
                    }
                } else {
                    Suite annotation = method.getAnnotation(Suite.class);
                    if(annotation != null) {
                        System.out.printf("Type = %s, Description = %s%n", annotation.type(), annotation.description());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Rank()
    public static void testRankAnnotation() {

    }

    @Suite
    public static void testSuiteAnotation() {

    }
}
