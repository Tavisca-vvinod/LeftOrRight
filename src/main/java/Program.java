public class Program {
    public static void main(String[] args) {
        System.out.println(doLeftRight("LLLRLRRR") == 3 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("R???L") == 4 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("??????") == 6 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("LL???RRRRRRR???") == 13 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("L?L?") == 4 ? "PASS" : "FAIL");
    }
    public static int doLeftRight(String input){
        int noOfQuesMark=Features.QuestionMarkCounter(input);
        if(noOfQuesMark==input.length())
        {
            return noOfQuesMark;
        }
        if(noOfQuesMark==0)
        {
            return (Features.NoQuestionMark(input));
        }
        return (calculate(input));
    }
    public static int calculate(String input)
    {
        int pos=0;
        int max=0;
        int prevPos=0;
        String regex = "(?<=(.))(?!\\1)";
        String[] splits = input.split(regex);
        char prevSign=' ';
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
                if(i==0)
                {
                    int numberOfQ=string.length();
                    if(splits[i+1].charAt(0)=='L')
                    {
                        currentSign='+';
                        pos=pos+numberOfQ+splits[i+1].length();
                        i++;
                    }
                    else if(splits[i+1].charAt(0)=='R')
                    {
                        currentSign='-';
                        pos=pos-numberOfQ-splits[i+1].length();
                        i++;
                    }
                }
                else if (i==splits.length-1)
                {
                    int numberOfQ=string.length();
                    if(splits[i-1].charAt(0)=='L')
                    {
                        currentSign='+';
                        pos=pos+numberOfQ;
                    }
                    else if(splits[i-1].charAt(0)=='R')
                    {
                        currentSign='-';
                        pos=pos-numberOfQ;
                    }
                }
                else
                {
                    int numberOfQ=string.length();
                    if(splits[i+1].length()>splits[i-1].length())
                    {
                        if(splits[i+1].charAt(0)=='L')
                        {
                            currentSign='+';
                            pos=pos+numberOfQ;
                        }
                        else if(splits[i+1].charAt(0)=='R')
                        {
                            currentSign='-';
                            pos=pos-numberOfQ;
                        }
                    }
                    else
                    {
                        if(splits[i-1].charAt(0)=='L')
                        {
                            currentSign='+';
                            pos=pos+numberOfQ;
                        }
                        else if(splits[i-1].charAt(0)=='R')
                        {
                            currentSign='-';
                            pos=pos-numberOfQ;
                        }
                    }
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
