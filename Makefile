station:
	mvn -f weather-station quarkus:dev

map:
	mvn -f weather-map quarkus:dev

up:
	mvn -f weather-station clean package
	mvn -f weather-map clean package
	docker-compose up --build

down:
	docker-compose down -v --remove-orphans