public class Program {
    public static void main(String[] args) {
        System.out.println(doLeftRight( "LLLRLRRR")==3? "PASS":"FAIL");
        System.out.println(doLeftRight( "R???L")==4? "PASS":"FAIL");
        System.out.println(doLeftRight( "??????")==6? "PASS":"FAIL");
        System.out.println(doLeftRight( "LL???RRRRRRR???")==11? "PASS":"FAIL");
        System.out.println(doLeftRight( "L?L?")==4? "PASS":"FAIL");
        System.out.println(doLeftRight( "??L")==3? "PASS":"FAIL");
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
        int pos=0;
        int max=0;
        String regex = "(?<=(.))(?!\\1)";
        String[] splits = input.split(regex);
        return 0;
    }

}
