# ISO 8583 Decoder
ISO 8583 Decoder is a microservice with two APIs for decoding the Data Element 108 of the ISO 8583 specification. This service is current 
running [here](https://9dhajsauof.execute-api.ca-central-1.amazonaws.com/swagger-ui.html). Feel free to test this API using the web interface 
provided.

## Languages and Frameworks
- Java 11
- Spring Boot Framework 2.5.2
- Lombok
- JUnit
- Swagger 2

## Libraries
- [Java Fluent Validator](https://github.com/mvallim/java-fluent-validator)

## Documentation
The documentation for the ISO 8583 Decoder is available online through the Swagger interface 
[here](https://9dhajsauof.execute-api.ca-central-1.amazonaws.com/swagger-ui.html). Below you can find details on how you can build and run this 
microservice locally.

## Introduction
The ISO 8583 Decoder is a message decoder for the ISO 8383 protocol. Currently, it only supports the data element 108. However, 
developers can extend this application to process other data elements. It is capable of decoding LLLVAR data elements encoded with TLV (Tag-Length-Value).  

## System Design
ISO 8583 Decoder is a Java microservice built using the Spring boot web framework. I used the [Java Fluent Validator](https://github.com/mvallim/java-fluent-validator)
library for performing business logic validator. This library was developed by my squad while I was working as a Senior 
Software Engineer for [Itau Bank](https://en.wikipedia.org/wiki/Ita%C3%BA_Unibanco) and release open source in 2020. I also used the TLV ligics 
of the [Emv QR Code](https://github.com/mvallim/emv-qrcode) which was developed by my team back in 2020, and it is currently running in hundreds of 
serverless applications and microservices at Itau. We can discuss more detail about them in the interview. This microservice was created using
SOLID concepts and DDD. There is 27 unit tests in total, and some of them were created using TDD.

Just as a quick overview about myself, I work with financial protocols, including ISO 8583 and EMV, since 2017. I have a deep
knowledge of issuer specific protocols, such as the VISA one from ROHO cred card. Feel free to check my [portfolio](https://jaimedantas.com/portfolio.html) and [LinkedIn](https://www.linkedin.com/in/jaimedantas/).

## Build and Run
You can run the ISO 8583 Decoder either with Docker or Maven (Maven is a build automation tool used for Java projects).

### Docker
Open a terminal and go to the `app` directory with the `Dockerfile`. Now build the container image using the docker `build command` command:
````shell
 docker build -t iso8583-decoder .
````
Now that we have the docker image, let’s run the application. To do so, use the docker run command:
````shell
 docker run -p iso8583-decoder 
````
After a few seconds, open your web browser to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html). 
You should see the ISO 8583 Decoder Swagger interface and start to play with it.

### Maven
Open a terminal and go to the `app` directory and run:
````shell
mvn clean package
````
Now that we have the `jar` package, let’s run the application. To do so, use the `java` run command inside the `target` folder:
````shell
java -jar iso8583-decoder-0.0.1-SNAPSHOT.jar
````
After a few seconds, open your web browser to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
You should see the ISO 8583 Decoder Swagger interface and start to play with it.

## APIs
There are two endpoints from chose from. The first one is the `/decoder/de108/file` which is used to upload a `TXT` file with multiple transaction
to the server. The output is a `JSON` response with the parsed data elements. The second APIs receives a single transaction as a 
parameter and outputs the `JSON` representation. Here you can use the web interface to try out the endpoints. 
![](doc/web.png)

### Single Transaction
#### Example Input: 
```shell
curl -i -XPOST "https://9dhajsauof.execute-api.ca-central-1.amazonaws.com/decoder/de108/transaction?dataElement108=14701600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204"
```
#### Example Successful Output:
```json
{
    "receiver": {
        "first": "EMMA",
        "middle": "ANTHONY",
        "last": "VAUGHN",
        "city": "MACHIAS",
        "state": "VI",
        "account": "1746093087"
    },
    "sender": {
        "first": "BRENDA",
        "middle": "ANNABELLE",
        "last": "MCGUIRE",
        "city": "DATIL",
        "state": "MO",
        "account": "1254468189"
    },
    "referenceData": {
        "fundingSource": "03",
        "transactionPurpose": "04"
    }
}
```
#### Example Business Error Output:
```json
{
   "valid": false,
   "errors": [
      {
         "message": "Transaction cannot be completed since it is for crypto purpose",
         "field": "ReferenceData",
         "attemptedValue": {},
         "code": null
      }
   ]
}
```

### Testing with AWS
This microservice was deployed on AWS and it is currently runing on the following URL:
```shell
https://9dhajsauof.execute-api.ca-central-1.amazonaws.com
```
For the accesing the WEB interface, you can go to:
```shell
https://9dhajsauof.execute-api.ca-central-1.amazonaws.com/swagger-ui.html
```
Please note that the API Gateway has absolutely no security features in place, so don't try to break it :)

### Multiple Transactions Using a Batch File
Alternatively, you can send a `TXT` file the the `/decoder/de108/file` endpoint and expect a collection of `JSON` objects.

## Message to the Hiring Manager
I hope you liked the work I did. Honestly, I really enjoyed developing this application, and I am very proud how it turned out. 
I am looking forwarding to meeting you! 

Have a nice day! 

## Author
* [Jaime Dantas](https://jaimedantas.com/) -  _Initial work, development, test, documentation_
