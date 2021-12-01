(ns day1.core)

(defn depth_change_increased
    [prev, next] (if (< prev next) true))

(defn get_occurence_depth_increase
  ([input] (get_occurence_depth_increase input 1 0))
  ([input, i, increased_count] (if (< i (count input))
                          (if (depth_change_increased (nth input (- i 1)) (nth input i))
                              (recur input (inc i) (inc increased_count))
                              (recur input (inc i) increased_count))
                          (println increased_count))))

(defn sliding_window
  ([input, window_size] (sliding_window input window_size [] 0))
  ([input, window_size, output, i] (if (<= i (- (count input) window_size))
                        (recur input window_size (conj output (reduce + (drop i (take (+ i window_size) input)))) (inc i))
                        output)))

(get_occurence_depth_increase (sliding_window (list 199, 200, 208, 210, 200, 207, 240, 269, 260, 263) 3))
