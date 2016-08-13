//package LinkedInQuestions;
//
///**
// * Created by rmukherj on 8/8/16.
// */
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class ArrayMultiPutBlockingBoundedQueue<E> implements MultiPutBlockingBoundedQueue<E> {
//
//    public ArrayMultiPutBlockingBoundedQueue() {
//        elements = null;
//        count = 0;
//    }
//
//    @Override
//    public synchronized void init(int capacity) throws Exception {
//        if (isInitialized()) { // already initialized
//            throw new IllegalStateException();
//        }
//        if (capacity <= 0) {
//            throw new IllegalArgumentException();
//        }
//
//        elements = new Object[capacity];
//        count = 0;
//        start = 0;
//        notifyAll();
//    }
//
//    @Override
//    public synchronized E get() throws Exception {
//        if (!isInitialized()) {
//            throw new IllegalStateException();
//        }
//
//        while (isEmpty()) {
//            try {
//                wait();
//            } catch (final InterruptedException e) {
//            }
//        }
//
//        assert (!isEmpty());
//        final E val = dequeue();
//        notifyAll();
//        return val;
//    }
//
//    @Override
//    public synchronized void put(E obj) throws Exception {
//        Objects.requireNonNull(obj);
//
//        if (!isInitialized()) {
//            throw new IllegalStateException();
//        }
//
//        while (isFull()) {
//            try {
//                wait();
//            } catch (final InterruptedException e) {
//            }
//        }
//
//        assert (!isFull());
//        enqueue(obj);
//        notifyAll();
//    }
//
//    @Override
//    public synchronized void multiput(List<E> objs) throws Exception {
//        if (!isInitialized()) {
//            throw new IllegalStateException();
//        }
//        if (objs.size() > elements.length) {
//            throw new IllegalArgumentException();
//        }
//
//        while (!hasCapacity(objs.size())) {
//            try {
//                wait();
//            } catch (final InterruptedException e) {
//            }
//        }
//
//        assert (hasCapacity(objs.size()));
//        for (final E obj : objs) {
//            Objects.requireNonNull(obj);
//            enqueue(obj);
//        }
//        notifyAll();
//    }
//
//    private synchronized boolean isInitialized() {
//        return (elements != null);
//    }
//
//    private synchronized boolean isEmpty() {
//        return (count == 0);
//    }
//
//    private synchronized boolean isFull() {
//        return (count == elements.length);
//    }
//
//    private synchronized boolean hasCapacity(int n) {
//        return (count + n <= elements.length);
//    }
//
//    private synchronized int end() {
//        return (start + count) % elements.length;
//    }
//
//    private synchronized void enqueue(E o) {
//        final int idx = end();
//        elements[idx] = o;
//        // System.out.format("enqueue msg\"%s\" at index \"%d\"%n",
//        // o.toString(), idx); // DEBUG
//        count++;
//    }
//
//    private synchronized E dequeue() {
//        @SuppressWarnings("unchecked")
//        final E val = (E) elements[start];
//        elements[start] = null;
//        // System.out.format("dequeue msg\"%s\" at index \"%d\"%n",
//        // val.toString(), start); // DEBUG
//        start = (start + 1) % elements.length;
//        count--;
//        return val;
//    }
//
//    private Object[] elements;
//    private int count;
//    private int start;
//}