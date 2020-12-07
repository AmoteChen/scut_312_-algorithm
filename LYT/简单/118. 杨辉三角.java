// 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        if(numRows==0)
            return result;
        a.add(1);
        result.add(a);
        if(numRows==1)
            return result;
        for(int i=1;i<numRows;i++)
        {
            List<Integer> b = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0)
                {
                    int k = result.get(i-1).get(0);
                    b.add(k);
                    continue;
                }
                if(j==i)
                {
                    int k = result.get(i-1).get(i-1);
                    b.add(k);
                    continue;
                }
                int k = result.get(i-1).get(j-1)+result.get(i-1).get(j);
                b.add(k);
            }
            result.add(b);
        }
        return result;
    }
}
