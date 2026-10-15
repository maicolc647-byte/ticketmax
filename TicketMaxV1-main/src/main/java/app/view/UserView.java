package app.view;

import app.domain.User;
import app.domain.enums.SelectPreferencesEnum;
import app.service.helpers.SetUserState;
import app.service.inputports.UserService;
import app.service.validators.DataTypeValidator;

public class UserView {


    private final UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }

    public void createUser() {


        int id = DataTypeValidator.validateInt("INgrese el id del usuario: ");
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        System.out.println("Ingrese la contraseña del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        System.out.println("Ingrese el estado del usuario: ");
        String state = SetUserState.getUserState();
        System.out.println();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        System.out.println("Ingrese las preferencias del usuario: ");
        String preferences = setUserPreferences();

        userService.create(id, name , lastName , email , phone , password , state, city, preferences);

    }


    public void selectById(int id) {
        // Metodo agregado para mostrar usuario por id
        User user = userService.selectById(id);

        if (user == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        printUser(user);
    }


    public void selectUsers(){

        userService.selectUsers();

    }


    public void update() {
        // Metodo agregado para actualizar usuario desde consola
        int id = DataTypeValidator.validateInt("Ingrese el id del usuario a actualizar: ");
        String name = DataTypeValidator.validateString("Ingrese el nuevo nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el nuevo apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el nuevo correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el nuevo telefono del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la nueva contrasena del usuario: ");
        String state = SetUserState.getUserState();
        String city = DataTypeValidator.validateString("Ingrese la nueva ciudad del usuario: ");
        String preferences = setUserPreferences();

        User user = userService.update(id, name, lastName, email, phone, password, state, city, preferences);

        if (user == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.println("Usuario actualizado correctamente");
        printUser(user);
    }

    public void deleteUser(int id) {
        // Metodo agregado para eliminar usuario desde consola
        User user = userService.selectById(id);

        if (user == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        userService.deleteUser(id);
        System.out.println("Usuario eliminado correctamente");
    }


    // métodos Helper




    public String setUserPreferences(){


        int option = DataTypeValidator.validateInt("Seleccione 1. VIP 2. General 3. Preferencial");
        String preferences = "";

        switch (option){

            case 1:
                preferences = SelectPreferencesEnum.VIP.getPreference();
                break;
            case 2:
                preferences = SelectPreferencesEnum.GENERAL.getPreference();
                break;
            case 3:
                preferences = SelectPreferencesEnum.PREFERENCIAL.getPreference();
                break;
            default:
                System.out.println("Opción no valida");

        }
        return preferences;
    }

    private void printUser(User user) {
        System.out.println("Id: " + user.getId());
        System.out.println("Nombre: " + user.getName());
        System.out.println("Apellido: " + user.getLastName());
        System.out.println("Correo: " + user.getEmail());
        System.out.println("Telefono: " + user.getPhone());
        System.out.println("Contrasena: " + user.getPassword());
        System.out.println("Estado: " + user.isState());
        System.out.println("Ciudad: " + user.getCity());
        System.out.println("Preferencias: " + user.getPreferences());
    }








}
