(ns meetup-2-16-2011.check-urls
  ^{:doc "Little utility to check the validity of URLs."
    :author "julien.c.chastang@gmail.com"}
  (:use [clojure.string :only [split]]
	[clojure.contrib.repl-utils])  
  (:import [java.net URL
	    HttpURLConnection]))

(def line-separator (System/getProperty "line.separator"))

(defn valid-url?
  "Check to see if the URL is valid by checking response code (200)"
  [url]
  (try 
    (let [c (.openConnection (URL. url))]
      (= HttpURLConnection/HTTP_OK (.getResponseCode c)))
    (catch Exception _
      false)))

(def urls (split (slurp "webcams.txt")
		 (re-pattern line-separator)))

(defn check-url
  "Check URL"
  [url]
  (set [(str url)
	(valid-url? url)]))

(defn check-urls
  [urls]
  (doall (pmap #(check-urls %) urls)))

(def answers (future check-urls urls))

(future-done? answers)

@answers