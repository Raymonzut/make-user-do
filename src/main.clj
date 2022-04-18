(ns main)

(defn quote [text]
  (str "'" text "'"))

(defn read-valid-targets []
  '("main"))

(defn prompt-valid-target [valid-targets]
  (println "Specify your target:")
  (let [selected-target (first valid-targets)]
    (println "You selected target" (main/quote selected-target))
    selected-target))
  
(defn execute-target [target]
  (println "Executing target" (main/quote target) "step by step"))


(defn -main []
  (->
    (read-valid-targets)
    (prompt-valid-target)
    (execute-target)))
