package LinkedInQuestions;

/**
 * Created by rmukherj on 7/21/16.
 * Implement a TwoSum interface that has 2 methods:
 * Store and Test.
 * Store adds an integer to an internal data store and
 * Test checks if an integer passed to Test is the sum of any two
 * integers in the internal data store.
 */

public interface TwoSum{

    // stores input in an internal data structure
    public void Store(Integer input);

    // Returns true if there is any pair of numbers in the
    // internal data structures, have sum val and false if otherwise
    public boolean Test(Integer val);
}
