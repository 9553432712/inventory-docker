FROM openjdk:8
ADD target/inventorymngt.jar inventorymngt.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inventorymngt.jar"]