# Spring-Exception-Handling-task
- Lege einen Record ErrorMessage an, um eine Fehlernachricht an den Client zu schicken.
- Implementiere für die Endpunkte getCarBrand und getAnimalSpecies jeweils einen lokalen ExceptionHandler.
- Erstelle einen GlobalExceptionHandler der für die Endpunkte getAllAnimals und getAllCars die Exception einheitlich handelt.
- Implementiere Integration-Test die prüfen ob die Exception korrekt behandelt werden.

### Bonus
- Erstelle einen globalen Exception Handler um alle Standart-Exception von Java (z.B. NullPointerException) abzufangen.
- Füge zu deinem ErrorMessage Objekt noch den Zeitpunkt des Fehler mit an.

### Bonus Aufgabe Product Repository (anderes Repo)
- Erstelle in deinem Product Repository einen ExceptionHandler, um für den Fall das ein Client ein Produkt anfragt das es nicht gibt, dem Client eine passende Fehlermeldung zurück zu geben.
- Erstelle eine eigene Exception Klasse für den Fall das es das geforderte Produkt nicht gibt. Überlege dir einen passenden Klassen-Namen.
- Passe dein Exception Handling dem entsprechend an.
