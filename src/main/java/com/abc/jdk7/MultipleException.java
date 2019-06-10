package com.abc.jdk7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 异常处理增强
 */
public class MultipleException {
    // Handling More Than One Type of Exception
    // 在Java 7及更高版本中，单个catch块可以处理多种类型的异常。此功能可以减少代码重复并减少捕获过于宽泛的异常。

    // 以下示例中，catch块中包含重复的代码
    void handlingException(String type) {
        try {
            switch (type) {
                case "1":
                    throw new SQLException();
                default:
                    throw new IOException();
            }
        } catch (IOException ex) {
//        logger.log(ex);
//        throw ex;
        } catch (SQLException ex) {
//        logger.log(ex);
//        throw ex;
        }
    }

    // 在Java 7之前的版本中，很难创建一个减少重复代码的通用方法，因为ex具有不同的类型。
    // 以下示例（在Java SE 7及更高版本中有效）消除了重复的代码：
    void handlingException7(String type) {
        try {
            switch (type) {
                case "1":
                    throw new SQLException();
                default:
                    throw new IOException();
            }
        } catch (IOException | SQLException ex) {
//        logger.log(ex);
//        throw ex;
        }
    }

    // catch子句指定块可以处理的异常类型，每个异常类型用竖线（|）分隔。
    // 如果catch块处理多个异常类型，则catch参数隐式为final。在此示例中，catch参数ex是final，因此您无法在catch块中为其分配任何值。

    // 重新抛出异常
    // 与早期版本的Java相比，Java 7编译器对重新抛出的异常执行更精确的分析。这使您可以在方法声明的throws子句中指定更具体的异常类型。
    static class FirstException extends Exception {
    }

    static class SecondException extends Exception {
    }

    // Java 7之前
    public void rethrowException1(String exceptionName) throws Exception {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // 在Java 7中，虽然catch中抛出的异常类型是Exception，但是编译器会根据上下文信息推断该方法可能抛出的异常类型
    public void rethrowException2(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // 对异常进行预处理（记录日志等），然后原原本本抛出异常
}
