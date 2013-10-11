;; #079

(require '[clojure.set :as set])
(use '[util :only (digits)])

(def keylog
  (->> (clojure.string/split (slurp "../data/keylog.txt") #"\r\n")
       distinct
       sort))

(def pairs
  (->> (map #(Integer/parseInt %) keylog)
       (map digits)
       (mapcat #(partition 2 1 %))
       distinct))

(def key-digits (set (flatten pairs)))

(defn minus [s1 s2]
  (set/difference s1 s2))

(defn find-key [ps acc]
  (let [ps (filter #(not= (last acc) (first %)) ps)]
    (if (= 1 (count ps))
      (into acc (first ps))
      (recur ps
             (into acc (minus (set (map first ps)) (set (map second ps))))))))

(defn p079 []
  (apply str
         (find-key pairs [])))

(time (println (p079)))