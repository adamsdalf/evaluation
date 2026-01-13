# 🏦 Microservice Evaluacion

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0+-green?style=for-the-badge&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=for-the-badge&logo=apache-maven)
![License](https://img.shields.io/badge/License-Private-red?style=for-the-badge)

</div>

##### 🚀 **cURL Login Usuario Administrador **
```

curl --location 'http://localhost:8080/truper/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin",
    "password": "admin123"
}'

```

---


##### 🚀 **cURL Nueva Orden**
```

curl --location 'http://localhost:8080/truper/api/v1/ordenes' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzY4Mjc0Mzg2LCJleHAiOjE3NjgyNzc5ODZ9.n5PLL0y41ApO0-ql3D7U5juJDxt_AfeLM7ZfSfxRces' \
--header 'Content-Type: application/json' \
--data '{
    "sucursalId" : 1,    
    "total": 123.21,
    "productos": 
    [{
        "codigo" : "18156",
        "descripcion": "Esmeriladora angular",
        "precio": 625

    },
    {
        "codigo" : "17193",
        "descripcion": "Pala redonda",
        "precio": 100.50
    }
    ]
}'

```
---


##### 🚀 **cURL Consultar Orden**
```

curl --location 'http://localhost:8080/truper/api/v1/ordenes/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzY4Mjc0Mzg2LCJleHAiOjE3NjgyNzc5ODZ9.n5PLL0y41ApO0-ql3D7U5juJDxt_AfeLM7ZfSfxRces'

```
---



##### 🚀 **cURL Actualizar Precio de Producto**
```

curl --location --request PUT 'http://localhost:8080/truper/api/v1/productos/17193/precio?precio=99.99' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzY4Mjc0Mzg2LCJleHAiOjE3NjgyNzc5ODZ9.n5PLL0y41ApO0-ql3D7U5juJDxt_AfeLM7ZfSfxRces'

```
---


##### 🚀 **cURL Login Usuario**

```

curl --location 'http://localhost:8080/truper/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "user",
    "password": "user123"
}'

```
---


##### 🚀 **cURL Actualiza Password de Usuario Logeado**

```

curl --location --request PUT 'http://localhost:8080/truper/api/v1/auth/password' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzY4Mjc0Mzg2LCJleHAiOjE3NjgyNzc5ODZ9.n5PLL0y41ApO0-ql3D7U5juJDxt_AfeLM7ZfSfxRces' \
--header 'Content-Type: application/json' \
--data '{
    "actualPassword": "admin123",
    "nuevoPassword": "admin1235"
}'

```