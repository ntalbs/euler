;; Farey Sequence: http://en.wikipedia.org/wiki/Farey_sequence
;; If a/b and c/d are neighbours in a Farey sequence, with a/b < c/d, then c/d - a/b = 1/bd.
;; This means bc - ad = 1.
;; In the case of c/d = 3/7, a = (3b - 1) / 7

(ns p071)

(def limit 1000000)

(defn solve []
  (->> (for [b (range limit 2 -1)] (/ (int (/ (- (* 3 b) 1) 7)) b))
       (apply max)))
