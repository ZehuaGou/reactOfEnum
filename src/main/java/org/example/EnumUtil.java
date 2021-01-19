package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 枚举工具类
 */
public class EnumUtil {
    /**
     * 获得枚举中各常量信息
     *
     * @param className 枚举类的名称(含包名)
     * @return EnumDto集合
     * @throws ClassNotFoundException 找不到类异常（反射中常遇到该异常）
     */
    public List<EnumDto> getEnum(String className) throws ClassNotFoundException {
        //使用反射方法，通过类的字符串名称加载类
        Class<Enum> c = (Class<Enum>) Class.forName(className);

        //调用Util方法返回该枚举中所有常量信息集合
        return EnumUtil(c);
    }

    /**
     * 使用Java反射方法，
     * 根据枚举类型将该枚举中所有常量信息封装在EnumDto中
     * 将封装完毕的所有EnumDto对象放入List集合并返回
     *
     * @param em 枚举类形参
     * @return EnumDto集合
     */
    private List<EnumDto> EnumUtil(Class<Enum> em) {
        try {
            //获得该枚举类中getCode方法
            Method toCode = em.getMethod("getCode");
            //获得该枚举类中getDesc方法
            Method toDesc = em.getMethod("getDesc");

            //得到enum的所有常量实例
            Object[] objs = em.getEnumConstants();
            System.out.println(Arrays.toString(objs));
            EnumDto dto;
            List<EnumDto> list = new ArrayList<>();
            for (Object obj : objs) {
                System.out.println(obj);
                dto = new EnumDto();
                //根据反射方法，执行枚举类中该obj常量实例的getCode函数
                dto.setCode((Integer) toCode.invoke(obj));
                //根据反射方法，执行枚举类中该obj常量实例的getDesc函数
                dto.setDesc((String) toDesc.invoke(obj));
                //将包含该obj常量实例code和desc信息的EnumDto对象加入集合中
                list.add(dto);
            }
            //返回集合
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
