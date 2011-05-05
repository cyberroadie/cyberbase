package net.th.hbase.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/**
 * @author cyberroadie
 *         Date: 11/04/11
 */
public class Table {

    private HBaseAdmin admin;

    public Table(Configuration configuration) throws ZooKeeperConnectionException, MasterNotRunningException {
        this.admin = new HBaseAdmin(configuration);
    }

    public void create(String tableName) throws IOException {
        HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
        HColumnDescriptor columnDescriptor = new HColumnDescriptor("day");
//        columnDescriptor.setValue("day", "monday");
//        columnDescriptor.setValue("day", "tuesday");
//        columnDescriptor.setValue("day", "wednesday");
//        columnDescriptor.setValue("day", "thursday");
//        columnDescriptor.setValue("day", "friday");
//        columnDescriptor.setValue("day", "saturday");
//        columnDescriptor.setValue("day", "sunday");
        tableDescriptor.addFamily(columnDescriptor);
        if(!admin.tableExists(tableName))
            admin.createTable(tableDescriptor);
    }

    public void delete(String tableName) throws IOException {
        if(admin.tableExists(tableName)) {
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        }
    }
}

