# re:Clojure mobile application

For both iOS & Android.

## How to develop

```
$ npm install && cd react-native && npm install
```

If you're into emacs:

<kbd>M-x cider-jack-in-cljs</kbd>

and when prompted for the REPL type, enter `shadow` and when prompted
for the app type enter `:app`.


Any other editor:

```
$ shadow-cljs watch app
```

### Start Metro

Then to load the app and start Metro (it'll start it in a separate tab
of your terminal):

```
$ react-native run-android
```
(Note: you'll need to start Android emulator first.)


or

```
$ react-native run-ios
```

## Production build

```
$ shadow-cljs release app
```
