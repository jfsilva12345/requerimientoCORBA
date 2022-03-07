package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import org.omg.CORBA.*;
import s_gestion_usuarios.sop_corba.*;
import cliente.Utilidades.*;
import java.rmi.RemoteException;


public class ClienteDeObjetos {

    static GestionPersonalIntOperations refPersonal;

    static GestionUsuariosIntOperations refUsuario;

    private static AdmCllbckInt href1;
   
    public static void main(String[] args) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vec[1] = "localhost";//UtilidadesConsola.leerCadena();
            vec[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = "2022";//UtilidadesConsola.leerCadena();

            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            POA rootpoa =  POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            
            AdmCllBckImpl aCbck = new AdmCllBckImpl();
            org.omg.CORBA.Object ref1 = rootpoa.servant_to_reference(aCbck);
            href1 = AdmCllbckIntHelper.narrow(ref1);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objUsuarios";
            refPersonal = GestionPersonalIntHelper.narrow(ncRef.resolve_str(name));

            refUsuario = GestionUsuariosIntHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + refPersonal);
                        
            // int rta = 0;
            // do {
            //     rta = menu();
                
            //     switch(rta){
            //         case 1:
            //             opcion1();
            //         break;                        
            //         case 2:
            //             opcion2();
            //         break;
            //         case 3:
            //             opcion3();
            //         break;
            //     }
                
            // }while(rta != 4);

            MenuPrincipal();
            

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
   
    private static void MenuPrincipal()
    {
        int opcion = 0;
        do{
            System.out.println("==Menu Inicio==");
            System.out.println("1. Abrir Sesion Gestores");	
            System.out.println("2. Abrir Sesion Usuarios");			
            System.out.println("3. Salir");


            opcion = UtilidadesConsola.leerEntero();

             switch(opcion)
            {
                case 1:
                        System.out.println("Ingrese el usuario");
                        String varCrUsuario = UtilidadesConsola.leerCadena();
                        System.out.println("Ingrese la clave");
                        String varCrClave = UtilidadesConsola.leerCadena();
                        CredencialDTO objCredencial = new CredencialDTO(varCrUsuario,varCrClave);
                    
                        int sesion = -1;
                        
                        sesion = refPersonal.abrirSesion(objCredencial);

                        switch(sesion){
                            case 0:
                                OpcionAdmin();
                                break;
                            case 1:
                                System.out.println("REGISTRANDO CALLBACK");
                                refUsuario.registrarCallback(href1);
                                OpcionPaf();
                                break;
                            case 2:
                                OpcionSecre();
                                break;
                            case -1:
                                System.out.println("El personal"+objCredencial.usuario+"No esta autorizado para ingresar al sistema");
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                break;

                case 2:
                        System.out.println("Salir...");
                break;
                
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcion != 2);
        
    }

    private static void OpcionAdmin(){
        int opcionAdmin=0;
        
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Registrar personal");			
            System.out.println("2. Consultar personal");
            System.out.println("3. Editar personal");
            System.out.println("4. Eliminar personal");
            System.out.println("5. Salir");

            opcionAdmin = UtilidadesConsola.leerEntero();

            switch(opcionAdmin)
            {
                case 1:
                        Opcion1();
                        break;
                case 2:
                        Opcion2();
                        break;	
                case 3:
                        Opcion3();
                        break;
                case 4:
                        Opcion4();
                        break;
                case 5:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionAdmin != 5);
    }


    private static void OpcionPaf(){
         int opcionPaf=0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Valorar PAF");			
            System.out.println("2. Registrar Asistencia");
            System.out.println("3. Salir");

            opcionPaf = UtilidadesConsola.leerEntero();

            switch(opcionPaf)
            {
                case 1:
                        System.out.println("por implementar");
                        break;
                case 2:
                        System.out.println("por implementar");
                        break;	
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionPaf != 3);
    }

     private static void OpcionSecre(){
         int opcionSecre = 0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Registrar usuario");			
            System.out.println("2. Consultar usuario");
            System.out.println("3. Salir");

            opcionSecre = UtilidadesConsola.leerEntero();

            switch(opcionSecre)
            {
                case 1:
                        System.out.println("por implementar");
                        break;
                case 2:
                        System.out.println("por implementar");
                        break;	
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionSecre != 3);
    }

    private static void Opcion1() 
    {
        System.out.println("==Registro del Cliente==");
        boolean bandera=false;
        int opcionTI = 0;
        String varTipoIdentificacion="";

            System.out.println("==TIPO DE IDENTIFICACION==");
            System.out.println("1. Cedula de Ciudadania");			
            System.out.println("2. Tarjeta de Identidad");
            System.out.println("3. Pasaporte");
            


            opcionTI = UtilidadesConsola.leerEntero();

            if(opcionTI==1){
                varTipoIdentificacion="CC";
            }else if(opcionTI==2){
                varTipoIdentificacion="TI";
            }else if(opcionTI==3){
                varTipoIdentificacion="PP";
            }else{
                bandera=true;
            }


        System.out.println("Ingrese el numero de identificacion");
        int varId = UtilidadesConsola.leerEntero();
        if (varId < 0){
            bandera = true;
        }

        System.out.println("Ingrese el nombre completo ");
        String varNombres = UtilidadesConsola.leerCadena();

        System.out.println("Ingrese la ocupacion del nuevo usuario ");
        String varOcupacion="";

            System.out.println("==TIPO DE OCUPACION==");
            System.out.println("1. Secretaria");			
            System.out.println("2. Profesional de acondicionamiento fisico");
            

            opcionTI = UtilidadesConsola.leerEntero();


            if(opcionTI==1){
                varOcupacion="Secretaria";
            }else if(opcionTI==2){
                varOcupacion="Personal de acondicionamiento fisico";
            }else{
                bandera=true;
            }



      

        System.out.println("Ingrese el usuario ");
        String varUsuario = UtilidadesConsola.leerCadena();

        if (varUsuario.length()<8){
            bandera=true;
        }


        System.out.println("Ingrese la contraseña ");
        String varClave = UtilidadesConsola.leerCadena();

        if (varClave.length()<8){
            bandera=true;
        }
        if(!bandera){

            PersonalDTO objUsuario= new PersonalDTO(varTipoIdentificacion, varId, varNombres,varOcupacion,varUsuario,varClave);

            // BooleanHolder resp=new BooleanHolder();
            refPersonal.registrarPersonal(objUsuario);//invocación al método remoto
            // if(resp.value)
                    System.out.println("Registro realizado satisfactoriamente...");
            // else
                    // System.out.println("no se pudo realizar el registro...");


        }else{
            System.out.println("datos erroneos");
        }
    }

    private static void Opcion2()
    {	
        int id = -1;
        System.out.println("========================");
        System.out.println("==Consulta de personal==");
        System.out.println("========================");

        System.out.println("Digite el id del personal a buscar");

        id = UtilidadesConsola.leerEntero();

        PersonalDTOHolder personal  = new PersonalDTOHolder();
        boolean valor = true;
        valor = refPersonal.consultarPersonal(id, personal);
        System.out.println(valor);

        if (valor) {
            System.out.println(personal.value.tipo_id);
            System.out.println(personal.value.id);
            System.out.println(personal.value.usuario);
            System.out.println(personal.value.nombreCompleto);
            System.out.println(personal.value.ocupacion);
        }else{
            System.out.println("Usuario NO encontrado");

        }
    }
    
    private static void Opcion3(){	
        int id = -1;
        int opcionTI = 0;
        boolean bandera=false;
        System.out.println("========================");
        System.out.println("==Editar personal==");
        System.out.println("========================");

        System.out.println("Digite el id del personal a editar");

        id = UtilidadesConsola.leerEntero();

        PersonalDTOHolder personal  = new PersonalDTOHolder();
        boolean valor = true;
        valor = refPersonal.consultarPersonal(id, personal);

        if (valor){
            System.out.println(personal.value.tipo_id);
            System.out.println(personal.value.id);
            System.out.println(personal.value.usuario);
            System.out.println(personal.value.nombreCompleto);
            System.out.println(personal.value.ocupacion);

            System.out.println("========================");
            System.out.println("==Editar personal==");
            System.out.println("========================");

            System.out.println("Ingrese el nombre completo ");
            String varNombres = UtilidadesConsola.leerCadena();

            System.out.println("Ingrese la ocupacion del nuevo usuario ");
            String varOcupacion="";

                System.out.println("==TIPO DE OCUPACION==");
                System.out.println("1. Secretaria");			
                System.out.println("2. Profesional de acondicionamiento fisico");
                

                opcionTI = UtilidadesConsola.leerEntero();


                if(opcionTI==1){
                    varOcupacion="SECRETARIA";
                }else if(opcionTI==2){
                    varOcupacion="PRF. DE ACOND. FISICO";
                }else{
                    bandera=true;
                }

            System.out.println("Ingrese el usuario ");
            String varUsuario = UtilidadesConsola.leerCadena();

            if (varUsuario.length()<8){
                bandera=true;
            }


            System.out.println("Ingrese la contraseña ");
            String varClave = UtilidadesConsola.leerCadena();

            if (varClave.length()<8){
                bandera=true;
            }
            if(!bandera){
                PersonalDTO objPersonalE= new PersonalDTO(personal.value.tipo_id, personal.value.id, varNombres,varOcupacion,varUsuario,varClave);
                boolean varRetorno = refPersonal.editarPersonal(id, objPersonalE);
                if(varRetorno){
                    System.out.println("Registro realizado satisfactoriamente...");
                }else{
                    System.out.println("no se pudo realizar el registro...");
                }

            }else{
                System.out.println("datos erroneos");
            }

        }	
    }

    private static void Opcion4(){	
        int id = -1;
        boolean confirmacion;
        System.out.println("========================");
        System.out.println("==Borrar personal==");
        System.out.println("========================");

        System.out.println("Digite el id del personal a eliminar");

        id = UtilidadesConsola.leerEntero();
        PersonalDTOHolder personal  = new PersonalDTOHolder();
        boolean valor = true;
        valor = refPersonal.consultarPersonal(id, personal);

        if(valor){
            System.out.println(personal.value.tipo_id);
            System.out.println(personal.value.id);
            System.out.println(personal.value.usuario);
            System.out.println(personal.value.nombreCompleto);
            System.out.println(personal.value.ocupacion);

            System.out.println("Digite el 1 para borrar o 0 para cancelar");

            int varConf = UtilidadesConsola.leerEntero();

            if(varConf==1){

                confirmacion=refPersonal.eliminarPersonal(id);
                if (confirmacion){
                    System.out.println("Eliminado con exito");
                }else{
                    System.out.println("Eliminacion fallida");
                }
            }else{
                System.out.println("GRACIAS");
            }
        }	
    }

}