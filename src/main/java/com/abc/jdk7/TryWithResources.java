package com.abc.jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * try-with-resources
 * try-with-resources语句是声明一个或多个资源的try语句。
 * 资源在语句结束后都必须关闭，使用try-with-resources语句可以确保在语句结束时关闭每一个资源。
 * 实现了java.lang.AutoCloseable接口的任何对象（包括实现java.io.Closeable的所有对象）都可以用作资源。
 */
public class TryWithResources {
    /*
     * 以下示例从文件中读取第一行数据，它使用BufferedReader从文件中读取数据，BufferedReader在程序完成后需要关闭。
     * 在此示例中，try-with-resources语句中声明的资源是BufferedReader，声明语句出现在try关键字后面的括号内。
     * Java 7及更高版本中的BufferedReader类实现了java.lang.AutoCloseable接口。
     * 因为BufferedReader实例是在try-with-resource语句中声明的，
     * 所以无论try语句是正常还是异常（由于BufferedReader.readLine方法抛出IOException），它都将被关闭。
     */
    static void readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // 文件操作
            br.readLine();
        }
    }

    // 在Java 7之前，我们使用finally块确保资源可以被正确关闭，无论try是正常还是异常
    static void readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            // 文件操作
            br.readLine();
        } finally {
            // 防止finally的异常抑制业务代码中的异常
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 在此示例中，如果方法readLine和close都抛出异常，则方法readFirstLineFromFileWithFinallyBlock抛出finally块抛出的异常，
     * 从try块抛出的异常被抑制。
     */
    /*
     * 相反，在readFirstLineFromFile中，如果从try块和try-with-resources语句抛出异常，
     * 则readFirstLineFromFile方法抛出try块抛出的异常，从try-with-resources块抛出的异常被抑制。
     */

    // 可以在try-with-resources语句中声明一个或多个资源
    // 资源的close方法按其创建的相反顺序调用
    public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
            throws java.io.IOException {
        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with try-with-resources statement
        try (
                java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    // 使用try-with-resources语句自动关闭java.sql.Statement对象
    public static void viewTable(Connection con) throws SQLException {
        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + ", " + supplierID + ", " + price +
                        ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
//            JDBCTutorialUtilities.printSQLException(e);
        }
    }
    // The resource java.sql.Statement used in this example is part of the JDBC 4.1 and later API.

    // try-with-resources语句可以像普通的try语句一样有catch和finally块。
    // 在try-with-resources语句中，在声明的资源关闭后运行任何catch或finally块。

    // 抛出正确的异常
    // 可以从与try-with-resources语句关联的代码块中抛出异常。
    // 在示例writeToFileZipFileContents中，可以从try块抛出异常，
    // 并且当try-with-resources语句尝试关闭ZipFile和BufferedWriter对象时，最多可以抛出两个异常。
    // 如果从try块抛出异常并且从try-with-resources语句抛出了一个或多个异常，那么从try-with-resources语句抛出的那些异常将被抑制，
    // 并且块抛出的异常是这是由writeToFileZipFileContents方法抛出的。
    // 您可以通过从try块抛出的异常中调用Throwable.getSuppressed方法来检索这些抑制的异常。
}
