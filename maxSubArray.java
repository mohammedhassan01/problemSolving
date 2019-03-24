import java.util.ArrayList;


#https://www.interviewbit.com/problems/max-non-negative-subarray/
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Long> sumArr = new ArrayList<>();
        ArrayList<Integer> fivalArr = new ArrayList<>();
        ArrayList<Integer> indexArr = new ArrayList<>();
        ArrayList<Integer> maxLength = new ArrayList<>();

        long sumVal = 0;
        int fival = A.get(0);
        int index = 0;
        int leng = 0;
        for (int i = 0; i < size; i++) {
            if (A.get(i) < 0) {
                sumArr.add(sumVal);
                fivalArr.add(fival);
                indexArr.add(index);
                maxLength.add(leng);

                sumVal = 0;
                leng = 0;

                if (i < size - 1) {
                    fival = A.get(i + 1);
                }
                index = i + 1;
            } else {
                sumVal += A.get(i);
                leng++;
            }
        }
        sumArr.add(sumVal);
        fivalArr.add(fival);
        indexArr.add(index);
        maxLength.add(leng);

       

        Long maxValue = 0L;
        ArrayList<Integer> maxi = new ArrayList<>();
        ArrayList<Integer> maxlen = new ArrayList<>();
        
        maxValue = Collections.max(sumArr);
        for (int i = 0; i < sumArr.size(); i++) {
            //System.out.println(sumArr.get(i));
            if (maxValue == sumArr.get(i)) {
                maxi.add(indexArr.get(i));
                maxlen.add(maxLength.get(i));
            }
        }
        // so far i get the indexs of the max sub arrays in maxi array
        
        int maxLenV =  Collections.max(maxlen);
        int maxLenIndex = maxlen.indexOf(maxLenV);
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = maxi.get(maxLenIndex); i < maxi.get(maxLenIndex) + maxlen.get(maxLenIndex); i++) {
            //System.out.println(A.get(i));
            result.add(A.get(i));
        }
        return result;
    }
}
