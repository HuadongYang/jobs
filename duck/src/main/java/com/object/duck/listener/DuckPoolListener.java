package com.object.duck.listener;

import com.object.duck.model.Duck;
import com.object.duck.pool.DuckPool;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.object.duck.utils.Constants.DUCK_THIN_WEIGHT;

public class DuckPoolListener {

    private DuckPool duckPool;
    public DuckPoolListener(DuckPool duckPool) {
        this.duckPool = duckPool;
    }

    public void listen() {
        while (true) {
            List<Duck> freeDuckList = duckPool.getFreeDuckList();
            Map<Duck, List<Duck>> duckQueueMap = duckPool.getDuckQueueMap();

            for (Duck duck : freeDuckList) {
                if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                    List<Duck> duckExceptThinDucks = freeDuckList.stream().filter(x -> x.getWeight() > DUCK_THIN_WEIGHT).collect(Collectors.toList());
                    duckPool.firstInline(duck, duckExceptThinDucks);
                    return;
                }

            }
            for (Map.Entry<Duck, List<Duck>> entry : duckQueueMap.entrySet()) {
                List<Duck> ducks = entry.getValue();
                for (Duck duck : ducks) {
                    if (duck.getType().equals(Duck.DuckType.HEAD) && !duckQueueMap.keySet().contains(duck)) {
                        duckPool.addHeadLine(duck);
                        return;
                    }
                }

            }
        }

    }
}
