package org.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest {
    //类型翻译字段  这里是多个类里面需要处理的枚举字段  每个类里面需要处理的字段不同
    private static final Map<String, Object> enumInfoTypes;

    static {
        enumInfoTypes = new HashMap<>();
        enumInfoTypes.put("isPass", ConfirmEnum.class);
//        enumInfoTypes.put("state", IssueStatusEnum.class);
//        enumInfoTypes.put("processState", ManufactureFlowStatusEnum.class);
//        enumInfoTypes.put("reasonCheckFlag", ReasonCheckEnum.class);
    }

    /**
     * 测试枚举工具类方法
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {
        //根据isPass关键字从Map中获得相应的值（类的字符串名称）
        String className = enumInfoTypes.get("isPass").toString();

        //上步获得的值中有多余的字符，通过对字符串操作将多余字符截去
        int beginIndex = className.indexOf(" ") + 1;
        className = className.substring(beginIndex);

        //使用工具类
        EnumUtil util = new EnumUtil();
        //将需要获得详细信息的枚举类名传入
        List<EnumDto> enumDtoList = util.getEnum(className);
        //输出该枚举类中所有常量实例信息的集合
        System.out.println(enumDtoList);
    }
}
