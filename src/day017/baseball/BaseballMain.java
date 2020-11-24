package day017.baseball;

import day017.baseball.controller.Controller;
import day017.baseball.controller.FileController;
import day017.baseball.repository.Repository;
import day017.baseball.service.Service;
import day017.baseball.view.View;

import java.util.InputMismatchException;

public class BaseballMain {
    private final View view = new View();
    private final Repository repository = new Repository();
    private final Service service = new Service(repository);
    private final FileController fileController = new FileController(service);
    private final Controller controller = new Controller(service, view, fileController);

    public static void main(String[] args) {
        BaseballMain baseball = new BaseballMain();

        while(true) {
            try {
                if(!baseball.controller.index()) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다.");
                baseball.controller.clearBuffer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
