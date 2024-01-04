package LovelyStrings;

import java.util.*;

public class Splitter {

    private final Set<String> set;
    private Set<String> goodStrings, badString;

    public Splitter(final Set<String> set) {
        this.set = set;
        this.goodStrings = new HashSet<>();
        this.badString = new HashSet<>();
        this.split();
    }

    public Set<String> goods() {
        return Collections.unmodifiableSet(this.goodStrings);
    }

    public Set<String> bads() {
        return Collections.unmodifiableSet(this.badString);

    }

    public Map<String, Set<String>> split() {
        this.badString.clear();
        this.goodStrings.clear();
        for(String str: this.set) {
            String strLower = str.toLowerCase();
            int count = 0;
            for(int i = 0; i < strLower.length(); i++) {
                int c = (int) (strLower.charAt(i) - 'a');
                char rot13 = (char)('a' + ((c + 13) % 26));
                if(rot13 >= 'a' && rot13 <= 'p')
                    count++;

            }
            if(count % 2 != 0)
                this.goodStrings.add(str);
            else
                this.badString.add(str);
        }
        Map<String, Set<String>> result = new HashMap<>();
        result.put("goods", this.goodStrings);
        result.put("bads", this.badString);
        return Collections.unmodifiableMap(result);
    }
}
