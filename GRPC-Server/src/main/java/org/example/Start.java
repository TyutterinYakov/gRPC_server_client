package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service.GreetingServiceImpl;

import java.io.IOException;

public class Start {

    public static void main(String[] args){
        Server server = ServerBuilder
                .forPort(8080)
                .addService(
                        new GreetingServiceImpl())
                .build();
        try {
            server.start();
            System.out.println("server started");
            server.awaitTermination();
        } catch(Exception ex){
            System.out.println("Error starting the server or it stopped");
            ex.printStackTrace();
        }
    }
}
