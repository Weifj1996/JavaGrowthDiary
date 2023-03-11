package com.weifj.dto;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo01 {

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }

    public static void main(String[] args) {
//        List<Author> authors = getAuthors();
//        authors.stream() //把集合转换成流
//                .distinct()  // 去重
//                .filter(author -> author.getAge() < 18)
//                .forEach(author -> System.out.println(author.getName()));


//        List<Author> authors = getAuthors();
//        Stream<Author> stream = authors.stream();

//        test02();

//        test03();

//        test04();

//        test05();

//        test06();

//        test07();

//        test08();

//        test09();

//        test10();

//        test12();

//        test13();

//        test14();
        
//        test15();

//        test16();

//        test17();

//        test18();

//        test19();

//        test20();


//        test21();

//        test22();

        test23();
    }

    private static void test23() {

        Author author = getAuthors().get(0);
        if(author!=null){
            System.out.println(author.getName());
        }

    }


    private static void test22() {
        Integer reduce = getAuthors().stream()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer < integer2 ? integer2 : integer);
        System.out.println(reduce);

        Integer reduc1 = getAuthors().stream()
                .map(Author::getAge)
                .reduce(Integer.MAX_VALUE, (integer, integer2) -> integer > integer2 ? integer2 : integer);
        System.out.println(reduc1);


        Optional<Integer> reduc2 = getAuthors().stream()
                .map(Author::getAge)
                .reduce((integer, integer2) -> integer > integer2 ? integer2 : integer);
        reduc2.ifPresent(s -> System.out.println(s));

    }

    private static void test21() {

        Integer reduce = getAuthors().stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, (integer, integer2) -> integer + integer2);

        System.out.println(reduce);


    }

    private static void test20() {
        Optional<Author> first = getAuthors().stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();

        first.ifPresent(author -> System.out.println(author.getName()));


    }

    private static void test19() {
        Optional<Author> any = getAuthors().stream()
                .filter(author -> author.getAge() > 18)
                .findAny();

        any.ifPresent(author -> System.out.println(author.getName()));


    }

    private static void test18() {
        boolean b = getAuthors().stream().noneMatch(author -> author.getAge() > 100);
        System.out.println(b);

    }

    private static void test17() {

        boolean b = getAuthors().stream().allMatch(author -> author.getAge() >= 18);
        System.out.println(b);


    }

    private static void test16() {
        boolean b = getAuthors().stream().anyMatch(author -> author.getAge() > 29);
        System.out.println(b);

    }

    private static void test15() {

        List<String> collect = getAuthors().stream().map(Author::getName)
                .collect(Collectors.toList());

        Set<String> collect1 = getAuthors().stream().map(Author::getName)
                .collect(Collectors.toSet());

        Map<String, List<Book>> collect2 = getAuthors().stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);

    }

    private static void test14() {
        System.out.println(getAuthors().stream().flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max(Comparator.comparingInt(o -> o)));

        System.out.println(getAuthors().stream().flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((o1, o2) -> o1 - o2));



    }

    private static void test13() {

        long count = getAuthors().stream().flatMap(author -> author.getBooks().stream() ).distinct().count();
        System.out.println(count);

    }

    private static void test12() {
        getAuthors().stream().map(Author::getName).distinct().forEach(s -> System.out.println(s));


    }

    private static void test10() {
        // 打印现有数据的所有分类，要求对分类进行去重，不能出现这种格式，哲学，爱情
        List<Author> authors = getAuthors();
        authors.stream().flatMap(author-> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(s -> System.out.println(s));

    }

    private static void test09() {
        // 打印所有数据的名字，要求对重复的元素进行去重。
        List<Author> authors = getAuthors();
//        authors.stream()
//                .map((Function<Author, List<Book>>) author -> (ArrayList<Book>) author.getBooks())
//                .forEach(books -> System.out.println(books));

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book));

                


    }

    private static void test08() {

        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test07() {
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()+"::"+author.getAge()));

    }

    private static void test06() {
        List<Author> authors = getAuthors();
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(author -> System.out.println(author.getName() +":::"+author.getAge()));
    }

    private static void test05() {
        // 打印所有作家的姓名
        List<Author> authors = getAuthors();

        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));

        authors.stream().map(author -> author.getName())
                .forEach(s -> System.out.println(s));


    }

    private static void test04() {

        List<Author> authors = getAuthors();
        // 打印所有姓名长度大于1的作家的姓名
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test03() {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("蜡笔小新", 19);
        stringIntegerHashMap.put("黑子", 17);
        stringIntegerHashMap.put("鸣人", 16);


        Set<Map.Entry<String, Integer>> entries = stringIntegerHashMap.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entries.stream();

        stream.filter(entry -> entry.getValue() > 17)
                .forEach(entry -> System.out.println(entry.getKey() + ":::" + entry.getValue()));

    }

    private static void test02() {

        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct()
                .filter(integer -> integer > 3)
                .forEach(integer -> System.out.println(integer));

//        Stream<Integer> stream = Arrays.stream(arr);
//        stream.distinct()
//                .filter(integer -> integer>3)
//                .forEach(integer -> System.out.println(integer));

    }

}
