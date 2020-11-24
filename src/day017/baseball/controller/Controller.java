package day017.baseball.controller;

import day017.baseball.domain.Player;
import day017.baseball.service.Service;
import day017.baseball.view.View;

import java.util.List;

public class Controller {
    private final Service service;
    private final FileController fileController;
    private final View view;

    public Controller(Service service, View view, FileController fileController) {
        this.service = service;
        this.view = view;
        this.fileController = fileController;

        List<Player> list = fileController.loadData();
        service.joinLoadData(list);
    }

    public void clearBuffer() {
        view.clearBuffer();
    }

    public boolean index() throws Exception {
        String userSelect = view.menu();
        switch (userSelect) {
            case "1": {
                // 추가
                Player p = view.addForm();
                service.join(p);
                break;
            }
            case "2": {
                // 삭제
                int id = view.removeForm();
                service.removeById(id);
                break;
            }
            case "3": {
                // 검색
                String name = view.searchForm();
                service.findByName(name).ifPresent(view::printPlayer);
                break;
            }
            case "4": {
                // 출력
                view.printAll(service.findPlayers());
                break;
            }
            case "5": {
                fileController.saveData(service.findPlayers());
                break;
            }
            default:
                // 종료
                return false;
        }
        return true;
    }
}
