Feature: Llenar formulario de registro
  Yo como usuario del banco paraBank
  quiero dirigirme a laseccion de registro
  para poder ingresar como cliente

  Scenario Outline: Registro exitoso
    Given el usuario esta en la pagina principal
    When navega hasta la opcion de registro
    And completa los campos con la informacion de usuario en <firstName>, <lastName>, <address>, <city>, <state>, <zipCode>, <phone>, <ssn>, <userName>, <password>, <repeatedPassword>
    Then debe observar un mensaj que su cuenta fue creada
    Examples:
      | firstName | lastName  | address | city     | state   | zipCode   | phone   | ssn   | userName        | password  | repeatedPassword |
      | "efrain"  |"solorzano"| "cr40"  |"medellin"|"uiyuiy" |"06547"    |"767867" |"6786"  |"efra1234"      |"12345"    |"12345"          |
      |"laura"    |"navarro"  | "cr50"  |"itagui"  |"uytuy"  |"787878"   |"45564"  |"889"  |"laul1234"       |"123456"   |"123456"          |
      |"andrea"   |"lopez"    | "cl40"  |"bello"   |"yuiyiu" |"67687"    |"67867"  |"7677" |"andrea12345"    |"12345678" |"12345678"        |