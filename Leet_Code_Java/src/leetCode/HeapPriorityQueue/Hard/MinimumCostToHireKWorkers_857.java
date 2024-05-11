package leetCode.HeapPriorityQueue.Hard;

import javafx.util.Pair;

import java.util.*;

public class MinimumCostToHireKWorkers_857 {
    class Worker {
        int quality;
        int wage;
        double ratio;
        Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.ratio = this.wage*1.0/this.quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        for(int i=0; i < quality.length; i++){
            workers.add(new Worker(quality[i], wage[i]));
        }

        workers.sort(Comparator.comparingDouble(a -> a.ratio));
        PriorityQueue<Worker> pq = new PriorityQueue<>((a,b)-> b.quality-a.quality);
        double totalQuality = 0, minCost = Double.MAX_VALUE;
        for(Worker worker : workers){
            pq.add(worker);
            totalQuality += worker.quality;
            if(pq.size() == k){
                minCost = Math.min(minCost, totalQuality*worker.ratio);
                totalQuality -= pq.remove().quality;       // Remove the worker with the highest quality
            }
        }

        return minCost;
    }

//    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//        List<Pair<Double, Integer>> rateQualPairs = new ArrayList<>();
//        for(int i = 0; i < quality.length; i++){
//            rateQualPairs.add(new Pair<>(wage[i]/(1.0 * quality[i]), quality[i]));
//        }
//        rateQualPairs.sort(Comparator.comparing(Pair::getKey));
//
//        PriorityQueue<Integer> maxQualHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        int totQual = 0;
//        double res = Double.MAX_VALUE;
//        for(Pair<Double, Integer> rateQualPair: rateQualPairs){
//            maxQualHeap.add(rateQualPair.getValue());
//            totQual += rateQualPair.getValue();
//
//            if(maxQualHeap.size() > k)
//                totQual -= maxQualHeap.poll();
//
//            if(maxQualHeap.size() == k)
//                res = Math.min(res, totQual * rateQualPair.getKey());
//        }
//
//        return res;
//    }
}
