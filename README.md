docker-compose up --build 

docker is running on host 172.17.0.1 so instead of localhost it needs this host 
todo: fix this, make it work with localhost 
docker host ip was found using
````docker run --rm -it alpine ip route````