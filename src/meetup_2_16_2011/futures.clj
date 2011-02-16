y(ns ^{:doc "Examples of futures"
      :author "julien.c.chastang@gmail.com"}
  meetup-2-16-2011.futures)

;; Trivial example

(def a (future (+ 1  2  3)))

@a

;; Example w/ expensive function

(defn long-f [f & args]
  (Thread/sleep 10000)
  (apply f args))

(def b (future (long-f + 1 2 3)))

@b

(future-done? b)

@b
