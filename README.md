# BD2 Proyecto Final

## Api para el manejo de Usuarios
Se crean 3 endpoint para hacer el manejo de los usuarios en el aplicativo.

<ul>
    <li>
        Api para realizar validación de acceso al aplicativo.
        /api/user/login
    </li>
    <li>
        Api para la creación de usuarios.
        /api/user/signup
    </li>
    <li>
        Api para la creación de funcionarios.
        /api/user/signupofficial
    </li>
</ul>

## Api para el manejo de mascotas
Se crearon endpoint que permiten la administracion de mascotas
<ul>
    <li>
        Api para la creación y modificación de los datos de las mascotas.
        /api/pet/createpet
    </li>
    <li>
        Api que lista las mascotas de determinado propietario.
        /api/pet/petlist
    </li>
</ul>

## Api para las acciones permitidas para el rol veterinario
Se crearon los endpoint que permiten las acciones de un veterinario.
<ul>
    <li>
        Api para la creación de un caso
        /api/pet/petcase
    </li>
    <li>
        Api para la creacion de una visita
        /api/vet/createvisit
    </li>
</ul>

## Collection Postman
En el archivo con nombre "CuatroPatas.postman_collection.json", es el collection que puede ser importado en postman donde se encuentran las pruebas realizadas a la API creada.
