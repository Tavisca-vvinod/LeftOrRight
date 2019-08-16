public class Program {
    public static void main(String[] args) {
        System.out.println(doLeftRight("LLLRLRRR") == 3 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("R???L") == 4 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("??????") == 6 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("LL???RRRRRRR???") == 13 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("L?L?") == 4 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("??L?L?") == 6 ? "PASS" : "FAIL");
    }
    public static int doLeftRight(String input){
        String[] splits = input.split("(?<=(.))(?!\\1)");
        if(splits.length==1&&splits[0].charAt(0)=='?')
        {
            return splits[0].length();
        }
        return (calculate(splits));
    }
    public static int calculate(String[] splits)
    {
        int pos=0;
        int max=0;
        int prevPos;
        char prevSign;
        char currentSign=' ';
        for(int i=0;i<splits.length;i++)
        {
            prevPos=pos;
            pos=0;
            prevSign=currentSign;
            String string=splits[i];
            if(string.charAt(0)=='L')
            {
                currentSign='+';
                pos=pos+string.length();
            }
            if(string.charAt(0)=='R')
            {
                currentSign='-';
                pos=pos-string.length();
            }
            if(string.charAt(0)=='?')
            {
                int numberOfQ=string.length();
                String matchGroup="";
                if(i==0)
                {
                    matchGroup=splits[i+1];
                }
                else if (i==splits.length-1)
                {

                    matchGroup=splits[i-1];
                }
                else
                {
                    matchGroup= splits[i+1].length()>splits[i-1].length()? splits[i+1]:splits[i-1];
                }
                if(matchGroup.charAt(0)=='L')
                {
                    currentSign='+';
                    pos=pos+numberOfQ;
                }
                else if(matchGroup.charAt(0)=='R')
                {
                    currentSign='-';
                    pos=pos-numberOfQ;
                }
            }
            if(prevSign==currentSign)
            {
                pos=prevPos+pos;
            }
            else
            {
                prevPos=Math.abs(prevPos);
                if(max<prevPos)
                {
                    max=prevPos;
                }
            }
            if(max<Math.abs(pos))
            {
                max=Math.abs(pos);
            }
        }
        return max;
    }
}
