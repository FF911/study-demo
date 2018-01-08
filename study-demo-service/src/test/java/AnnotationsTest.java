import com.ghc.java.study.demo.common.annotations.NotNull;
import com.ghc.java.study.demo.domain.po.Student;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * <p> </p>
 *
 * @Author : gonghongcai.
 * @Date : 2018/1/7 23:29.
 * @Description :
 */

public class AnnotationsTest {

    @Test
    public void testAnnotations(){
        Student student = new Student();
        student.setName("123");
        Class clazz = student.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(NotNull.class)){
                try {
                    field.setAccessible(true);
                    String o = (String) field.get(student);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                String annoValue = field.getAnnotation(NotNull.class).value();
                throw new RuntimeException("属性"+clazz.getName()+"."+field.getName()+"为空"+annoValue);

            }
        }

    }
}
