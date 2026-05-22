# Choix de l'image de base
FROM maven:3.9-eclipse-temurin-21-alpine

# Exécution d'une commande
RUN mkdir /app

# Changement de répertoire
WORKDIR /app

# Copie du projet
COPY ./ ./

# Exécution d'une commande
RUN mvn clean package -DskipTests

# Dossiers partagés
VOLUME /tmp

# Redirection de port
EXPOSE 8080

# Variable d'environnement
ENV LOGGER_LEVEL=INFO 

# Démarrage du processus principal
CMD ["java", "-jar", "target/devops-demo-0.0.1-SNAPSHOT.jar"]
