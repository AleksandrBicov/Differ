build:
	./gradlew clean install build
install:
	./gradlew clean install
buildj:
	./build/install/app/bin/app -f json filepath1.json filepath2.json
buildJ:
	./build/install/app/bin/app filepath1.json filepath2.json
buildp:
	./build/install/app/bin/app -f plain filepath1.json filepath2.json
buildY:
	./build/install/app/bin/app filepath1.yml filepath2.yml
clean:
	./gradlew clean
lint:
	./gradlew checkstyleMain
.PHONY: build