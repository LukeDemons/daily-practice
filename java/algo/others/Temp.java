package algo.others;

import java.util.HashSet;
import java.util.Set;
import util.ObjectUtils;

public class Temp {

    public static void main(String[] args) {
        Entity entity = new Entity();

        System.out.println(ObjectUtils.objectIsNull(null));
        System.out.println(ObjectUtils.objectIsNull(entity));

        entity.yn = 1;
        Set<String> set = new HashSet<>();
        set.add("yn");
        System.out.println(ObjectUtils.objectIsNull(entity, set));
    }
}


class Entity {

    Long id;

    String name;

    Byte yn;
}