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

### How to start the REPL

If you're into emacs, the following command will start the REPL and
connect you to it:

<kbd>M-x cider-jack-in-cljs</kbd>

When prompted for the REPL type, enter `shadow` and when prompted for
the app type enter `:app`. But really, the included `.dir-locals.el`
should handle the prompting and answering for you.

For any other editor:

```
$ shadow-cljs watch app
```

it'll start the build and the nREPL session on port 3333.


## Production build

```
$ shadow-cljs release app
```
