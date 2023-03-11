package com.weifj;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class LambdaDemo01 {

//    public static void main(String[] args) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("新线程1run方法被执行");
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("新线程2run方法被执行");
//        }).start();

//        int i = calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });
//
//        i = calculateNum((int left, int right) -> left + right);
//        System.out.println(i);

//    public static void main(String[] args) {
//        printNum((int value) ->{
//                return value%2==0;
//            });
//    }
//}
//
//    public static void printNum(IntPredicate predicate){
//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        for (int i : arr) {
//            if(predicate.test(i)){
//                System.out.println(i);
//            }
//        }
//    }


//    public static  int calculateNum(IntBinaryOperator operator){
//        int a =10,b=20;
//        return operator.applyAsInt(a,b);
//    }


    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }

    public static void main(String[] args) {
        Integer integer = typeConver((String s) -> {
                return Integer.valueOf(s);
            });
        System.out.println(integer);
    }

}

