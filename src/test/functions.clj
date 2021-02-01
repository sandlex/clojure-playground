(ns test.functions
  (:gen-class))

(defn -main
  ""
  []
  (println "test")
  (+ 1 1))

(#(println "Hello" %1 %2) "12" "34")

(def incr (fn [x] (+ x 1)))

(defn incr_set
  [x]
  (map incr x))



