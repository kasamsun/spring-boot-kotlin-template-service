
# Run
gradlew bootRun

# Build Jar
gradlew clean build

# Run Jar
java -jar [jar file]

# Build Image 
gradlew bootBuildImage

# Build Image by Dockerfile
docker build -t "member-service:0.0.1" .

# Run Image
docker run -it -p8091:8091 member-service:0.0.1