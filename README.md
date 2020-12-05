# re:Clojure mobile application

## How to develop

### Install dependencies

For both iOS & Android

```
$ (npm install && cd react-native && npm install)
```

#### iOS

Install cocoapods Ruby gem and pods:

```
$ cd react-native/ios
$ bundle install & bundle exec pod install
```

### Start Metro

#### iOS

```
$ react-native run-ios
```

#### Android

Then to load the app and start Metro (it'll start it in a separate tab
of your terminal):

```
$ react-native run-android
```
(Note: you'll need to start Android emulator first.)

If you're into emacs:

<kbd>M-x cider-jack-in-cljs</kbd>

and when prompted for the REPL type, enter `shadow` and when prompted
for the app type enter `:app`.

Any other editor:

```
$ shadow-cljs watch app
```

## Production build

```
$ shadow-cljs release app
```
