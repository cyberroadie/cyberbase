package net.th.hbase.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;

import java.io.IOException;

/**
 * @author cyberroadie
 *         Date: 05/05/11
 */
public class Main {

    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        try {
            Table table = new Table(config);
            table.create("main");
        } catch (ZooKeeperConnectionException e) {
            System.out.println(e.toString());
        } catch (MasterNotRunningException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
