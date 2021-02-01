(ns test.petconverter
  (:gen-class))

(def get-factor (fn [map type] (get map type)))

(defn -main
  [type age]
  (def ageMap {'dog 7, 'cat 5, 'goldfish 10})
  (* (get-factor ageMap type) age))
