
public class Apartado2 {

    public static void main(String[] args) {
        String os=System.getProperty("os.name").toLowerCase();
        //System.out.println("Sistema operativo: "+os);
        boolean isWindows = os.contains("windows");
        if(isWindows){
            //System.out.println("Ejecutando en Windows");
            ProcessBuilder pb = new ProcessBuilder("notepad");
            try {
                Process proceso=pb.start();
            } catch (Exception e) {
                System.out.println("Error al ejecutar el comando");
                e.printStackTrace();
            }

        }
    }
}