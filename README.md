demows
===========================

Simple webapp pour illustrer l'utilisation de webservice qui s'appuie sur maven et tomee

## requirement

* JDK version >=8
* maven

## dev

* launch webapp
~~~shell
[user@computer ~/git/demows]$ mvn -Pdev clean package tomee:run
...
~~~

* test webapp
[http://localhost:8080/demows](http://localhost:8080/demows)