;; http://en.wikipedia.org/wiki/Continued_fraction
;; http://en.wikipedia.org/wiki/Pell%27s_equation

(ns p066
  (:require [util :refer [perfect-square?]]
            [p064 :refer [expand-continued-fraction]]))

(defn solve-pells-equation [d]
  (let [cf (expand-continued-fraction d)
        as (lazy-cat cf (flatten (repeat (rest cf))))]
    (loop [h2 0, h1 1,
           k2 1, k1 0,
           as as, n 0]
      (if (and (>= n 1) (= 1 (-' (*' h1 h1) (*' d k1 k1))))
        [h1 k1]
        (recur h1 (+' (*' (first as) h1) h2)
               k1 (+' (*' (first as) k1) k2)
               (rest as) (inc n))))))

(defn p066 []
  (->> (range 2 (inc 1000))
       (filter (complement perfect-square?))
       (map (fn [d] [d (first (solve-pells-equation d))]))
       (apply (partial max-key second))))

(defn solve []
  (time (p066)))
