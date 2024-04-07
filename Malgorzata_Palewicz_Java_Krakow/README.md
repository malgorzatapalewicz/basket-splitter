# README BasketSplitter

## Spis treści
* [Opis i założenia projektu](#opis)
* [Struktura projektu](#struktura-projektu)
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


## Wymagania systemowe
Wykorzystana została Java 17 wraz z obsługą Maven do budowania projektu. 

## Kontakt
- [GitHub: https://github.com/malgorzatapalewicz](https://github.com/malgorzatapalewicz)

- [Email: malgorzata.maria.palewicz@gmail.com](mailto:malgorzata.maria.palewicz@gmail.com)