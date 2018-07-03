package org.aguinore.crackInterview;

import org.aguinore.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CrackInterview {
    public static int[] rotLeftBruteforce(int[] a, int d) {
        int actualShift = d % a.length;
        for (int i = 0; i < actualShift; i++) {
            int tempValue = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = tempValue;
        }
        return a;
    }

    /**
     *
     * @return an integer representing the minimum total characters that must be deleted to make the strings anagrams.
     */
    public static int makeAnagram(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        if (a.charAt(0) > b.charAt(0)) {
            char[] chars = aChars;
            aChars = bChars;
            bChars = chars;
        }

        int result = 0;
        for (int i = 0; i < bChars.length; i++) {
            int aIndex = Utils.findCharInArray(aChars, bChars[i]);
            if (aIndex >= 0) {
                aChars[aIndex] = '4';
                bChars[i] = '4';
            } else {
                result++;
            }
        }
        for (int i = 0; i < aChars.length; i++) {
            int bIndex = Utils.findCharInArray(bChars, aChars[i]);
            if (bIndex >= 0) {
                bChars[bIndex] = '6';
            } else {
                result++;
            }
        }
        return result;
    }

    /**
     *
     * @param magazine - dictionary
     * @param note - text to be formed using the #magazine
     * @return if the note can be formed using the magazine.
     */
    public static boolean checkMagazine(String[] magazine, String[] note) {
        List<String> magazineList = new ArrayList<>(Arrays.asList(magazine));
        for (String word: note) {
            int positionInMag = magazineList.indexOf(word);
            if (positionInMag >= 0) {
                magazineList.remove(positionInMag);
            } else {
                return false;
            }
        }
        return true;
    }

    static class Node {
        Node next;
    }

    /**]
     * O(1) space, O(n) time
     * @param node start
     * @return if linkedList contains circle
     */
    public static boolean hasListCycles(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node slow = node;
        Node fast = node.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean ifBracketsBalanced(String brackets) {
        if (brackets.isEmpty()) {
            return true;
        }
        String trueBrackets = "(){}[]";
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            if (trueBrackets.indexOf(ch) == -1) {
                return false;
            }
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.put(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOnStack = stack.pop();
                if (ch == ')') {
                    if (lastOnStack != '(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (lastOnStack != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (lastOnStack != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * @param arr array
     * @param sum - sum of desired subarray
     * @return two ints, left and right bounds of subarray which sum is equal to sum
     */
    public static int[] findSubarrayWithSum(int[] arr, int sum) {
        int[] res = {-1, -1};
        int currentSum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            while (currentSum > sum && start < i) {
                currentSum -= arr[start];
                start++;
            }
            if (currentSum == sum) {
                res[0] = start;
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}
