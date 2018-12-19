package com.ljheee.java8.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * java8自定义收集器
 * https://www.jianshu.com/p/c0d5c3094324
 *
 *
 * Collector的定义为Collector<T, A, R>, 其中泛型参数T表示Stream中元素的类型， A表示定义一个初始容器的类型，R表示最终转换的类型。
 * https://irusist.github.io/2016/01/04/Java-8%E4%B9%8BCollector/
 */
public class SplitByNumCollector<T> implements Collector<T, SplitByNumCollector.ListSpliter<T>, List<List<T>>> {
    private int splitSize;

    public SplitByNumCollector(int splitSize){
        this.splitSize = splitSize;
    }


    @Override
    public Supplier<ListSpliter<T>> supplier() {
        return () -> new ListSpliter(splitSize);
    }


    @Override
    public BiConsumer<ListSpliter<T>, T> accumulator() {
        return ListSpliter::add;
    }

    @Override
    public BinaryOperator<ListSpliter<T>> combiner() {
        return ListSpliter::merge;
    }

    @Override
    public Function<ListSpliter<T>, List<List<T>>> finisher() {
        return ListSpliter::finisher;
    }


    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }


    public static class ListSpliter<T>{
        private int _splitSize;
        private List<List<T>> splitedList = new ArrayList<List<T>>();
        private List<T> list = new ArrayList();
        public ListSpliter(int _splitSize){
            this._splitSize = _splitSize;
        }

        public ListSpliter add(T t){
            int lsize = list.size();
            if(lsize < _splitSize){
                list.add(t);
                if(++lsize == _splitSize){
                    splitedList.add(list);
                    list = new ArrayList<>();
                }
            }
            return this;
        }

        public ListSpliter merge(ListSpliter other){
            this.splitedList.add(other.splitedList);
            int tsize = this.list.size();
            int osize = other.list.size();
            if(tsize + osize < _splitSize){
                this.list.addAll(other.list);
            }else{
                int needSize = _splitSize - tsize;
                this.list.addAll(other.list.subList(0,needSize));
                this.splitedList.add(this.list);
                this.list = other.list.subList(needSize,osize);
            }
            return this;
        }

        public List<List<T>> finisher(){
            if(list.size() > 0) {
                this.splitedList.add(list);
            }
            return this.splitedList;
        }
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(2002);

        for (int i = 0; i < 2002; i++) {
            list.add(String.valueOf(Math.random()));
        }

        List<List<String>> subLists = list.stream().collect(new SplitByNumCollector<String>(100));
        System.out.println(subLists.size());//21 个


    }
}


