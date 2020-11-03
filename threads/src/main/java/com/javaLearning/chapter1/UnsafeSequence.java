package com.javaLearning.chapter1;

//@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value++;
    }



    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run(){
                for (int i=0; i<=100; i++){
                    UnsafeSequence a = new UnsafeSequence();
                    System.out.println(Thread.class.getName()+"--"+ a.getNext());         }
            }
        }.start();
    }
}


