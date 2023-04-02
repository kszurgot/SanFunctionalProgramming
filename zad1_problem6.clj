(defn sum [funk n]
  (if (= 1 n) 1
      (+ (funk n) (sum funk (dec n)))
  )
)

(defn square [n] (* n n))


(sum square 10)
(square (sum identity 10))

(- (square (sum identity 10)) (sum square 10))

(- (square (sum identity 100)) (sum square 100))