import controller.ApiController;

public class Main {
    public static void main(String[] args) {

       ApiController apiController=new ApiController();
       apiController.startSparkHttpServer();

    }
}