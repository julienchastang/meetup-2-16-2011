(ns  meetup-2-16-2011.futures)

;; Trivial example

(def a (future (+ 1  2  3)))

@a

;; Example w/ expensive function

(defn long-f [f & args]
  (Thread/sleep 10000)
  (apply f args))

(def b (future (long-f + 1 2 3)))

;; Blocks!
@b

(future-done? b)

@b
