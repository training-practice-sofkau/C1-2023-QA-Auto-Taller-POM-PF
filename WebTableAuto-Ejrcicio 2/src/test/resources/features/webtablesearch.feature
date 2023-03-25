Feature: Buscar en la tabla
  yo como Admin
  quiero dirigirme a la seccion de webtable
  para poder buscar un empleado

  Scenario: Busqueda exitosa
    Given el admin esta en la pagina principal de demoqa
    When navega hasta la opcion webtable de demoQA
    And escriba el nombre del empleado que necesita
    Then debe observar en la tabla solo la informacion de ese empleado

