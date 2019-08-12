import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println(doLeftRight( "LLLRLRRR")==3? "PASS":"FAIL");
        System.out.println(doLeftRight( "R???L")==4? "PASS":"FAIL");
        System.out.println(doLeftRight( "??????")==6? "PASS":"FAIL");
        System.out.println(doLeftRight( "LL???RRRRRRR???")==11? "PASS":"FAIL");
        System.out.println(doLeftRight( "L?L?")==4? "PASS":"FAIL");
    }
    public static int doLeftRight(String input){
        int noOfQuesMark=0;
        for(char i : input.toCharArray())
        {
            if(i=='?')
            {
                noOfQuesMark++;
            }
        }
        if(noOfQuesMark==input.length())
        {
            return noOfQuesMark;
        }
        if(noOfQuesMark==0)
        {
            int pos=0;
            int maxx=0;
            for(char i : input.toCharArray())
            {
                if(i=='R')
                {
                    pos--;
                }
                else
                {
                    pos++;
                }
                if(maxx<pos)
                {
                    maxx=pos;
                }
            }
            return maxx;
        }
        return 0;
    }
}
