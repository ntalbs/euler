;; #029
;; How many distinct terms are in the sequence generated by a^b
;; for 2  a  100 and 2  b  100?

(ns p029
  (:require [util :refer [pow]]))

(defn p029 []
  (let [rng (range 2 (inc 100))]
    (count (into #{} (for [a rng b rng] (pow a b))))))

(defn solve []
  (time (println (p029))))
