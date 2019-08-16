public class Features {
    public static int QuestionMarkCounter(String input)
    {
        int noOfQuesMark=0;
        for(char i : input.toCharArray())
        {
            if(i=='?')
            {
                noOfQuesMark++;
            }
        }
        return noOfQuesMark;
    }
    public static int NoQuestionMark(String input)
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
}
