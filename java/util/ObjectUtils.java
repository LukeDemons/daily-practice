package util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ObjectUtils {

    public static boolean objectIsNull(Object obj, Set<String> ignoreFields) {
        if (obj == null) {
            return true;
        }
        // 获取所有属性
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields.length == 0) {
            return true;
        }
        boolean flag = true;
        for (Field field : fields) {
            // 不检查，设置可访问
            field.setAccessible(true);
            try {
                if (field.get(obj) instanceof Collection) {
                    if (isNotNull((Collection<?>) field.get(obj))) {
                        flag = false;
                        break;
                    }
                } else {
                    // 非忽略属性的 有值就false
                    if (!ignoreFields.contains(field.getName()) && isNotNull(field.get(obj))) {
                        flag = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("ObjectNullUtil.objectIsNull校验异常");
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    public static boolean objectIsNull(Object obj) {
        return objectIsNull(obj, new HashSet<>());
    }

    public static boolean isNull(Object obj) {
        return obj == null || isNull(obj.toString());
    }

    public static boolean isNull(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNull(String str) {
        return str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str);
    }

    public static boolean isNotNull(Collection<?> collection) {
        return !isNull(collection);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
