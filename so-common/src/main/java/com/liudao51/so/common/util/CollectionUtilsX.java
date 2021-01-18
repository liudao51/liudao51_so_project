package com.liudao51.so.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * TODO: 集合工具类
 *
 * @author jewel.liu
 * @since 1.0, Sep 10, 2018
 */
public class CollectionUtilsX {
    private CollectionUtilsX() {
    }

    /**
     * TODO: 检查集合是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Collection value) {
        return !(null != value && value.size() > 0);
    }

    /**
     * TODO: 检查指定元素是否在数组中
     *
     * @param container
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean isArrayContainsValue(T[] container, T value) {
        return Arrays.asList(container).contains(value);
    }

    /**
     * TODO: 检查指定元素数组是否在数组中
     *
     * @param container
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean isArrayContainsArray(T[] container, T[] array) {
        Set<T> containerSet = new HashSet(Arrays.asList(container));
        int containerSize = containerSet.size();
        containerSet.addAll(Arrays.asList(array));

        // container包含array之后,containerSet大小是否有所增大
        return (containerSet.size() == containerSize);
    }

    /**
     * TODO: 把map转换为JSONObject
     *
     * @param map
     * @return
     */
    public static JSONObject mapToJson(Map map) {
        JSONObject jsonObj = new JSONObject(map);

        return jsonObj;
    }

    /**
     * TODO: 把数组元素通过分隔符连接成一个字符串
     *
     * @param array
     * @param splitStr
     * @param sideStr
     * @return
     */
    public static <T> String join(T[] array, String splitStr, String sideStr) {
        if (ArrayUtils.isEmpty(array)) {
            return "";
        }
        if (array.length == 1) {
            return String.valueOf(array[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(splitStr);
            }
            sb.append(sideStr);
            sb.append(String.valueOf(array[i]));
            sb.append(sideStr);
        }

        return sb.toString();
    }
}
