package com.bobby.peng.gladiator.server.proxy;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by peng2035 on 2017/8/27.
 */
public class ProviderProxy {

    private static final Executor pool = Executors.newFixedThreadPool(20);

    public static void provide(final Object service, int port) throws IOException {
        System.out.println("in provider");
        if (service == null || port > 65535 || port <= 0) {
            throw new IllegalArgumentException("Illegal param");
        }

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            pool.execute(() -> {
                try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

                    String methodName = ois.readUTF();
                    Object[] args = (Object[]) ois.readObject();

                    Object result = MethodUtils.invokeExactMethod(service, methodName, args);
                    oos.writeObject(result);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

        }
    }

}
