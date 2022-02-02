install: # установить зависимости
		./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates
