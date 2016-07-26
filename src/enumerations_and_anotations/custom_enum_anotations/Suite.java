package enumerations_and_anotations.custom_enum_anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by ivanof on 7/26/16.
 */
@Target(ElementType.METHOD)
public @interface Suite {
    String type() default "Enumeration";
    String category() default "Rank";
    String description() default "Provides rank constants for a Card class.";
}
