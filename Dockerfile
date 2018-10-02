FROM openjdk:8
ADD target/inventorymngt.jar inventorymngt.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "inventorymngt.jar"]