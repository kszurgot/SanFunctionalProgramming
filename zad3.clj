;; A
(defn fib-steps [n]
  (let
    [counter (atom 0)]
    ((defn fib [n]
       (swap! counter inc)
       (if (< n 2) n
           (+' (fib (- n 1))
              (fib (- n 2))
           )
       )
     ) n)
     @counter)
)

(fib-steps 5) ;; result: 15


;; B i C
(defn fib+ [n]
  ((fn [a b i n]
     (if (= i n) b
         (recur b (+' a b) (inc i) n)
     )
   )
  0 1 1 n)
)

(fib+ 10000)
