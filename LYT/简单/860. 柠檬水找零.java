// 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

// 注意，一开始你手头没有任何零钱。

// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

//直接模拟
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int []a =new int[2];
        a[0] =0;
        a[1] =0;
        int len = bills.length;
        for(int i=0;i<len;i++)
        {
            if(bills[i]==5)
            {
                a[0]++;
            }
            if(bills[i]==10)
            {
                a[0]--;
                a[1]++;
            }
            if(bills[i]==20)
            {
                if(a[1]>0)
                {
                    a[1]--;
                    a[0]--;
                }
                else{
                    a[0]=a[0]-3;
                }
            }
            if(a[0]<0||a[1]<0)
            {
                return false;
            }
        }
        return true;
    }
}
