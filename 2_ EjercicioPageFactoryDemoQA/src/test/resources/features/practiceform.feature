Feature: Llenar Tabla
  yo como administrador de la Web demoQA
  quiero dirigirme a la sección de elementos
  para poder ingresar la información de personas contratadas


  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo <email>, salario <salary>, departamento <department>
    Then entonces debe observar una ventana con la informacion ingresada de nombre <firstName>, apellido <lastName>, edad <age>

    Examples:
      | firstName | lastName  | age  | email                     | salary    | department |
      | "Jesus"   | "Molina"  | "27" | "jesusmiguel@gmail.com"   | "5000000" | "sofkau"   |
      | "Miguel"  | "Mendoza" | "20" | "miguelmendoza@gmail.com" | "4000000" | "sofkau"   |
      | "Mafer"   | "Vera"    | "23" | "mafervera@gmail.com"     | "6000000" | "sofkau"   |