;; #099

(use '[clojure.string :only (split)])

(defn parse-int [s] (Integer/parseInt s))

(def log-vals
  (->> (map (fn [s] (split s #",")) (split (slurp "data/base_exp.txt") #"\r\n"))
       (map (fn [[b e]] [(parse-int b) (parse-int e)]))
       (map (fn [[b e]] (* e (Math/log10 b))))
       (map-indexed vector)))

(defn p099 []
  (+ 1 (first (apply max-key (fn [[i v]] v) log-vals)))) ; +1, since log-vals index is zero-based

(time (println (p099)))
