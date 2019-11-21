(ns reclojure.app
  (:require ["react-native" :as rn]
            ["react" :as react]
            ["create-react-class" :as crc]
            ["react-navigation" :as react-navigation]
            [reagent.core :as r]
            [reclojure.schedule :as schedule]))


(def text (r/adapt-react-class (.-Text rn)))
(def view (r/adapt-react-class (.-View rn)))
(def safe-view (r/adapt-react-class (.-SafeAreaView rn)))
(def flatlist (r/adapt-react-class (.-FlatList rn)))
(def touchablewithoutfeedback (r/adapt-react-class (.-TouchableWithoutFeedback rn)))
(def platform (.-Platform rn))
(def link (.-Linking rn))
(def app-registry (.-AppRegistry rn))

(def create-tab-navigator (.-createBottomTabNavigator react-navigation))
(def create-app-container (.-createAppContainer react-navigation))

(defonce droit-img (js/require "../assets/droit.png"))
(defonce cognitect (js/require "../assets/cognitect.png"))
(defonce griffin-large (js/require "../assets/griffin-large.png"))
(defonce griffin (js/require "../assets/griffin.png"))
(defonce uswitch-large (js/require "../assets/uswitch-large.png"))
(defonce uswitch (js/require "../assets/uswitch.png"))
(defonce manning (js/require "../assets/manning.png"))
(defonce twillio-large (js/require "../assets/twillio-large.png"))
(defonce twillio (js/require "../assets/twillio.png"))

(def ios? (= "ios" (.-OS platform)))

(defn schedule-screen
  []
  [safe-view {:style {:flex 1
                      :justify-content "center"
                      :align-items "center"}}
   [text {:style
          {:font-weight "bold"
           :font-size 22}}
    "re:Clojure"]
   [text {:style {:font-size 18}}
    "Schedule"]
   [flatlist {:style {}
              :ListFooterComponent (r/as-element
                                    [view {:style
                                           {:padding-top
                                            (if ios?
                                              90
                                              10)}}])
              :bounces false
              :key (str (random-uuid))
              :initialNumToRender 20
              :maxToRenderPerBatch 20
              :shouldComponentUpdate true
              :removeClippedSubviews true
              :windowSize 50
              :data schedule/data
              :ref :list-ref
              :key-extractor (fn [item idx] (str idx))
              :render-item (fn [item]
                             (let [data (-> item
                                            (js->clj :keywordize-keys true)
                                            :item)]
                               (r/as-element
                                [view {:borderBottomColor "#bbb7b6"
                                       :borderBottomWidth 1
                                       :width "98%"
                                       :paddingTop 20
                                       :paddingBottom 10}
                                 [text {:style {:font-size 14
                                                :font-weight "bold"}} (:time data)]
                                 [text {:style {:font-size 20}} (:title data)]
                                 [text {} (:speaker data)]
                                 [text {:style {:font-size 16}} (:description data)]
                                 (when (contains? data :sponsor)
                                   [view {:style {:flexDirection "row"
                                                  :justify-content "flex-end"}}
                                    [text {:style {:padding-right 10
                                                   :padding-top 8}}
                                     (str "Sponsored by")]
                                    [touchablewithoutfeedback
                                     {:onPress #(.openURL link (:url data))}
                                     [:> rn/Image {:source (case (:sponsor data)
                                                             "griffin" griffin
                                                             "uswitch" uswitch)
                                                   :style {:width 25
                                                           :height 25}}]]])])))}]
   ])

(defn location-screen
  []
  (let [apple-maps-url "http://maps.apple.com/?address=Crypt+on+the+Green,Saint+James+Church,Clerkenwell+Close,London+EC1R+0EA"
        google-maps-url "https://www.google.co.uk/maps/place/Crypt+on+the+Green/@51.5235293,-0.1077747,17z/data=!3m1!4b1!4m5!3m4!1s0x48761b5028780ee5:0x591b515a01c53787!8m2!3d51.523526!4d-0.105586"]
    [safe-view {:style {:flex 1
                        :justify-content "center"
                        :align-items "center"
                        :flexDirection "column"}}

     [text {:style
            {:font-weight "bold"
             :font-size 22}} "re:Clojure"]
     [text {:style {:font-size 18}} "Location"]
     [view {:style {:flex 1
                    :flexDirection "column"}}
      [text {:style {:margin-top 10
                     :font-size 21}}
       [text "Crypt on the Green\n"]
       [text "Saint James Church\n"]
       [text "Clerkenwell Close\n"]
       [text "London\n"]
       [text "EC1R 0EA\n"]]
      [text {:style {:padding-top 10}}
       "See it in a map"]
      (if ios?
        [text {:style {:color "#e91e63"
                       :flexDirection "column"}
               :onPress (fn [] (.openURL link apple-maps-url))}
         "Apple Maps"]
        [text {:style {:color "#e91e63"}
               :onPress (fn [] (.openURL link google-maps-url))}
         "Google Maps"])

      [text {:style {:margin-top 10}}
       "Twitter: "
       [text {:style {:textDecorationLine "underline"
                      :color "#e91e63"}
              :onPress (fn [] (.openURL link "https://twitter.com/reclojure"))}
        "@reclojure"]]]]))


(defn sponsors-screen
  []
  [safe-view {:style {:flex 1
                      :justify-content "center"
                      :align-items "center"
                      :flexDirection "column"}}
   [text {:style
          {:font-weight "bold"
           :font-size 22}} "re:Clojure"]
   [text {:style {:font-size 18}} "Sponsors"]
   [view {:style {:flex 1
                  :flexDirection "column"
                  :align-items "center"}}
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://droit.tech"))}
     [:> rn/Image {:source droit-img
                   :style {:margin-top 20
                           :width 180
                           :height 85}}]]
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://cognitect.com/"))}
     [:> rn/Image {:source cognitect
                   :style {:margin-top 20}}]]
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://uswitch.com/"))}
     [:> rn/Image {:source uswitch-large
                   :style {:margin-top 20}}]]
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://griffin.sh/"))}
     [:> rn/Image {:source griffin-large
                   :style {:margin-top 20}}]]
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://manning.com/"))}
     [:> rn/Image {:source manning
                   :style {:margin-top 20}}]]
    [touchablewithoutfeedback
     {:onPress (fn [] (.openURL link "https://twillio.com/"))}
     [:> rn/Image {:source twillio
                   :style {:margin-top 20}}]]]])


(defn make-screen
  [a-screen]
  {:screen (r/reactify-component a-screen)})


(def tab-navigator
  (create-tab-navigator
   (clj->js {:schedule (make-screen schedule-screen)
             :location (make-screen location-screen)
             :sponsors (make-screen sponsors-screen)})
   (clj->js {:defaultNavigationOptions
             {:tabBarOptions
              {:activeTintColor "white"
               :inactiveTintColor "red"
               :labelStyle {:fontSize 18
                            :fontWeight "bold"}
               :style {:backgroundColor "#4b4d63"}}}})))

(defn app-root [] [:> (create-app-container tab-navigator) {}])

(defn init []
  (.registerComponent app-registry "reClojure" #(r/reactify-component app-root)))
