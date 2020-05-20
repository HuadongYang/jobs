package com.object.duck.pool;

import com.object.duck.model.Duck;
import com.object.duck.vo.DuckQueue;
import com.object.duck.vo.HeadDuckMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static com.object.duck.utils.Constants.DUCK_THIN_WEIGHT;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-17 22:22
 **/
public class DuckPool {

    private static DuckPool instance = null;


    private static List<Duck> freeDuckList = new CopyOnWriteArrayList<>();

    private static Map<Duck, List<Duck>> duckQueueMap = new ConcurrentHashMap<>();


    private DuckPool() {
        freeDuckList = new CopyOnWriteArrayList<>();

        duckQueueMap = new ConcurrentHashMap<>();
    }

    public static DuckPool getInstance() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (instance == null) {
            synchronized (DuckPool.class) {
                if (instance == null) {
                    instance = new DuckPool();
                }
            }
        }
        return instance;
    }

    public List<Duck> getFreeDuckList() {
        List<Duck> ducks = new ArrayList<>();
        if (freeDuckList != null || freeDuckList.size() > 0) {
            ducks.addAll(freeDuckList);
        }
        for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
            ducks.addAll(entry.getValue());
        }
        return ducks;
    }

    public void queueToFree(Duck duck) {
        duck.setDuckQueue(new DuckQueue());
        releaseDuckFromQueue(duck);
        freeDuckList.add(duck);
    }

    public void registerDuckInPool(Duck newDuck) {
        if (duckQueueMap.size() > 0) {
            registerDuckInMap(newDuck);
        } else {
            freeDuckList.add(newDuck);
        }
    }

    private void registerDuckInMap(Duck newDuck) {
        Integer minSize = Integer.MAX_VALUE;
        Duck minSizeHeadDuck = null;
        for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
            if (entry.getValue().size() < minSize) {
                minSize = entry.getValue().size();
                minSizeHeadDuck = entry.getKey();
            }
        }
        if (minSizeHeadDuck != null) {
            List<Duck> ducks = duckQueueMap.get(minSizeHeadDuck);
            HeadDuckMessage headDuckMessage = new HeadDuckMessage(minSizeHeadDuck, ducks.get(ducks.size() - 1));
            newDuck.receiveHeadMessage(headDuckMessage);
            ducks.add(newDuck);
        }
    }

    public void releaseDuckFromPool(Duck deathDuck) {
        boolean remove = freeDuckList.remove(deathDuck);
        if (remove) {
            return;
        }
        if (deathDuck.getType().equals(Duck.DuckType.HEAD)) {
            List<Duck> deathQueue = duckQueueMap.get(deathDuck);
            deathQueue.remove(deathDuck);
            duckQueueMap.remove(deathDuck);
            dismissAndJoinOtherLine(deathQueue);
        } else {
            releaseDuckFromQueue(deathDuck);
        }
    }

    private void releaseDuckFromQueue(Duck deathDuck) {
        for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
            List<Duck> values = entry.getValue();
            boolean isRemove = values.remove(deathDuck);
            if (isRemove) {
                reLine(entry.getKey(), entry.getValue());
                return;
            }
        }
    }

    public void dismissAndJoinOtherLine(Duck headToBeNormal) {
        dismissAndJoinOtherLine(duckQueueMap.get(headToBeNormal));
        duckQueueMap.remove(headToBeNormal);
    }

    public void dismissLine(List<Duck> duckList) {
        for (Duck duck : duckList) {
            duck.setDuckQueue(new DuckQueue());
            freeDuckList.add(duck);
        }
    }

    public void dismissAndJoinOtherLine(List<Duck> duckList) {
        if (duckQueueMap.size() == 0) {
            dismissLine(duckList);
            return;
        }

        int assignCount = duckList.size() / duckQueueMap.size();

        List<Duck> heads = new ArrayList<>(duckQueueMap.keySet());
        for (int i = 0; i < duckQueueMap.size(); i++) {
            Duck head = heads.get(i);
            List<Duck> subDucks = duckList.subList(i * assignCount, i * assignCount + assignCount);
            List<Duck> ducks = duckQueueMap.get(head);
            Duck lastDuck = ducks.get(ducks.size() - 1);

            Duck preDuck = lastDuck;

            for (Duck duck : subDucks) {
                HeadDuckMessage headDuckMessage = new HeadDuckMessage(head, preDuck);
                duck.receiveHeadMessage(headDuckMessage);
                preDuck = duck;
            }
            ducks.addAll(subDucks);
        }
        duckList.clear();
    }

    private void reLine(Duck head, List<Duck> duckList) {
        List<Duck> line = line(head, duckList);
        duckQueueMap.put(head, line);
    }

    public void run() {
        for (Duck duck : freeDuckList) {
            if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                System.out.println("duckPool 有头鸭：" + duck.getName() + "， 要排队了");
                List<Duck> duckExceptThinDucks = freeDuckList.stream().filter(x -> x.getWeight() > DUCK_THIN_WEIGHT).collect(Collectors.toList());
                firstInline(duck, duckExceptThinDucks);
                return;
            }

        }
        for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
            List<Duck> ducks = entry.getValue();
            for (Duck duck : ducks) {
                if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                    addHeadLine(duck);
                    System.out.println("duckPool 有新的鸭：" + duck.getName() + "， 要排队了");
                    System.out.println("duckPool duckQueueMap : " + duckQueueMap.size());
                    return;
                }
            }

        }
    }

    private void addHeadLine(Duck newHead) {
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


        List<Duck> newQueue = line(newHead, newDuckList);
        duckQueueMap.put(newHead, newQueue);
    }

    private void firstInline(Duck head, List<Duck> duckExceptThinDucks) {
        List<Duck> newQueue = line(head, duckExceptThinDucks);
        duckQueueMap.put(head, newQueue);
        freeDuckList.removeAll(duckExceptThinDucks);
    }

    private List<Duck> line(Duck head, List<Duck> duckList) {
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
