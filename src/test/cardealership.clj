(ns test.cardealership)

(def printCarsForBudget (fn [budget cars discount] (
                                                    (doseq [car cars]
                                                      (def price (:price car))
                                                      (if (<= (- price (* price discount)) budget)
                                                        (println (:model car))
                                                        )
                                                      )
                                                    )))

(defn getOffer
  [budget coupon]
  (defstruct car :model :price)
  (def cars [(struct car 'bmw 60000) (struct car 'ferrari 100000) (struct car 'fiat 20000)])
  (def coupons {'iddqd 20})
  (def discount (get coupons coupon))
  (if (= discount nil)
    (do
      (println "Coupon is not valid")
      (println "Budget" budget)
      (printCarsForBudget budget cars 0))
    (do
      (println "Coupon is valid")
      (println "Budget" budget)
      (printCarsForBudget budget cars (* discount 0.01)))
    )
  )
(getOffer 50000 'iddqd)
