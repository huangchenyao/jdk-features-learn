package com.abc.jdk9;

public class InterfaceMethod {

}

interface Logging {
    // 常量
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    // 私有方法
    private void log(String message, String prefix) {
        getConnection();
        System.out.println("[" + prefix + "]" + message);
        closeConnection();
    }

    // 私有静态方法
    private static void getConnection() {
        System.out.println("Open Database connection");
    }

    private static void closeConnection() {
        System.out.println("Close Database connection");
    }

    // 默认方法
    default void logInfo(String message) {
        log(message, "INFO");
    }

    default void logWarn(String message) {
        log(message, "WARN");
    }

    default void logError(String message) {
        log(message, "ERROR");
    }

    default void logFatal(String message) {
        log(message, "FATAL");
    }

}
