Feature: Llenar tabla de usuarios
  yo como usuario de la página demoQA
  quiero dirigirme a la sección de web tables
  para poder ingresar estudiantes a una tabla

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de webTables
    And completa la informacion el primer nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar la tabla con la informacion ingresada

    Examples:
     | firstName | lastName | age | email | salary | department|
     | "Ivan"    | "Ruiz"   | "22"  | "widap57274@huvacliq.com" | "3200000" | "Student" |
     | "Gerardo" | "Bernal" | "33"  | "momeli3038@asoflex.com"  | "3300000" | "Student" |
     | "James"   | "Muñoz"  | "44"  | "damir29305@etondy.com"   | "3400000" | "Student" |
