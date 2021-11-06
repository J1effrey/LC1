// "static void main" must be defined in a public class.
// 1: Numbers: negative number
// 2: numbers: Int/Double
// 3: the size of list.

// 4: Before starting coding, to ensure confirm with interview to see if the approach works or wanted(*)
// 6: focusing on coding and debug. less communication
// 5: After finishing coding, to run (run code line by line) test cases for your interviewer(*)
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(5);
        list.add(6);
        list.add(3);
        printGraph(list);
        printVertical(list);
    }
    
    public static void printGraph(List<Integer> list) { // List ? array
        for (int num : list) {
            printOneLine(num);
        }
    }
    
    public static void printOneLine(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public static void printVertical(List<Integer> list) {
        int max = findMaxNum(list);
        int time = max;
        for (int j = 0; j < time; ++j) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < max) {
                    
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                }
            }
            max--;
            System.out.print("\n");
        }
        
    }
    
    public  static int findMaxNum(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }
    
    String[] s;
    s[0] = "|";
    s[1] = "|";
    s[2] = "|";
    s[3] = "| |---|";
    s[4] = "| |   |";
    s[5] = "|-|xxx|";
}

/*
inpu: list of numbers 2 1 0 5 6 3;
output: graph
--
-

-----
-------
---
       |
     | |
     | |
     | | |
|    | | |
| |  | | |


|
|                 |---|
|                 |   |
|                 |   |
| |---|           |   |
| |   | |---|     |   |
|-|XXX|-|XXX|-----|XXX|-----------------------
*/
