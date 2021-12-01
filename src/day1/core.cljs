(ns day1.core)

(defn depth_change_increased
    [prev, next] (if (< prev next) true))

(defn get_occurence_depth_increase
  ([input] (get_occurence_depth_increase input 1 0))
  ([input, i, increased] (if (< i (count input))
                          (if (depth_change_increased (nth input (- i 1)) (nth input i))
                              (recur input (inc i) (inc increased))
                              (recur input (inc i) increased))
                          (println increased))))

(get_occurence_depth_increase (list 199, 200, 208, 210, 200, 207, 240, 269, 260, 263))
