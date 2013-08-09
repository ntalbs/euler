;; #036

(require '[clojure.string :only (reverse) :as s])

(defn binstr [n]
  (Integer/toBinaryString n))

(defn palindromic? [s]
  (= s (s/reverse s)))

(defn dec-palindromic? [n]
  (palindromic? (str n)))

(defn bin-palindromic? [n]
  (palindromic? (Integer/toBinaryString n)))

(defn p036 []
  (->> (range 1 (inc 1000000))
       (filter (fn [n] (and (dec-palindromic? n) (bin-palindromic? n))))
       (apply +)))

(time (println (p036)))