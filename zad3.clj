;;a TODO


;; B i C
(defn fib+ [n]
  ((fn [a b i n]
     (
      if (= i n) b
      (recur b (+' a b) (inc i) n)
     )
   ) 0 1 1 n)
)


(fib+ 10000)
