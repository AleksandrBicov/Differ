### Tests and linter status:
[![Actions Status](https://github.com/AleksandrBicov/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AleksandrBicov/java-project-71/actions)
<a href="https://codeclimate.com/github/AleksandrBicov/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/5c3977ab6603e11f0a5e/test_coverage" /></a>
<a href="https://codeclimate.com/github/AleksandrBicov/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/5c3977ab6603e11f0a5e/maintainability" /></a>
![example workflow](https://github.com/AleksandrBicov/java-project-71/actions/workflows/main.yml/badge.svg)

# Differ
Differ - это утилита командной строки, которая сравнивает два файла конфигурации и показывает различия между ними.

## Использование

Для использования утилиты необходимо выполнить следующие команды:

* ./build/install/app/bin/app filepath1.json filepath2.json
* ./build/install/app/bin/app filepath1.yml filepath2.yml
* ./build/install/app/bin/app -f plain filepath1.json filepath2.json
* ./build/install/app/bin/app -f json filepath1.json filepath2.json

### где:

*filepath1* - путь к первому файлу конфигурации.

*filepath2* - путь ко второму файлу конфигурации.

### Опции
* -f, --format * - формат вывода различий. По умолчанию используется stylish.

## Форматы вывода
*stylish* - вывод в виде стилизованной таблицы.

*plain* - вывод в виде простого списка различий.

*json* - вывод в формате JSON.

## Asciinema с примерами использования программы
[![asciicast](https://asciinema.org/a/XS0dfL2A3bVvLDStcaZ4yK9JW.svg)](https://asciinema.org/a/XS0dfL2A3bVvLDStcaZ4yK9JW)