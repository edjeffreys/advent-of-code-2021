(ns day2.core
  (:require [clojure.string :as str])
  (:require [clojure.java.io :as io]))

(defn move
  [[x, y, aim], direction, amount] (cond
                              (= direction "forward") [(+ x amount), (+ y (* aim amount)), aim]
                              (= direction "up") [x, y, (- aim amount)]
                              (= direction "down") [x, y, (+ aim amount)]))

(defn follow_route
  ([input] (follow_route input [0, 0, 0] 0))
  ([input, [x, y, aim], i] (if (= i (count input)) [x, y]
                             (recur input (move [x, y, aim] (nth (str/split (nth input i) #" ") 0) (Integer/parseInt (nth (str/split (nth input i) #" ") 1))) (inc i)))))

(def input (str/split (slurp (io/resource "day2/input.txt")) #"\n"))

(println (reduce * (follow_route input)))
