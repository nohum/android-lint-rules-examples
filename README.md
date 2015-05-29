Android lint rules example app
==============================

Demo application to showcase the lint rules that can be found in [the other repository](https://github.com/nohum/android-lint-rules).
This demo app is used as a playground to test and to develop the said lint rules.

Important: if you are debugging the lint rules and are using plain out `System.out`, you need to start the build via gradle with daemon-support like so:

```
gradle --no-daemon lint
```

(However, to stay sane it is the best to write debug outputs to a file at `/tmp`.)

Some rules provided by the other repository like the `LocationUsageDetectorAst` and `LocationUsageDetectorBytecode`
change their behaviour in detecting issues if the api level is changed.

As an example, calls to `LocationManager.addProximityAlert` are only detected in this project if the api level equals 17 or higher.
Another example are calls to `LocationManager.isProviderEnabled` which would only raise a warning if called on api levels smaller than 21.

Change the api level in the file `app/build.gradle` on the line containing `targetSdkVersion`.