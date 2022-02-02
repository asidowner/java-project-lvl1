install: # установить зависимости
	./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain

build:
	./gradlew clean build