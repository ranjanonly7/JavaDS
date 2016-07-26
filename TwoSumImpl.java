package LinkedInQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmukherj on 7/21/16.
 */
public class TwoSumImpl implements TwoSum {

    private List<Integer> _store = new ArrayList<>();
    private List<Integer> _sums = new ArrayList<>();

    public void TwoSumImpl(){}

    public void Store(Integer input) {
        if (!_store.contains(input)) {
            _store.add(input);
        }
    }

    public boolean Test(Integer val){
        for(int i=0;i<_store.size();i++){
            if(_store.get(i)<0){
                _sums.add(i, val+Math.abs(_store.get(i)));
                if(_store.contains(_sums.get(i))){
                    return true;
                }

            } else {
                _sums.add(i, val - _store.get(i));
                if(_store.contains(_sums.get(i))){
                    return true;
                }

                return false;
            }
        }

        return false;
    }

    public void print(){

    }

    public static void main(String[] args){
        TwoSumImpl im = new TwoSumImpl();
        im._store.add(10);
        im._store.add(3);
        im._store.add(5);
        im._store.add(9);

        System.out.println(im.Test(1));
        System.out.println(im.Test(3));
        System.out.println(im.Test(8));
        System.out.println(im.Test(19));


    }

}
