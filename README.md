## API DE PRACTICA DE SPRINGBOOT

Rutas para acceder a la api:

1. *Metodo GET*
    - **/users/getusers** | Retorna todos los usuarios de la base de datos
    - **/users/getuserbyid/{id}** | Retorna el usuario por su id
    - **/users/getusersbyname/{name}** | Retorna los usuarios por su nombre o coinciendencia
2. *Metodo POST*
    - **/users/saveuserjson** | Guarda un usuario nuevo mediante el formanto JSON
    - **/users/saveuserurl** | Guarda un usuario nuevo mediante la URL
3. *Metodo PUT*
    - **/users/updateuser/{id}** | Actualiza el usuario por su id, pero debe recibir los valores a actualizar en formato JSON
4. *Metodo DELETE*
    - **/users/deleteuserbyid/{id}** | Elimina el usuario por su id
