import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public enum AnnotationTest {

}

// 使用注解
@MyAnnotation("WTF...")
class MyClass {}


// 自定义注解
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value() default "WTF!";
}