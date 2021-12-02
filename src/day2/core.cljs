(ns day2.core
  (:require [clojure.string :as str])
  (:require [clojure.java.io :as io]))

(defn move
  [[x, y], direction, amount] (cond
                              (= direction "forward") [(+ x amount), y]
                              (= direction "up") [x, (- y amount)]
                              (= direction "down") [x, (+ y amount)]))

(defn follow_route
  ([input] (follow_route input [0, 0] 0))
  ([input, [x, y], i] (if (= i (count input)) [x, y]
                             (recur input (move [x, y] (nth (str/split (nth input i) #" ") 0) (Integer/parseInt (nth (str/split (nth input i) #" ") 1))) (inc i)))))

(def input (str/split (slurp (io/resource "day2/input.txt")) #"\n"))

(println (reduce * (follow_route input)))

