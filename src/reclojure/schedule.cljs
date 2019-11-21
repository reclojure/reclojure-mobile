(ns reclojure.schedule)

(def data
  [{:time "09:30 - 10:15"
    :title "Registration"
    :description "Registration, administration and welcome."
    :type "admin"}
   {:time "10:15 - 10:45"
    :title "Building stuff with Clojure and 3D Printing."
    :speaker "Clément Salaün"
    :description "How to design objects with Clojure, OpenSCAD and then 3D print them. This talk covers the motivations, basic concepts and features with a live demo."
    :type "talk"}
   {:time "10:45 - 11:15"
    :title "Clojure Art"
    :speaker "Karl Brodowsky"
    :description "Teaching or learning Clojure using images has been proven to be fun and beneficial! In this talk, learn how."
    :type "talk"}
   {:time "11:15 - 11:45"
    :description "Coffee/Tea and Biscuits Break (Thank You Griffin!)."
    :type "admin"
    :sponsor "griffin"
    :url "https://griffin.sh"}
   {:type "talk"
    :time "11:45 - 12:15"
    :title "Growing Mobile Apps with ClojureScript and React Native."
    :speaker " Daniel Neal"
    :description "Starting things is fun, but growing them can be a real challenge - and mobile apps are no different..."}
   {:type "talk"
    :time "12:15 - 12:45"
    :title "Live Coding a Mandelbrot Renderer."
    :speaker "Peter Westmacott"
    :description "In this talk, Peter will demonstrate live coding of a fractal renderer, with the aim to show how complex beauty can emerge from simple mathematical rules and a little code."}
   {:type "admin"
    :time "12:45 - 14:00"
    :description "Pizza Party Lunch (Thank You uSwitch!)"
    :sponsor "uswitch"
    :url "https://uswitch.com"}
   {:time "14:00 - 14:45"
    :type "talk"
    :title "Short 10 minute talks."
    :speaker "Various Speakers"
    :description "Various topics"}
   {:type "talk"
    :time "14:45 - 15:15"
    :title "Unleash the power of the REPL."
    :speaker "Dana Borinski"
    :description "Return to basics and dive into how to leverage the REPL to solve problems and debug more quickly - and with the added bonus of honing our Clojure skills!"}
   {:type "talk"
    :time "15:15 - 15:45"
    :title "Generating Generators."
    :speaker "Andy Chambers"
    :description "Generating data for use in tests can be laborious and boring. However, using the database's information schema you can alleviate that! Discover the ways to achieve this."}
   {:type "admin"
    :time "15:45 - 16:15"
    :description "Coffee/Tea and Biscuits Break (Thank You Griffin!)."
    :sponsor "griffin"
    :url "https://griffin.sh"}

   {:time "16:15 - 16:45"
    :type "talk"
    :title "Living in a Box. Life in Containers with the JVM."
    :speaker "Matthew Gilliard."
    :description "A focus on how containers and the JVM interact and what implications are there for Clojure Developers. Get the best results from the work gone into OpenJDK container support."}
   {:time "16:45 - 17:15"
    :type "talk"
    :title "Closing Keynote."
    :speaker "Malcolm Sparks."
    :description ""}
   {:time "17:15 - 17:30"
    :type "talk"
    :description "Closing Notes."
    :speaker "Various Speakers."}
   {:time "17:30 - 23:00"
    :type "admin"
    :description "Pub time"
    :sponsor "uswitch"
    :site "https://uswitch.com"}])
