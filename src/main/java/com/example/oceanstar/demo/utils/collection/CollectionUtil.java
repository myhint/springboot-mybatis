package com.example.oceanstar.demo.utils.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 列表工具类
 * @Author blake
 * @Date 2019-04-10 17:07
 * @Version 1.0
 */
public class CollectionUtil {

    /**
     * 判断为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 判断非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 求交集
     *
     * @param masterList 主数据列表
     * @param slaveList  从数据列表
     * @param <T>
     * @return
     */
    public static <T> List<T> getIntersection(List<T> masterList, List<T> slaveList) {
        return masterList.stream().filter(slaveList::contains).collect(Collectors.toList());
    }

    /**
     * 求差集
     *
     * @param masterList 主数据列表
     * @param slaveList  从数据列表
     * @param <T>
     * @return
     */
    public static <T> List<T> getDifferenceSet(List<T> masterList, List<T> slaveList) {
        return masterList.stream().filter(t -> !slaveList.contains(t)).collect(Collectors.toList());
    }

    /**
     * 求并集
     *
     * @param masterList 主数据列表
     * @param slaveList  从数据列表
     * @param <T>
     * @return
     */
    public static <T> List<T> getUnionSet(List<T> masterList, List<T> slaveList) {
        List<T> list = new ArrayList<>();
        list.addAll(masterList);
        list.addAll(slaveList);
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 判断数组中的数字是否都大于0
     */
    public static boolean isAllNumberGreaterThanZero(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return Arrays.stream(array).allMatch(it -> it > 0);
    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(2);

        System.out.println(" ====== 求交集 ====== ");
        List<Integer> intersection = CollectionUtil.getIntersection(list1, list2);
        intersection.forEach(System.out::println);

        System.out.println(" ====== 求差集 ====== ");

        List<Integer> differenceSet = CollectionUtil.getDifferenceSet(list1, list2);
        differenceSet.forEach(System.out::println);

        System.out.println(" ====== 求并集 ====== ");
        List<Integer> unionSet = CollectionUtil.getUnionSet(list1, list2);
        unionSet.forEach(System.out::println);

    }

}
