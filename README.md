## API DE PRACTICA DE SPRINGBOOT

Rutas para acceder a la api:

1. *Metodo GET*
    - **/users/getusers** | Retorna todos los usuarios de la base de datos
    - **/getuserbyid/{id}** | Retorna el usuario por su id
    - **/getusersbyname/{name}** | Retorna los usuarios por su nombre o coinciendencia
2. *Metodo POST*
    - **/saveuserjson** | Guarda un usuario nuevo mediante el formanto JSON
    - **/saveuserurl** | Guarda un usuario nuevo mediante la URL
3. *Metodo PUT*
    - **/updateuser/{id}** | Actualiza el usuario por su id, pero debe recibir los valores a actualizar en formato JSON
4. *Metodo DELETE*
    - **/deleteuserbyid/{id}** | Elimina el usuario por su id
