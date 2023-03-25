Feature: Llenar formulario
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de formualario
  para poder ingresar estudiantes a una lista

  Scenario: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de formularios
    And complementa los campos con la informacion del estudiante
    Then debe observar una ventana con la informacion ingresada