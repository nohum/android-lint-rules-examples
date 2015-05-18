Android lint rules example app
==============================

Demo application to showcase the lint rules that can be found in [the other repository](https://github.com/nohum/android-lint-rules).
This demo app is used as a playground to test and to develop the said lint rules.

Important: if you are debugging the lint rules and are using plain out `System.out`, you need to start the build via gradle with daemon-support like so:

```
gradle --no-daemon lint
```

(However, to stay sane it is the best to write debug outputs to a file at `/tmp`.)