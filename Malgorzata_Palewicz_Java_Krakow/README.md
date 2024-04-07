# README BasketSplitter

## Spis treści
* [Opis i założenia projektu](#opis)
* [Struktura projektu](#struktura-projektu)
* [Testy](#testy)
* [Wymagania systemowe](#wymagania-systemowe)
* [Kontakt](#kontakt)

## Opis
Biblioteka BasketSplitter została stworzona w celu umożliwienia optymalnego podziału koszyka 
zakupowego klienta na grupy dostaw. Jej działanie opiera się na wcześniej zdefiniowanej konfiguracji
sposobów dostawy produktów oraz listy produktów w koszyku, które są przechowywane w plikach w 
formacie JSON. Głównym celem biblioteki jest minimalizacja liczby dostaw oraz maksymalizacja ilości
produktów w największych grupach dostaw.

## Struktura projektu
Projekt składa sie z następujących elementów:
1. Klasa BasketSplitter: <br> 
   Główna klasa biblioteki, odpowiedzialna za podział koszyka zakupowego na grupy dostaw.
   Zawiera ona pięć funkcji, w tym funkcje odwracającą mapę tzn. zamieniajacą wartości z kluczami.
   Niestety przez to że wartości w mapie nie są unikalne to musiałam napisać funkcję tworzącą nową mapę poprzez pętle, aby nie wystąpił żaden błąd.
   <br>
   <br>
2. Klasa Json: <br>
   Klasa pomocnicza do obsługi operacji związanych z formatem JSON, takich jak parsowanie plików konfiguracyjncyh.
   <br>
   <br>
3. Klasa Main: <br>
   Jest punktem wejścia do aplikacji. Odpowiada za wczytywanie plików konfiguracyjnych oraz koszyka. Wywołuje metody klasy 'BasketSplitter'.
   <br>
   <br>
4. Pliki konfiguracyjne:
   <br>
   Projekt wykorzystuje pliki kofigurcyjne w formacie JSON do przechowywania danych o produktach i dostawach. 

## Testy
W moim projekcie przeprowadziłam testy mające na celu sprawdzenie funkcjonalności oraz logicznej poprawności kodu. Skoncentrowałam się głównie na testowaniu warunków określonych w zadaniu. W szczególności sprawdziłam, czy koszyk może zawierać maksymalnie 100 produktów, katalog nie przekracza 1000 produktów oraz czy istnieje maksymalnie 10 różnych sposobów dostawy.
<br>
<br>
Do przetestowania tych warunków stworzyłam trzy pliki testowe. Pierwszy z nich zawierał poprawne dane, które spełniały wszystkie założenia projektu. Drugi plik zawierał dane z zbyt dużą ilością produktów, aby sprawdzić, czy mój kod prawidłowo obsługuje to ograniczenie. Natomiast trzeci plik zawierał więcej niż 10 sposobów dostawy, co pozwoliło mi zweryfikować, czy mój kod prawidłowo identyfikuje i ogranicza ilość dostępnych opcji dostawy.

## Wymagania systemowe
Wykorzystana została Java 17 wraz z obsługą Maven do budowania projektu. 

## Kontakt
- [GitHub: https://github.com/malgorzatapalewicz](https://github.com/malgorzatapalewicz)

- [Email: malgorzata.maria.palewicz@gmail.com](mailto:malgorzata.maria.palewicz@gmail.com)