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
      | firstName | lastName  | age  | email              | salary    | department    |
      | "Juan"    | "Velez"   | "28" | "juanm@gmail.com"  | "2500000" | "Gerencial"   |
#      | "Valeria" | "Meneses" | "35" | "val@gmail.com"    | "3400000" | "Development" |
#      | "Andres"  | "Gaviria" | "22" | "andres@gmail.com" | "5200000" | "QA"          |