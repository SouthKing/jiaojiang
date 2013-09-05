package jiaojiang.huayuan;


public class Utils {
    public static void print(char[] chars) {
        for (char c : chars) {
            System.out.print(c);
        }
    }

    public static void print(char[] charSeq, int length) {
        if (length > charSeq.length) {
            length = charSeq.length;
        } else if (length < 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(charSeq[i]);
        }
    }

    public static void print(char[] charSeq, int start, int length) {
        if (length > charSeq.length) {
            length = charSeq.length;
        } else if (length < 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(charSeq[start + i]);
        }
    }

    public static void swap(char[] input, int i, int j) {

        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }

     public static void swap(int[] input, int i, int j) {

        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }

    public static void println(char[] chars) {
        Utils.print(chars);
        System.out.println();
    }

    public static void println(char[] charSeq, int length) {
        print(charSeq, length);
        System.out.println();
    }

    public static void println(char[] charSeq, int start, int length) {
        print(charSeq, start, length);
        System.out.println();
    }
}
