package org.sc.util.reflect;

import org.junit.Test;
import org.sc.demo.AppController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;


public class SpringAnnotationUtil {

    @Test
    public void getAnnotation() throws Exception{
        Class<?> clazz = Class.forName("org.sc.demo.AppController");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation.getClass());
            Class<? extends Annotation> aClass1 = annotation.annotationType();
            System.out.println(aClass1);

        }
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations){
            System.out.println(annotation);
            System.out.println(annotation.annotationType());
            Class<? extends Annotation> aClass = annotation.annotationType();

        }
        System.out.println(Arrays.toString(declaredAnnotations));
        // System.out.println(Arrays.toString(annotations));
    }

    @Test
    public void getAnnotations() throws Exception{
        RequestMapping annotation = findAnnotation(AppController.class, RequestMapping.class);
        System.out.println(annotation);
    }
}
