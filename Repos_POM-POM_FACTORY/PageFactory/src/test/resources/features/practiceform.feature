Feature: Web Tables Formulario
  Como administrador
  Quiero ingresar datos de usuario en la tabla de registro
  Para verificar la informacion ingresada

  Scenario Outline: Agregar registros a la tabla de Web Tables
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And doy click al boton Add de la tabla de registro
    And ingreso datos de usuario en la tabla de registro nombre <firstName>, apellido <lastName>, edad <age>, correo <email>, salario <salary>, departamento <department>
    And doy click al boton Submit de la tabla de registro
    Then debe observar una tabla con la informacion ingresada

    Examples:
      | firstName | lastName | age  | email             | salary | department   |
      | "James"   | "Borja"  | "29" | "james@gmail.com" | "200"  | "QA"         |
      | "Juan"    | "Pineda" | "60" | "juan@gmail.com"  | "3000" | "Gerencia"   |
      | "Arley"   | "Munoz"  | "29" | "arley@gmail.com" | "100"  | "Desarrollo" |






