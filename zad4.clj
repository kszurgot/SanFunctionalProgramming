(require '[clojure.set :as set])

(powerset #{:a :b :c})
(powerset #{1 2 3})
(powerset [1 2 3 4])
(powerset [0 1 2])
(powerset (list 0 1 2))

(defn powerset [set]
  (if (empty? set) 
    [[]];
    (let [[first & rest] set] 
      (let [subset (powerset rest)] 
        (concat subset (map (fn [arg] (conj arg first)) subset))
      )
    )
  )
)
