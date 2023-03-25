Feature: LLenar formulario
  Yo como administrador de la Web DemoQa
  Quiero dirigirme a la seccion de formulario
  Para poder ingresar estudiantes a una lista

  Scenario: Registro exitoso
    Given el adminsitrador esta en la pagina principal
    When  navega hasta la opcion de formulario
    And   completa los campos con  la informacion de un estudiante
    Then  debe observar una ventana con la informacion ingresada