;; What is the value of the first triangle number to have over five hundred divisors?

(ns p012
  (:require [util :refer [factorize]]))

(defn d
  "Returns the number of divisors of n.
   Refer to http://mathschallenge.net/library/number/number_of_divisors"
  [n]
  (->> (factorize n)
       (map (fn [[_ e]] (+ e 1)))
       (apply *)))

(def triangle-numbers (reductions + (iterate inc 1)))

(defn solve []
  (->> triangle-numbers
       (drop-while #(< (d %) 500))
       first))
