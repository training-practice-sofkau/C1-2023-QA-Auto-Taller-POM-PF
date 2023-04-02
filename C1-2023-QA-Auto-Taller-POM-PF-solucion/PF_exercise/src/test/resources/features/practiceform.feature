Feature: Trabajar  como socio de Parasoft
  yo como cliente de la web Parasoft
  quiero dirigirme a la seccion de partners
  para poder registrarme y trabajar con Parasoft

  Scenario Outline: Registro de perfil exitoso
    Given el cliente esta en la pagina principal
    When navega hasta la opcion de partners en la opcion Become a Partners
    And completa con email <email>, nombre <firstName>, apellido <lastName>, compania <company>, celular <phone>, pais <country>, comentarios <comments>
    Then debe observar un mensaje en pantalla de envio exitoso
    Examples:
      | email                  | firstName | lastName | company   | phone        | country       | comments               |
      | "lupo@gmail.com"       | "lupo"    | "mejia"  | "sofka"   | "3124569985" | "unit states" | "llamame por favor"    |
      | "luisamaria@gmail.com" | "luisa"   | "mora"   | "avantel" | "3124785596" | "australia"   | "llamame ya"           |
      | "cami@gmail.com"       | "camila"  | "marin"  | "claro"   | "3115002030" | "argentina"   | "llamame con urgencia" |