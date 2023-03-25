Feature: completar tabla
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de elementos web
  para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada <firstName> <age> <email>

    Examples:
      | firstName | lastName   | age  | email              | salary    | department |
      | "Gretty"  | "Mosquera" | "29" | "gretym@gmail.com" | "2000000" | "QA"       |
      | "Adriana" | "Taborda"  | "30" | "adri@gmail.com"   | "3000000" | "QA"       |
      | "Mariana" | "Monsalve" | "25" | "mar@gmail.com"    | "5000000" | "QA"       |