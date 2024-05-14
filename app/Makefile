build:
	./gradlew clean install build
install:
	./gradlew clean install
buildJson:
	./build/install/app/bin/app filepath1.json filepath2.json
buildYml:
	./build/install/app/bin/app filepath1.yml filepath2.yml
buildPlain:
	./build/install/app/bin/app -f plain filepath1.json filepath2.json
buildJ:
	./build/install/app/bin/app -f json filepath1.json filepath2.json
clean:
	./gradlew clean
lint:
	./gradlew checkstyleMain
report:
	./gradlew jacocoTestReport
.PHONY: build