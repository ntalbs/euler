;; #048

(defn p048 []
  (.mod (->> (range 1 (inc 1000))
             (map biginteger)
             (map #(.pow % %))
             (apply +')
             (.toBigInteger)) (biginteger 10000000000)))

(time (println (p048)))