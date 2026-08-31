import java.util.ArrayList;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class stack {
    ArrayList<String> stack = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    boolean question() {
        boolean record = false;
        String current = "";
        boolean isTrue = true;
        StringBuilder s = new StringBuilder();
        while (true) {
            String ch = sc.next();
            if (ch == null) {
                return isTrue;
            }
            if (record) {
                if (ch.equals(current)) {
                    current = "";
                    for (int i = 0; i < stack.size(); i++) {
                        s.append(stack.get(i));
                        stack.remove(i);
                    }
                } else {
                    if (ch.equals(")") || ch.equals("]") || ch.equals("}")) {
                        isTrue = false;
                    }
                }
                stack.add(ch);
                continue;
            }
            if (ch.equals("(")) {
                stack.add(ch);
                record = true;
                current = ch;
            }
            if (ch.equals("[")) {
                stack.add(ch);
                record = true;
                current = ch;
            }
            if (ch.equals("{")) {
                stack.add(ch);
                record = true;
                current = ch;
            }
        }
    }
}
