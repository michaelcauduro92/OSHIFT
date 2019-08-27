# OSHIFT PROJECT , CONNECT TWO SPRING BOOT MICROSERVICES AND MONGODB IN OPENSHIFT

This is a simple project created to understand Oshift PaaS structure.

The scenario consist in 2 spring-boot microservices, microservice A (oshiftbackend) comunicate with a mongodb database and microservices B (oshiftboot) communicate with microservice A and expose REST Api .
follow this guide that is a similar scenario and helps me to create and understand this process : https://dzone.com/articles/how-to-run-java-microservices-on-openshift-using-s

So first of all you have to download oshift (i used oc 3.6.1 available at this link : https://github.com/openshift/origin/releases/tag/v3.6.1 ) and simply run cmd in the folder where you downloaded it, with docker for windows running (i obviusly used windows) run the "oc cluster up" command that allow to start a openshift cluster.

then with the command new-project and new-app (read a oc command guide) you can connect, before microservice A and after microservice B, this github project. you can find a guide that i used to understand those phases here : http://www.mastertheboss.com/jboss-frameworks/spring/deploy-your-springboot-applications-on-openshift.

But before you need to create a mongodb image from the browser catalog and use it as a service for your project. you don't have to setup anything, follow the steps and once done you'll se a mongodb pod running on your porject, you can now use the mongo secrets as environments to inject to your spring boot microservice (in this case microservice A that need and communicate with a mongodb).

now you can do the microservice's connection explained before and once done you can build and deploy your microservices in openshift, then create a route and test the connection.
inspect the microservices structure and the endpoint so you'll understand better the functionality of those. 
Enjoy
Michael Cauduro
