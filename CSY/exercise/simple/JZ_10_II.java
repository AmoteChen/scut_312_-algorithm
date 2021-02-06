public class JZ_10_II {
    public int numWays(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }

        int fn0 = 1;
        int fn1 = 1;
        int temp;

        for (int i = 2 ; i <= n; i++){
            temp = fn0 +fn1;
            fn0 = fn1;
            fn1 = temp % 1000000007;

        }
        return fn1;
    }

    public static void main(String[] args) {
        JZ_10_II tester = new JZ_10_II();
        System.out.println(tester.numWays(7));
    }
}
