# Используем минимальный образ с JDK 21
FROM openjdk:21-jdk-slim

# Указываем метаданные для образа
LABEL authors="edemw"

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем файл JAR из директории target в контейнер
COPY target/bookservice-0.0.1-SNAPSHOT.jar /app/bookservice.jar

# Открываем порт 8080 для приложения
EXPOSE 8080

# Устанавливаем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/bookservice.jar"]