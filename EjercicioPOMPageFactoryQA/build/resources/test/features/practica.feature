Feature: completar tabla
  yo como adminstrador de la web demoQA
  quiero dirigirme a la seccion de elementos web
  para poder ingresar informacion de personas contratadas


  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada

    Examples:
      | firstName | lastName    | age  | email            | salary    | department |
      | "Andres"  | "Yepes"     | "30" | "ayps@mail.com"  | "2000000" | "QA"       |
      | "Andrea"  | "Gutierrez" | "25" | "angut@mail.com" | "3000000" | "QA"       |
      | "Jorge"   | "Gonzalez"  | "32" | "jgoz@mail.com"  | "2500000" | "QA"       |