package string;

/**
 * KMP Algorithm
 * @author chicheng
 * @date 2020/10/22 22:24
 * @description
 */
public class KMP {

    private static int getMatchStrIndex(String str, String match) {
        char[] strArr = str.toCharArray();
        char[] matchArr = match.toCharArray();
        int x = 0;
        int y = 0;
        int[] nextArr = getNextArray(matchArr);
        while (x < strArr.length && y < matchArr.length) {
            if (strArr[x] == matchArr[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = nextArr[y];
            }
        }
        return y == matchArr.length ? x - y :-1;
    }

    private static int[] getNextArray(char[] matchArr) {
        if (matchArr.length == 1) {
            return new int[] {-1};
        }
        int[] nextArr = new int[matchArr.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < matchArr.length) {
            if (matchArr[i - 1] == matchArr[cn]) {
                nextArr[i++] = ++cn;
            } else if (cn > 0) {
                cn = nextArr[cn];
            } else {
                nextArr[i++] = 0;
            }
        }
        return nextArr;
    }


    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (getMatchStrIndex(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("test finish:" + (end - start));
    }

}
