(ns main
  (:require [clojure.java.io :as io]
            [clojure.tools.cli :refer [parse-opts]]))

(defn quote [text]
  (str "'" text "'"))

(defn read-valid-targets [content]
  '("main"))

(defn prompt-valid-target [valid-targets]
  (println "Specify your target:")
  (let [selected-target (first valid-targets)]
    (println "You selected target" (main/quote selected-target))
    selected-target))
  
(defn execute-target [target]
  (println "Executing target" (main/quote target) "step by step"))

(def cli-options
  [["-i", "--input-file"
    :validate [#(.exists (io/file %))]]])

(defn read-input-file [options]
  (-> options
    :arguments
    first
    slurp))

(defn -main [& args]
  (->
    (parse-opts args cli-options)
    (read-input-file)
    (read-valid-targets)
    (prompt-valid-target)
    (execute-target)))
