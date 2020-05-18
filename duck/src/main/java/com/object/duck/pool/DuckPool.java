package com.object.duck.pool;

import com.object.duck.model.Duck;
import com.object.duck.vo.DuckQueue;
import com.object.duck.vo.HeadDuckMessage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-17 22:22
 **/
public class DuckPool {
    private static List<Duck> initDuckList = new CopyOnWriteArrayList<>();

    private static Map<Duck, List<Duck>> duckQueueMap = new ConcurrentHashMap<>();


    private DuckPool() {
    }

    public static void registerDuckInPool(Duck newDuck) {
        if (initDuckList != null || initDuckList.size() > 0) {
            initDuckList.add(newDuck);
        } else {
            Integer minSize = Integer.MAX_VALUE;
            Duck minSizeHeadDuck = null;
            for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
                if (entry.getValue().size() < minSize) {
                    minSize = entry.getValue().size();
                    minSizeHeadDuck = entry.getKey();
                }
            }
            if (minSizeHeadDuck != null) {
                duckQueueMap.get(minSizeHeadDuck).add(newDuck);
            }
        }
        System.out.println("duckPool initDuckList size: " + initDuckList.size());
    }

    public static void releaseDuckFromPool(Duck deathDuck) {
        if (initDuckList != null || initDuckList.size() > 0) {
            initDuckList.remove(deathDuck);
        } else {
            for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
                List<Duck> values = entry.getValue();
                boolean isRemove = values.remove(deathDuck);
                if (isRemove) {
                    return;
                }
            }
        }
    }

    public static void run() {
        if (initDuckList != null && initDuckList.size() > 0) {
            for (Duck duck : initDuckList) {
                if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                    System.out.println("duckPool 有头鸭："+duck.getName()+"， 要排队了");
                    firstInline(duck);
                    return;
                }

            }
        }else {
            for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
                List<Duck> ducks = entry.getValue();
                for (Duck duck : ducks) {
                    if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                        addHeadLine(duck);
                        System.out.println("duckPool 有新的鸭："+duck.getName()+"， 要排队了");
                        System.out.println("duckPool duckQueueMap : " + duckQueueMap.size());
                        return;
                    }
                }

            }
        }
    }

    private static void addHeadLine(Duck newHead) {
        Integer total = 0;
        Set<Map.Entry<Duck, List<Duck>>> entries = duckQueueMap.entrySet();
        for (Map.Entry<Duck, List<Duck>> entry : entries) {
            total += entry.getValue().size();
        }

        int average = total / (duckQueueMap.size() + 1);

        List<Duck> newDuckList = new ArrayList<>();
        newDuckList.add(newHead);
        for (Map.Entry<Duck, List<Duck>> entry : entries) {
            List<Duck> values = entry.getValue();

            for (int i = 0; i < values.size(); i++) {
                if (i >= average) {
                    newDuckList.add(values.get(i));
                }
            }
            values.removeAll(newDuckList);
        }


        List<Duck> newQueue = newQueue(newHead,newDuckList);
        duckQueueMap.put(newHead, newQueue);
    }

    private static void firstInline(Duck head) {
        List<Duck> newQueue = newQueue(head, initDuckList);
        duckQueueMap.put(head, newQueue);
        initDuckList.clear();
    }

    private static List<Duck> newQueue(Duck head, List<Duck> duckList) {
        List<Duck> newQueue = new CopyOnWriteArrayList<>();
        newQueue.add(head);

        Duck preDuck = head;
        for (Duck duck : duckList) {
            if (duck.equals(head)) {
                continue;
            }
            HeadDuckMessage headDuckMessage = new HeadDuckMessage(head, preDuck);
            duck.receiveHeadMessage(headDuckMessage);
            newQueue.add(duck);
            preDuck = duck;
        }
        return newQueue;

    }


}
