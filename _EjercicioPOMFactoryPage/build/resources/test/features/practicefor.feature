Feature: completar informacion de la tabla
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de elementos web
  para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada

    Examples:
      | firstName  | lastName   | age  | email                 | salary      | department |
      | "Antonio"  | "Ospina"   | "22" | "paola@gmail.com"     | "5787600"   | "QA"       |
      | "Maria"    | "Martinez" | "40" | "emilia@gmail.com"    | "368776000" | "QA"       |
      | "Angelica" | "Mendez"   | "30" | "Mendoza@gmail.com"   | "25000"     | "QA"       |
      | "Domitila" | "Mendez"   | "38" | "domitilaa@gmail.com" | "25670"     | "QA"       |
      | "Nevardo"  | "Ospina"   | "35" | "perez@gmail.com"     | "888880"    | "QA"       |



