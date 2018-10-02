# inventory-docker

write the following to Docketfile

FROM openjdk:8

ADD target/inventorymngt.jar inventorymngt.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "inventorymngt.jar"]

------------In the terminal---------------------------

docker build -f Dockerfile -t inventoryspringboot .

docker run -p 8088:8088 inventoryspringboot 

—————pushing the images to docker---------------------------------------------

https://ropenscilabs.github.io/r-docker-tutorial/04-Dockerhub.html

docker login --username=punugupatimahesh --email=mahesh.rvrjc@gmail.com
docker images
docker tag 7c07ea91d800 punugupatimahesh/inventoryspringboot:firsttry
docker push punugupatimahesh/inventoryspringboot
