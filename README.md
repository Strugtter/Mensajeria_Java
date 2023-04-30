#  PROYECTO INTEGRADOR - MENSAJERIA EXPRESS

La API es útil para una empresa de mensajería, ya que les permite gestionar sus clientes, empleados y envíos. El sistema permite registrar, consultar y eliminar datos de una base de datos que almacena toda la información relevante del negocio.

Se uso Spring boot y las diferentes librerias tales como:

<ol>
  <li>Spring security</li>
  <li>Spring data</li>
  <li>JUnit</li>
	<li>Rest-api</li>
  <li>Swagger</li>
	<li>Github</li>
</ol>


La integración (CI/CD) se implementó con Github Actions y el despliegue del servicio se hizo por medio de Railway, y
se encuentra en el siguiente dominio: 

### [https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#](https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#)
user: camilo
Password: botina

# Endpoints:

### POST https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-customer/addCustomerUsingPOST  (crear un cliente.)
  El body de la solicitud recibe los siguientes parametros: 
  ```java {.highlight .highlight-source-java .bg-black}
    {
      "apellido": "string",
      "cedula": 0,
      "celular": 0,
      "ciudad": "string",
      "correoElectronico": "string",
      "direccionResidencia": "string",
      "nombre": "string"
    }
```
  Ejemplo de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
      "apellido": "Botina",
      "cedula": 1268433,
      "celular": 3134562345,
      "ciudad": "Popayan",
      "correoElectronico": "camilobotinatrujilo@gmail.com",
      "direccionResidencia": "carrera 13A # 1-46",
      "nombre": "Camilo"
    }
```

### DELETE https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-customer/deleteCustomerUsingDELETE  (Eliminar cliente por su cedula.)
  La petición recibe el numero de cedula de un cliente y retorna un String confirmando que la operación
  ocurrió de manera satisfactoria siempre que es estado de la petición sea 200.
```java {.highlight .highlight-source-java .bg-black}
    Se elimino correctamente
```

### GET https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-customer/getCustomerCedulaUsingGET  (Obtener cliente por su cedula.)
  La petición recibe el numero de cedula de un cliente y retorna la información asociada a este cliente.
  
  Ejemplo de la respuesta:
  ```java {.highlight .highlight-source-java .bg-black}
     {
      "apellido": "Botina",
      "cedula": 1268433,
      "celular": 3134562345,
      "ciudad": "Popayan",
      "correoElectronico": "camilobotinatrujilo@gmail.com",
      "direccionResidencia": "carrera 13A # 1-46",
      "nombre": "Camilo"
    }
  ```

### POST https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-employees/addEmployeeUsingPOST (Registrar empleado.)

  El body de la solicitud recibe los siguientes parametros:
  NOTA: El tipo de empleado solo puede ser COORDINADOR, REPARTIDOR O CONDUCTOR
    
  ```java {.highlight .highlight-source-java .bg-black}
	    {
	    "cedula": Integer,
	    "nombre": String,
	    "apellido": String,
	    "celular": String,
	    "correo": String,
	    "direccionResidencial": String,
	    "ciudad": String,
	    "antiguedad": 0,
	    "rh": "string",
	    "tipoEmpleado": "string"
	    }
  ```
  
  Ejemplo de la petición:
  
  ```java {.highlight .highlight-source-java .bg-black}
{
  "antiguedadEmpresa": 2,
  "apellido": "Perez",
  "cedula": 34521,
  "celular": 68795,
  "ciudad": "Popayan",
  "correoElectronico": "repartidor1",
  "direccionResidencia": "carrera 45 Street",
  "nombre": "Ricardo",
  "rh": "0+",
  "tipoEmpleado": "COORDINADOR"
}
```

### DELETE https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-employees/deleteEmployeeUsingDELETE (Eliminar empleado por su cedula.)
  La petición recibe el numero de cedula de un empleado y retorna un String confirmando que la operación
  ocurrió de manera satisfactoria siempre que el estado de la petición sea 200.
    
  ```java {.highlight .highlight-source-java .bg-black}
      Se elimino correctamente
  ```

### GET https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-employees/getEmployeeCedulaUsingGET  (Obtener empleado por su cedula.)
  La petición recibe el numero de cedula de un empleado y retorna la información asociada a este empleado.
    
  Ejemplo de la respuesta:
 ```java {.highlight .highlight-source-java .bg-black}
    {
  "antiguedadEmpresa": 2,
  "apellido": "Perez",
  "cedula": 34521,
  "celular": 68795,
  "ciudad": "Popayan",
  "correoElectronico": "repartidor1",
  "direccionResidencia": "carrera 45 Street",
  "nombre": "Ricardo",
  "rh": "0+",
  "tipoEmpleado": "COORDINADOR"
    }
```

### POST https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-dispatch/addDispatchUsingPOST  (Registrar envio.)

  El body de la solicitud recibe los siguientes parametros:
    
  ```java {.highlight .highlight-source-java .bg-black}
{
  "addressDestination": "string",
  "cedulaCliente": 0,
  "cityDestination": "string",
  "cityOrigin": "string",
  "deliveryTime": "2023-04-30",
  "insuredvalue": 0,
  "nameRecive": "string",
  "numberGuia": "string",
  "phoneRecive": 0,
  "priceDispatch": 0,
  "stateDispatch": "string",
  "typePackage": "string",
  "weight": 0
}
  ```
  Y responde con el numero guia y el estado del envio:
  ```java {.highlight .highlight-source-java .bg-black}
      {
      numeroGuia=Integer
      estadoEnvio=String
      }
 ``` 
  Ejemplo de la petición:
  
  ```java {.highlight .highlight-source-java .bg-black}

{
"cedulaCliente": 12345,
"cityOrigin":"Popayan",
"cityDestination":"Bogotaa",
"addressDestination": "calle 46 # 69-90a",
"nameRecive" : "Juan Manuel",
"phoneRecive" : 304630386,
"insuredvalue" : 18000,
"weight" : 2
}
```

```java {.highlight .highlight-source-java .bg-black}
      {
      numeroGuia=ASD34512E
      estadoEnvio='RECIBIDO'
      }
 ``` 


### GET https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-dispatch/getFilterDispatchUsingGET  (Obtener un envio por su numero guia.)
  La peticion recibe el numero guia y devuelve toda la informacion relacionada al envio
  
  Ejemplo respuesta: 
  
  ```java {.highlight .highlight-source-java .bg-black}
      {
		"cedulaCliente": 123,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "RECIBIDO"
	}
 ``` 


### PUT https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-dispatch/updateDispatchUsingPUT  (Actualizar el estado de un envio.)

  Recibe el numero guia, el estado al que se quiere actualizar el envio y la cedula del empleado 
  para hacer las validaciones y proceder con la actualización del envio.
  
  Los estados a los que se puede actualizar son: EN RUTA y ENTREGADO.  
  
  El empleado debe ser REPARTIRDOR o COORDINADOR para poder realizar la operación. 
  
  
  Ejemplo de la petición:
  ```java {.highlight -highlight-source-java .bg-black}
{
"numeroGuia": "SJ14I46BOX",
"estadoEnvio":"EN RUTA",
"cedulaEmpleado": 12345
}
  ```
  
  Y la respuesta: 
  
  ```java {.highlight .highlight-source-java .bg-black}
      {
       numeroGuia=SJ14I46BOX
       ultimoEstado='EN RUTA'
      }
 ``` 

### GET https://mensajeriajava-production.up.railway.app/swagger-ui/index.html#/controller-dispatch/getFilterDispatchUsingGET  (Filtrar los envios por su estado de envio.)

 
  El filtro se hace atraves de la ULR de la siguiente forma:
  
  Ejemplo de la petición:
  ```java {.highlight -highlight-source-java .bg-black}
      localhost:8080/api/v1/dispatch?stateEnvio=EN RUTA&cedula=12345
  ```
  Ejemplo de respuesta:
  
  ```java {.highlight .highlight-source-java .bg-black}
     [
	{
		"cedulaCliente": 12345,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "EN RUTA"
	},
	{
		"cedulaCliente": 123,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "EN RUTA"
	}
]
 ``` 
 
 # Diagrama UML
 
![image](https://user-images.githubusercontent.com/94997816/232940825-fd70ff82-06a7-4ae4-bbbb-d84e2372ca8a.png)

# Diagrama Entidad-Relación

![image](https://user-images.githubusercontent.com/94997816/232358215-f7fe1ee5-14bf-4204-9057-92b4ded816f6.png)
