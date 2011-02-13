(ns meetup-2-16-2011.core)

;; Simple agent example 

(def a (agent []))

;; Send takes agent, action function, and args

(send a conj 1)

(send-off a conj 2)

;; deref
@a

;; A "heavier" example

;; Action function supplied agent, function, and args.

(defn action-f [a f & args]
  (Thread/sleep 5000)
  (apply f a args))

(send a action-f conj 3)

@a

;; Wait a bit

@a
