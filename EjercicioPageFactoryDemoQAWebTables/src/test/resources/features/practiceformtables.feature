Feature: Llenar web Table en la pagina demoQA
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de Web Tables
  para poder ingresar la informacion del personal

  Scenario Outline: Registro exitoso de web table
    Given se encuentra en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada correctamente

    Examples:
      | firstName  | lastName   | age   | email                   | salary | department   |
      | "Sofronio" | "Ramirez"  | "14"  | "correofalso@gmail.com" | "1"    | "Campesino"  |
      | "Filomena" | "Ramirez"  | "30"  | "correofalso@gmail.com" | "2"    | "Camellador" |
      | "Siriaco"  | "Ramirez"  | "32"  | "correofalso@gmail.com" | "3"    | "Rebuscador" |
      | "Amparo"  | "Grisales"  | "90"  | "correofalso@gmail.com" | "3"    | "Actriz" |
