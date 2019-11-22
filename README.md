# re:Clojure mobile application

For both iOS & Android.

## To run the expo client

Download "Expo" from the iOS App Store or Google Play Store.
Login using reclojure/reclojure.

## How to develop

```
$ yarn global add expo-cli
$ yarn install
```

If you're into emacs:

<kbd>M-x cider-jack-in-cljs</kbd>

and when prompted for the REPL type, enter `shadow` and when prompted
for the app type enter `:app`.


Any other editor:

```
$ shadow-cljs watch app
```

### Start Metro (via expo)

Then to load the app and start Metro (it'll start it in a separate tab
of your terminal):

```
$ expo-cli start --lan -c
```

You can then press i to launch on iOS simulator, or a to launch on (an open) android emulator


## Production build

```
$ shadow-cljs release app
$ expo-cli build:android
$ expo-cli build:ios
```
