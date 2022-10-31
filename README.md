<h1 align="center">Привет, меня зовут Денис</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>

### О проекте: ###
Микросервисная архитектура получающая данные погоды с https://open-meteo.com/


### Для запуска контейнеров в докере нужно сделать следующее: ###

> 1. Создать сеть: 
```docker network create network ```

> 2. Запустить RabbitMQ: 
```docker run -d -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -h 172.18.0.2 --net=network rabbitmq:3.10-management```

> 3. Сконфигурировать Dockerfile для IoT-Sensor: 
```
FROM openjdk:11
COPY java-microservices-IoT-Sensor-0.0.1-SNAPSHOT.jar /home/user/java-microservices-IoT-Sensor-0.0.1-SNAPSHOT.jar
WORKDIR /home/user
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/home/denis/java-microservices-IoT-Sensor-0.0.1-SNAPSHOT.jar"] 
```

> 4. Собрать контейнер: 
```docker build -t iot-sensor .```

> 5. Запустить контейнер:
```docker run --rm --name iot-sensor -p 8081:8081 -h 172.18.0.3 --net=network iot-sensor --url="https://api.open-meteo.com/v1/forecast?latitude=48.2092&longitude=16.3728&current_weather=true" ```
