package app.ui;

import app.service.validators.DataTypeValidator;
import app.view.SeatView;
import app.view.UserView;

public class CliUserInterface {



    private final UserView userView;

    public CliUserInterface(UserView userView , SeatView seatView){
        this.userView = userView;

    }

    public void applicationInit(){

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación");


        while(init != 0){

            int option = DataTypeValidator.validateInt("1. Registro " +
                    "2. Login" +
                    "3. Salir");

            switch (option){
                case 1:
                    userView.createUser();
                    break;
                case 2:
                    System.out.println("Login");
                    userMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación");
                    init = 0;
                    break;
                default:
                    System.out.println("Seleccione una opción valida");
                    break;
            }

        }



    }


    public void userMenu(){

        // Opciones agregadas para probar updateUser, selectUserById y deleteUser
        int option = DataTypeValidator.validateInt("""
                Seleccione\s
                1. Registrar usuario\s
                2. Consultar usuario por id\s
                3. Consultar todos los usuarios\s
                4. Actualizar usuario\s
                5. Eliminar usuario""");

        switch (option){
            case 1:
                System.out.println("Registrar Usuario");
                userView.createUser();
                break;
            case 2:
                System.out.println("Consultar usuario por id");
                int id = DataTypeValidator.validateInt("Ingrese el id del usuario a consultar");
                userView.selectById(id);
                break;
            case 3:
                System.out.println("Consultar todos los usuarios");
                userView.selectUsers();
                break;
            case 4:
                System.out.println("Actualizar usuario");
                userView.update();
                break;
            case 5:
                System.out.println("Eliminar usuario");
                int deleteId = DataTypeValidator.validateInt("Ingrese el id del usuario a eliminar");
                userView.deleteUser(deleteId);
                break;
            default:
                System.out.println("Ingrese una opción valida");
        }





    }






}
