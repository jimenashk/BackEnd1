public class Main {
    public static void main(String[] args) {

        Serie mrRobot = new Serie();
        SerieProxy proxy = new SerieProxy();

        try {
            proxy.getSerie("mrRobot");
            proxy.getSerie("mrRobot");
            proxy.getSerie("mrRobot");
            proxy.getSerie("mrRobot");
            proxy.getSerie("mrRobot");
            proxy.getSerie("mrRobothjg");

        } catch (SerieNoHabilitadaException e) {
            e.printStackTrace();
        }
    }
}

