Feature: Agregar registro a la web table
  yo como admin de la web demoQa
  quiero navegar a la seccion de webTable
  para poder agregar empleados a la tabla

  Scenario Outline: Agregar empleado exitoso
    Given el admin esta en la pagina principal
    When navega hasta la opcion webtable
    And da click en el boton add
    And completa los campos con la informacion del empleado nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar en la tabla la informacion ingresada

    Examples:
      | firstName | lastName | age  | email             | salary  | department   |
      | "Jose"    | "Nunez"  | "23" | "josen@gmail.com" | "15000" | "Gerente QA" |
      | "Fabian"  | "Puerta" | "25" | "fabi@gmail.com"  | "5000"  | "QA"         |
      | "Mario"   | "Mesa"   | "26" | "mmesa@gmail.com" | "25000" | "Dev"        |
