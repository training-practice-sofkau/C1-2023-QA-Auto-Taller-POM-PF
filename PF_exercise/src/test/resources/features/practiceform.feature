Feature: Llenar formulario Web Tables
  yo como administrador de DemoQA
  quiero diligenciar datos en especifico en una tabla de resgitro
  para poder validar y verificar el correcto funcionamiento de la herramienta

  Scenario Outline: Registros exitosos en la tabla
    Given el admin esta en la pagina principal de DemoQA
    When navega hasta la opcion de Web Tables
    And da click en el boton de agregar un nuevo registro
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo <correo>, salario <salary>, departamento <department>
    And envia la informacion
    Then debe observar una tabla de la informacion ingresada correctamente
    Examples:
      | firstName | lastName | age  | correo                 | salary     | department          |
      | "lupo"    | "mejia"  | "49" | "lupo@gmail.com"       | "20000000" | "financiero"        |
      | "luisa"   | "mora"   | "15" | "luisamaria@gmail.com" | "900000"   | "servicioAlCliente" |
      | "camila"  | "marin"  | "20" | "cami@gmail.com"       | "2500000"  | "DiseñoGrafico"     |