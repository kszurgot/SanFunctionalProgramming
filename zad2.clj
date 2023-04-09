;; Works for ratio number type
(defn abs [n] (max n (- n)))

;; A
(defn cube-root-heron [x epsilon steps]
  (let [epsilon (if (and (= false epsilon) (= false steps)) 0.00001 epsilon)
        counter (atom 0)
        guess (double x)
        improve (fn [guess] (/ (+ (* 2 guess) (/ x (* guess guess))) 3))]
    (loop [g guess]
      (swap! counter inc)
      (if (= g 0.0) 0
        (if (or (and (not= false epsilon) (< (abs (- g (improve g))) epsilon))
                (and (not= false steps) (>= @counter steps))
            )
          (double g)
          (recur (improve g))
        )
      )
    )
  )
)

;; B
(cube-root-heron 27 0.000001 false)

;; C
(cube-root-heron 27 false 10)

;; Uses a faster solution
(cube-root-heron 27 0.000001 9)
