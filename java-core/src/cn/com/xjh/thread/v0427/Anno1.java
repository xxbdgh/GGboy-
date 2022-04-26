package cn.com.xjh.thread.v0427;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xujiahui
 * @create 2022/4/20 21:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Anno1 {
   String value();
   String color();
   Anno2 show();
}
