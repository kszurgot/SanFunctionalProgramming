(defn sum [fn n]
  (if (= 1 n)
    1 
    (+ (fn n) (sum fn (dec n)))
))

(defn square [n] (* n n))

(defn do-nothing [n] n)

(sum square 10)
(square (sum do-nothing 10))

(- (square (sum do-nothing 10)) (sum square 10))

(- (square (sum do-nothing 100)) (sum square 100))