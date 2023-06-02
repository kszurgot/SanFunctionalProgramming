;; a
(defn cube [x]
  (* x x x)
)

(defn average [x y]
  (/ (+ x y) 2)
)

(defn good-enough? [guess x epsilon]
  (< (Math/abs (- (cube guess) x)) epsilon) ;; |guess^2 - x| < epsilon 
)

(defn next-guess [guess x] 
  (average guess (/ x (* guess guess))) ;; x/guess^2
)

(defn cube-root-iter [guess x epsilon]
  (if (good-enough? guess x epsilon)
    guess
    (cube-root-iter (next-guess guess x) x epsilon)
  )
)

(defn cube-root [x initial-guess epsilon]
  (cube-root-iter initial-guess x epsilon)
)

(cube-root 27.0 1.0 0.00001)

;; b
(defn cube-root-by-newtons-method [y initial-guess epsilon max-iterations]
  (let [
        f (fn [x] (- (* x x x) y)) ;; funkcja f(x) = x^3 - y
        df (fn [x] (* 3 (* x x))) ;; pochodna funkcji f(x) = 3x^2
        newton-next (fn [x] (- x (/ (f x) (df x)))) ;; wzór iteracyjny x = x - f(x)/f'(x)
       ]

       (letfn 
           [(try-guess [guess iter]
              (if (or (< (Math/abs (f guess)) epsilon) (<= iter 0))
                guess
                (try-guess (newton-next guess) (dec iter))
              )
           )]
           (try-guess initial-guess max-iterations)
       )
  )
)

(cube-root-by-newtons-method 27.0 1.0 0.00001 100)

;; c
(defn compose [f g]
  (fn [x] (f (g x)))
)

((compose cube inc) 6) ;; (6+1)^3

;; d
(defn compose-repeated [f n]
  (loop [
         result identity
         count 0
        ]
        (if (>= count n)
            result
            (recur (compose result f) (inc count))
        )
  )
)

((compose-repeated cube 2) 2) ;; (2^3)^3
