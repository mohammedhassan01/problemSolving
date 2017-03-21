public class Accumul {
    
    public static String accum(String s) {
     int i = 0 ; 
     // always use StringBuilder if the string is frequently changes
     // because the StringBuilder is mutable   it will save a lot of work 
     StringBuilder strBuilder = new StringBuilder() ;
     for(char c : s.toCharArray())
     {
     		if(i > 0) strBuilder.append('-');
        strBuilder.append(Character.toUpperCase(c));
        for(int j = 0 ; j < i ; j++)
        {
        	strBuilder.append(Character.toLowerCase(c));
        }
        i++;
     }
     return strBuilder.toString();
    }
}