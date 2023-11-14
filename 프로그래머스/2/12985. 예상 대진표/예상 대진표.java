class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 0;
        while(true) {
            cnt++;
            if(Integer.max(a,b) % 2 == 0 && Integer.max(a,b) - Integer.min(a,b) == 1){
                System.out.println(cnt);
                break;
            }

            a = a%2 == 0 ? a/2 : a/2 + 1;
            b = b%2 == 0 ? b/2 : b/2 + 1;
        }
        return cnt;
    }
}