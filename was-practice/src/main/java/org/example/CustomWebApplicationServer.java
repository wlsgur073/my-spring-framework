package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

//                Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
//                Step2는  ClientRequestHandler를 만들어서 그쪽 Thread에 넣어주었다.

//                아래와 같이 하면, 사용자의 요청이 들어올때마다 Thread가 새로 생성되어
//                생성될때마다 독립적인 메모리를 할당받고 요청이 많아질수록 성능을 매우 저하시킨다.
                new Thread(new ClientRequestHandler(clientSocket)).start();

//                따라서 Thread를 고정된 갯수만큼 생성해두고 이를 재활용하는 Thread Pool 개념을 적용해보자.
//                Step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                
            }
        }
    }
}
