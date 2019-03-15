# Event-Sourcing

## Zeit

Wir selbst haben:
- relative Bewegungsfreiheit in den drei Dimensionen
- keinerlei Bewegungsfreiheit in der Dimension Zeit

Wir schreiben Software meistens auch ohne "Bewegungsfreiheit" in der Zeit-Dimension. Daraus ergeben sich folgende Probleme:

1. Informationsverlust (z.B. nach einem UPDATE auf meiner Datenbasis)
2. Nachvollziehbarkeit oft schwierig (Wie kam man in den aktuellen Zustand?)
3. Erneutes Ausführen der User-Interaktionen ist meist unmöglich.
4. Skalierbarkeit oft schwierig (eine Datenbasis als Quelle der Wahrheit skaliert nicht gut)

### Behauptung: Event-Sourcing gibt Bewegungsfreiheit in der Zeit-Dimension und löst so diese vier Probleme - und man kann Ende-zu-Ende-Tests als Bonus geschenkt bekommen

Die Punkte 1 bis 3 und den Bonus-Teil möchte ich in an einem praktischen Beispiel demonstrieren.

## Die Theorie

https://de.wikipedia.org/wiki/Event_Sourcing#/media/File:CQRS.svg

https://medium.com/@hugo.oliveira.rocha/what-they-dont-tell-you-about-event-sourcing-6afc23c69e9a
https://hackernoon.com/1-year-of-event-sourcing-and-cqrs-fb9033ccd1c6

## Intention und Warnung vorweg

*Könnte man mit Hilfe von Event-Sourcing Integrationstests "geschenkt" bekommen?*

Ich möchte Euch gerne für Event-Sroucing begeistern und Euch die Vorteile verdeutlichen.

Kleine Warnung bzw. Aufruf zum Verlassen den Komfortzone:
- Software-Entwicklung mal etwas anders
- Code ist in Java und JavaScript
- Verwendung einer DSL und eines Code Generators

## Welche Probleme löst es?

**Zeit**

- Kein Informationsverlust mehr
- Nachvollziehbarkeit
- Wiederausführbarkeit
- Optimierung der Lese- und Schreibzugriffe

Wie funktioniert es?

Theorie

Meine eigene Umsetzung

Hürden bzw. Herausforderungen und Lösungsmöglichkeiten

- Aufwändigere Implementierung
    Lösung: Code Generator
- Personalisierte Daten im Event-Store
    Lösung: Verschlüsselung

Beispiele

Nochmal zum Thema DSL/Code-Generator

Einladung zu Workshop



