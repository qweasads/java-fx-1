package com.example.demo1;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyService myService = new MyService();
        myService.setOnSucceeded(new EventHandler<WorkerStateEvent>(){
            @Override
            public void handle(WorkerStateEvent t){
                System.out.println("done: " + t.getSource().getValue());
            }
        });
        myService.start();



        Group root = new Group();
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    static class MyService extends Service {

        @Override
        protected Task createTask() {
            return new Task<String>(){
                @Override
                protected String call() throws Exception {
                    return "Hello World";
                }
            };
        }
    }
    }


