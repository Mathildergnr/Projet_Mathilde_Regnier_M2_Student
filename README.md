# https://start.spring.io/#

https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.1.5&packaging=jar&jvmVersion=21&groupId=fr.efrei&artifactId=server&name=server&description=Demo%20project%20for%20Spring%20Boot&packageName=fr.efrei.server&dependencies=web,devtools,data-jpa,h2



#1 https://spring.io/guides/gs/spring-boot/
#2 https://www.baeldung.com/spring-boot-h2-database

./gradlew bootRun

h2 url: jdbc:h2:file:./build/h2db/data/demo

