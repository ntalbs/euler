;; #041

(ns p041
  (:require [util :refer [parse-int prime?]]
            [clojure.contrib.combinatorics :refer [permutations]]))

(def ds (range 1 10))

(defn investigate [v]
  (->> (permutations (reverse v))
       (map #(parse-int (apply str %)))
       (filter prime?)
       (take 1)))

(defn p041 []
  (flatten (->> (range 9 0 -1)
                (map #(range 1 (inc %)))
                (map investigate)
                (drop-while empty?)
                first)))

(defn solve []
  (time (println (p041))))
