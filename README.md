# Hubspot Server
I created this application for a friend of mine who knows the front-end really well but was having some issues due to Hubspot's requirements for hitting their API.

*Unfortunately, my time constraints right now have prevented me from bringing this project to full completion.* 

*The below instructions will not work for anyone but the person they are meant for. The HAPIkey used in the code was a dummy key and will not work. If you would like to use this server for yourself I will be eventually updating it to work for anyone. In the meantime, sorry for the inconvenience.*

## Steps to use:
* Install [JRE 10.0.2](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (Java Runtime Environment)
* Download [hubspot-api-server_v0.1.jar](https://github.com/tylerreece22/hubspot-api/blob/master/hubspot-api-server_v0.1.jar)
* Run jar from terminal
```
java -jar path/to/hubspot-api-server_v0.1.jar
```
* Test server
```
curl localhost:8080/contacts
```
* Let me know when you get everything set up and I can build you a new jar and have it run on a different port if you would like
