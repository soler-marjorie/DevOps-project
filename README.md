docker build . -t nirahtech/devops-demo:1

docker run -dit -p 3000:8080 --name devops -e LOGGER_LEVEL=CRITCAL  nirahtech/devops-demo:1^C


docker run --rm -v "./:/usr/src" sonarsource/sonar-scanner-cli