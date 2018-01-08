package com.ghc.java.study.demo.common.utils;


import com.ghc.java.study.demo.common.annotations.NotEmpty;
import com.ghc.java.study.demo.common.annotations.NotNull;
import com.ghc.java.study.demo.common.annotations.RegValid;

import java.lang.reflect.Field;

/**
 * Created by ghc on 2017/2/15.
 */
public class CheckUtil {

    public static void checkParameters(Object... objs) {
        for (Object o : objs) {
            if (o == null) {
                throw new BizException("parameter is null");
            }
            lookup(o.getClass(), o);
        }
    }

    private static void lookup(Class clazz, Object o) {
        if (clazz.getName().contains("le.jr")) {
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(NotNull.class)) {
                    if (get(f, o) == null) {
                        throw new BizException(checkAndGet(f.getAnnotation(NotNull.class).value(), o, f) + "为空");
                    }
                }
                if (f.isAnnotationPresent(NotEmpty.class)) {
                    if (isEmpty(f, o)) {
                        throw new BizException(checkAndGet(f.getAnnotation(NotEmpty.class).value(), o, f) + "为空");
                    }
                }
                if (f.isAnnotationPresent(RegValid.class)) {
                    RegValid regValid = f.getAnnotation(RegValid.class);

                    if (isString(f)) {
                        String v = (String)get(f, o);
                        if (v != null && !isEmpty(regValid.reg())) {
                            if (!v.matches(regValid.reg())) {
                                throw new BizException(checkAndGet(regValid.value(), o, f) + "格式错误");
                            }
                        }
                    }

                }
            }
            lookup(clazz.getSuperclass(),o);
        }
    }

    public static void main(String[] args) {
        System.out.println("d".matches(""));
    }
    private static String checkAndGet(String value, Object o, Field f) {
        if (isEmpty(value)) {
            return String.format("%s.%s", o.getClass().getSimpleName(), f.getName());
        }
        return value;
    }

    private static Object get(Field f, Object o) {
        f.setAccessible(true);
        try {
            return f.get(o);
        } catch (IllegalAccessException e) {

        }
        return null;
    }

    private static boolean isEmpty(Field f, Object o) {
        Object o1 = get(f, o);
        if (o1 == null) {
            return true;
        }
        if (isString(f)) {
            return isEmpty((String) o1);
        }
        return false;
    }

    private static boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    private static boolean isString(Field f) {
        return String.class.equals(f.getType());
    }


    public static void assetRPCResultNotFail(Message message, String rpc) {
        if (message == null) {
            throw new BizException(rpc + " return null..");
        }
        if (!Messages.isSuccess(message)) {
            throw new BizException(rpc + " return fail..");
        }
    }

    public static boolean rpcResultFail(Message message) {
        if (message == null || !Messages.isSuccess(message)) {
            return true;
        }
        return false;
    }
}
