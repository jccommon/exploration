package com.jc.common.exploration.concurrenthashmapcase;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap线程安全的HashMap，且比Hashtable效率高很多
 * ConcurrentHashMap由Segment数组和HashEntry数组结构组成，
 * 对HashEntry进行修改时必须获得其所在的Segment的锁
 * put操作的时候，根据key的哈希结果将数据存储到不通Segment上， 会进行两次哈希否则哈西冲突会很严重都放到同一个Segment上
 * get操作非常高效率，因为不需要加锁这里要用到的共享变量都引入了volatile，除非读到的值是空的才会加锁重读
 * size操作先尝试2次通过不锁住Segment的方式来统计各个Segment的大小，在put、remove和clean方法里操作元素前都会将变量modCount进行加1，过成中如果modcount发生变化则加锁再统计一次
 */
public class Test1 {

    private ConcurrentHashMap concurrentHashMap;





}
