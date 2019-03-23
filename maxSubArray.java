import java.util.ArrayList;


# https://www.interviewbit.com/problems/max-non-negative-subarray/
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Integer> sumArr = new ArrayList<>();
        ArrayList<Integer> fivalArr = new ArrayList<>();
        ArrayList<Integer> indexArr = new ArrayList<>();
        ArrayList<Integer> maxLength = new ArrayList<>();
        
        int sumVal = 0 ; 
        int fival = A.get(0);
        int index = 0 ;
        int leng = 0 ;
        for(int i = 0 ; i < size ; i++)
        {
            if(A.get(i) < 0){
                sumArr.add(sumVal);
                fivalArr.add(fival);
                indexArr.add(index);
                maxLength.add(leng);
                
                sumVal = 0 ; 
                leng = 0 ;
                fival = A.get(i+1);
                index = i+1;
            }else{
                sumVal += A.get(i);
                leng++;
            }
        }
            sumArr.add(sumVal);
            fivalArr.add(fival);
            indexArr.add(index);
            maxLength.add(leng);
            
        int maxValue = 0 ; 
        ArrayList<Integer> maxi = new ArrayList<>();
        for(int i = 0 ; i < sumArr.size(); i++)
        {
            if(maxValue < sumArr.get(i))
            {
                maxValue = sumArr.get(i);
            }
        }
        for(int i = 0 ; i < sumArr.size(); i++)
        {
            if(maxValue ==  sumArr.get(i))
            {
                maxi.add(i);
            }
        }
        // so far i get the indexs of the max sub arrays in maxi array

        int maxLenVal = 0 ; 
        int maxLeni = 0 ;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < maxi.size(); i++)
        {
            if(maxLenVal <  maxLength.get(maxi.get(i)))
            {
                maxLenVal =  maxLength.get(maxi.get(i));
                maxLeni = maxi.get(i);
            }
        }
        for(int i = maxLeni; i < maxLength.get(maxLeni) ; i++)
        {
            result.add(A.get(i));
        }
        return result;
    }
}
