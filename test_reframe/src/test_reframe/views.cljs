(ns test-reframe.views
  (:require
   [re-frame.core :as re-frame]
   [test-reframe.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Hello from " @name]
     ]))
