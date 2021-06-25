FROM openjdk:10.0.2-jre-slim AS build

RUN apt-get update && apt-get install -y locales

# Locale
RUN sed -i -e \
  's/# ru_RU.UTF-8 UTF-8/ru_RU.UTF-8 UTF-8/' /etc/locale.gen \
   && locale-gen

ENV LANG ru_RU.UTF-8
ENV LANGUAGE ru_RU:ru
ENV LC_LANG ru_RU.UTF-8
ENV LC_ALL ru_RU.UTF-8

RUN mkdir "usr/src/myproject"

WORKDIR /usr/src/myproject

COPY . .

RUN apt install  -y  maven
RUN mvn clean install -Dmaven.test.skip=true

EXPOSE 8081

WORKDIR ./WebService

CMD ["mvn","jetty:run-war"]

