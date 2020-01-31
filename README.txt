——- LOG 31/01/2020 HAUPE Isuru & Christophe DOS SANTOS NETO ———
Environnement : macOs
Version de Java : 12
Version de ANTLR : 4.8
Avancement : (à partir des nouveaux tests sur moodle)
	- TestGreen : 27/27
	- TestGreenError : 7/7
	- TestGreenPlus : 4/4
	- TestGreenType : 3/3
	- TestBlue : 4/8
	- TestRed : 4/10

- La piste verte est fonctionnelle
- Utilisation du flag gcc -pedantic-errors pour les tests car gcc -Werror -Weverything est trop restrictif
- Implémentation de la gestion des erreurs avec la création des classes : 
    - ErrorListener
    - ErrorFlag
- Temps passé sur le projet : ~20h
- Feedback : 
    - Projet enrichissant qui apprend beaucoup mais on passe beaucoup de temps à se creuser la tête
    - Le TP permet de comprendre des notions qui n’ont pas forcément été totalement appréhendées en cours