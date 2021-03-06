(ns p085)

(defn rect-cnt [m n]
  (/ (* m (inc m) n (inc n)) 4))

(defn delta [n]
  (Math/abs (- 2000000 n)))

(defn solve []
  (let [MAX 100]
    (->> (for [x (range 1 MAX)
               y (range 1 MAX)
               :let [cnt (rect-cnt x y)]]
           [x y cnt (delta cnt)])
         (apply min-key last)
         ((fn [[x y _ _]] (* x y))))))
