import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Tree {
    int value;
    int level;
    Tree left;
    Tree right;

    Tree(int value) {
        this.value = value;
    }

    Tree() {
        this.value = -1;
    }

    void add(int num) {
        if (value == -1) {
            value = num;
            level = 1;
            return;
        }
        Tree current = this;
        while (true) {
            if (num == 0) {
                break;
            }
            if (current.value > num) {
                if (current.left == null) {
                    current.left = new Tree(num);
                    current.left.level = current.level + 1;
                    return;
                }
                current = current.left;
            } else if (current.value < num) {
                if (current.right == null) {
                    current.right = new Tree(num);
                    current.right.level = current.level + 1;
                    return;
                }
                current = current.right;
            } else {
                return;
            }
            if (current.right != null) {
                if (current.right.level > levelMax) {
                    levelMax = current.right.level;
                }
            }
            if(current.left != null) {
                if (current.left.level > levelMax) {
                    levelMax = current.left.level;
                }
            }
        }
    }

    void addAll(int[] arr) {
        for (int i : arr) {
            this.add(i);
        }
    }

    static int levelMax = 0;

    @Override

    public String toString() {
        ArrayList<Tree> stack = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        stack.add(this);

        while (!stack.isEmpty()) {
            Tree current = stack.removeLast();
            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(current.value);
            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        ArrayList arr = new ArrayList<>();
        while(true){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            arr.add(num);
        }
        int[] in = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            in[i] = (int) arr.get(i);
        }
        System.out.println(arr);
        tree.addAll(in);
        System.out.println(levelMax);
    }
}
