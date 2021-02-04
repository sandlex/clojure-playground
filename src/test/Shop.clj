(ns test.Shop)

(def transaction (fn
                   [bank shop item purchaseList]
                   (def price (get shop item))
                   (def funds (get bank 'buyer))
                   (if (>= @funds price)
                     (do
                      (println "Enough funds, you can buy" item)
                      (def revenu (get bank 'merchant))
                      (dosync
                        (ref-set funds (- @funds price))
                        (alter revenu (fn [n] (+ n price)))
                        (alter purchaseList conj item)
                        )
                       )
                     (do
                      (println "Not enough funds, bye!")
                      (println "You purchased" @purchaseList)
                      )
                     )
                   (println "Buyer has" @funds)
                   (println "Merchant has" @revenu)
                   ))


(defn purchase
  [item]
  (def bank {'buyer (ref 100) 'merchant (ref 0)})
  (def shop {'pen 1 'notebook 5 'backpack 10})
  (def purchaseList (ref []))
  (dotimes [x 11]
    (transaction bank shop item purchaseList))
  )
(purchase 'backpack)
