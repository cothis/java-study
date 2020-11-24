package day016.account;

import day016.account.annotation.Component;
import day016.account.annotation.Controller;
import day016.account.controller.MemberController;
import day016.account.repository.AccountRepository;
import day016.account.repository.MemoryRepository;
import day016.account.service.Service;
import day016.account.view.View;

import java.lang.annotation.Annotation;

public class Container {
    private final View view = new View();
    private final AccountRepository accountRepository = new MemoryRepository();
    private final Service service = new Service(accountRepository);
    private final MemberController memberController = new MemberController(service, view);

    /* Dependency Injection in Testing...
    public Container() {
        Class controllerClass = Controller.class;
        Annotation annotation = controllerClass.getAnnotation(Component.class);

        if(annotation instanceof Component) {
            System.out.println(controllerClass.getConstructors());
        }
    }
     */


    public void start() {
        while(true) {
            boolean exit = memberController.index();
            if(exit) break;
        }
    }
}
