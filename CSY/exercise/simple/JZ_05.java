/***
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */




public class JZ_05 {
    public String replaceSpace(String s) {
        String result = s.replace(" ", "%20");
        return result;
        /***
         * int length = s.length();
         *         char[] array = new char[length * 3];
         *         int size = 0;
         *         for (int i = 0; i < length; i++) {
         *             char c = s.charAt(i);
         *             if (c == ' ') {
         *                 array[size++] = '%';
         *                 array[size++] = '2';
         *                 array[size++] = '0';
         *             } else {
         *                 array[size++] = c;
         *             }
         *         }
         *         String newStr = new String(array, 0, size);
         *         return newStr;
         */


    }

    public static void main(String[] args) {
        JZ_05 tester = new JZ_05();
        String test = " ";
        System.out.println(tester.replaceSpace(test));
    }
}
