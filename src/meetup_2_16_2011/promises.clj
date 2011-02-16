(ns meetup-2-16-2011.promises)


;; Create promise

(def a (promise))

(def b (ref []))

(def c (future (if @a (dosync (alter b conj 1)))))

(future-done? c)

@b

(deliver a :foo)

(future-done? c)

@b

