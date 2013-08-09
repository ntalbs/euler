;; #053
;; How many, not necessarily distinct, values of C(n,r), 
;; for 1 ≤ n ≤ 100, are greater than one-million?

(use '[util :only (factorial)])

(defn c [n r]
  (/ (factorial n) (*' (factorial r) (factorial (- n r)))))

(defn p053 []
  (->> (for [n (range 1 101) r (range 1 101)] (c n r))
       (filter #(>= % 1000000))
       count))

(time (println (p053)))