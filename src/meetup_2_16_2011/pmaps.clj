(ns meetup-2-16-2011.pmaps)

;; long running function
(defn long-f [f & args]
  (Thread/sleep 1000)
  (apply f args))

(defn sqr [x] (* x x))

(map #(sqr %) (range 0 10))

(time (def a (doall (map #(long-f sqr %) (range 0 10)))))

;; Now try with pmap

(time (def b (doall (pmap #(long-f sqr %) (range 0 10)))))

;; Under the hood pmap uses futures