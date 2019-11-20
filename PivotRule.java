/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adammeller
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PivotRule {
    public Integer getPivot(ArrayList<Integer> array){
        return array.get(0);
    }
}
class RandomizedRule extends PivotRule {
    @Override
    public Integer getPivot(ArrayList<Integer> array){
        Random rand = new Random();
        return rand.nextInt(array.size()-1);
    }
}
class MedianOfMediansRule extends PivotRule {
    @Override
    public Integer getPivot(ArrayList<Integer> array){
        ArrayList<Integer> al = array;
        while(array.size()>5)
            array=medianize(array);
        Collections.sort(array);
        Integer value =  array.get(array.size()/2);
        //System.out.println("value: " + value);
        //System.out.println("index: " + al.indexOf(value));
        return al.indexOf(value);
}
    public ArrayList medianize(ArrayList<Integer> array)
    {
        int full5s = (array.size()/5);
        int notFull = array.size()%5;
        for(int index=0;index<array.size()-5;index=index+5)
        {
            Collections.sort(array.subList(index, index+5));
        }
        if(notFull>0)
            Collections.sort(array.subList(array.size()-notFull,array.size()));
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int j=2;j<full5s*5;j=j+5)
        {
            al.add(array.get(j));
        }
        if(notFull==1)
            al.add(array.get(array.size()-1));
        else if(notFull==2)
        {
            al.add(array.get(array.size()-1));
            al.add(array.get(array.size()-2));
        }
        else if(notFull==3)
            al.add(array.get(array.size()-2));
        else if(notFull==4)
        {
            al.add(array.get(array.size()-2));
            al.add(array.get(array.size()-3));
        }
        return al;
    }
}
