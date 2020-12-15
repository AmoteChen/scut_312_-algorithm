// 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

//这题可以用贪心算法，要求出最大值，就说明得出的数字的前面几位越接近给定的数字的前几位就越好，所以从前面开始遍历，要求一直是递增，如果遇到小于的情况
//就需要把当前位数字减一，后面全部赋值为9 这样显然可以得到一个最大数！要多模拟几遍
class Solution{
    public int monotoneIncreasingDigits(int N)
    {
        char[] a = (N+"").toCharArray();
        int max = -1;int index = -1;
        for(int i =0;i<a.length-1;i++)
        {
            if(a[i]>max)
            {
                max = a[i];
                index = i;
            }
            if(a[i]>a[i+1])
            {
                a[index]-=1;
                for(int j=index+1;j<a.length;j++)
                {
                    a[j]='9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(a));
    }
}
