Feature: completar tabla
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de elementos web
  para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada

    Examples:
      | firstName | lastName    | age  | email                | salary    | department          |
      | "Ash"     | "Ketchum"   | "14" | "pikachu@gmail.com"  | "2000000" | "Entrenador"        |
      | "Gustavo" | "Petro"     | "30" | "petro@gmail.com"    | "3000000" | "Guerrillero"       |
      | "Alvaro"  | "Uribe"     | "32" | "uribe@gmail.com"    | "5000000" | "Paramilitar"       |
