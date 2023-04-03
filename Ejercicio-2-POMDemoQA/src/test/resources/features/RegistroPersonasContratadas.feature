Feature: Llenar Formulario

  Como administrador de la Web demoQA
  Quiero dirigirme a la sección de elementos web
  Para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, correo electronico <email> , edad <age>, salario <salary>, departamento <department>
    Then debe observar una fila con la informacion ingresada en la tabla.
    Examples:
      | firstName    | lastName   | email                 | age  | salary | department   |
      | "Bryan"      | "Polo"     | "david2223@mail.com"  | "25" | "5000" | "QA"         |
      | "Angie"      | "Berrocal" | "angie@mail.com"      | "22" | "4500" | "Desarrollo" |
      | "Maria Jose" | "Cohen "   | "mariajose@gmail.com" | "20" | "3000" | "Marketing"  |
