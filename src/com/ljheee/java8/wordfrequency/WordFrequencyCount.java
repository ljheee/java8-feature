package com.ljheee.java8.wordfrequency;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 词频统计
 * https://www.cnblogs.com/tomasman/p/7067876.html
 */
public class WordFrequencyCount {


    private Set<String> NON_WORDS = new HashSet<String>() {{
        //匿名内部类+初始化块的初始化方式
        add("the");
        add("and");
        add("of");
        add("to");
        add("a");
        add("i");
        add("it");
        add("in");
        add("or");
        add("is");
        add("as");
        add("so");
        add("but");
        add("be");
    }};

    /*
     * 使用正则表达式获得包含所有单词的List
     */
    private List<String> regexToList(String words, String regex) {
        List<String> wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find())
            wordList.add(m.group());
        return wordList;
    }


    public Map<String, Integer> wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();//使用TreeMap是为了使输出结果自然排序

        regexToList(words, "\\w+").stream()//将collection对象变为stream
                .map(w -> w.toLowerCase())      //返回一个经过小写处理的stream
                .filter(w -> !NON_WORDS.contains(w))    //过滤,使流中的元素都是NON_WORDS集合中不包含的元素
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));//遍历执行操作
        return wordMap;
    }

    public static void main(String[] args) {
        String str = "/home/abc/workspace/is,ljh,abc,ljh/mflie/bbb.txt";

        Map<String, Integer> map = new WordFrequencyCount().wordFreq(str);

        //自然排序：
        for(Map.Entry<String, Integer> item : map.entrySet()){
            System.out.println(item.getKey() + "," + item.getValue());
        }

    }

}
