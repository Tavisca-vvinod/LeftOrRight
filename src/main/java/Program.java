public class Program {
    public static void main(String[] args) {
        System.out.println(doLeftRight("LLLRLRRR") == 3 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("R???L") == 4 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("??????") == 6 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("LL???RRRRRRR???") == 11 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("L?L?") == 4 ? "PASS" : "FAIL");
        System.out.println(doLeftRight("??L?L?") == 6 ? "PASS" : "FAIL");
    }
    public static int doLeftRight(String input){
        String[] splits = input.split("(?<=(.))(?!\\1)");
        if(splits.length==1&&splits[0].charAt(0)=='?')
        {
            return splits[0].length();
        }
        return (findFarthestMove(splits));
    }
    public static int findFarthestMove(String[] splits)
    {
        int position=0;
        int farthestMove=0;
        int previousPosition;
        char previousMove;
        char currentMove=' ';
        for(int i=0;i<splits.length;i++)
        {
            previousPosition=position;
            position=0;
            previousMove=currentMove;
            String string=splits[i];
            if(string.charAt(0)=='L')
            {
                currentMove='L';
                position=position+string.length();
            }
            if(string.charAt(0)=='R')
            {
                currentMove='R';
                position=position-string.length();
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
                    currentMove='L';
                    position=position+numberOfQ;
                }
                else if(matchGroup.charAt(0)=='R')
                {
                    currentMove='R';
                    position=position-numberOfQ;
                }
            }
            position=position+previousPosition;
            if(farthestMove<Math.abs(position))
            {
                farthestMove=Math.abs(position);
            }
        }
        return farthestMove;
    }
}
