package LovelyStrings;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("j");
        set.add("b");
        set.add("c");
        Splitter splitter = new Splitter(set);
        Set<String> goods = splitter.goods();

      /*  for(String x: goods)
            System.out.println(x);*/
        goods.clear();
    }
}
