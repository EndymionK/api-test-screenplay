# language: es
Característica: Pruebas de API REST
  Como usuario del servicio
  Quiero poder consumir los endpoints del API
  Para verificar su correcto funcionamiento

  Escenario: Consultar usuarios exitosamente
    Dado que me encuentro conectado al servicio
    Cuando consulto la información de usuarios
    Entonces debería obtener un código de respuesta 200
    Y la respuesta debería contener datos de usuarios