Feature: Llenar la tabla
  yo como administrador de la pagina Web demoqa
  quiero dirigirme a la seccion de elementos web
  para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el admnistrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, email <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada

    Examples:
    |firstName   | lastName   | age  | email              | salary     | department   |
    |"Jessica"   |"Lopez"     |"30"   |"jessica@gmail.com" |"10000000"  |"Quindio"     |
    |"Carlos"    |"Sanchez"   |"35"   |"carlos@gmail.com"  |"9000000"   |"Risaralda"   |
    |"Daniela"   |"Ramirez"   |"28"  |"dani@gmail.com"    |"15000000"  |"Caldas"      |



