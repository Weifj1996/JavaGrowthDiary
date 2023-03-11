import com.weifj.annotation.MyField;

import java.lang.reflect.Field;

public class MyFieldTest {

    // 使用自定义注解
    @MyField(description = "weifj", length = 12)
    private String userName;
    public static void main(String[] args) {
        Class<MyFieldTest> myFieldTestClass = MyFieldTest.class;
        // 获取所有字段
        for (Field declaredField : myFieldTestClass.getDeclaredFields()) {
            // 判断这个字段是否有MyField注解
            if (declaredField.isAnnotationPresent(MyField.class)) {
                MyField annotation = declaredField.getDeclaredAnnotation(MyField.class);
                System.out.println("字段:[" +
                        declaredField.getName() + "],描述:[" +
                        annotation.description() + "], 长度:[" +
                        annotation.length() + "]");
            }
        }
    }
}
