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
      | firstName | lastName   | age  | email          | salary    | department |
      | "Luisa"   | "Mosquera" | "19" | "ml@gmail.com" | "2500000" | "QA"       |
      | "Jose"    | "Rivera"   | "25" | "jr@gmail.com" | "3500000" | "QA"       |
      | "Daniela" | "Diaz"     | "35" | "dd@gmail.com" | "4400000" | "QA"       |