package net.th.hbase.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author cyberroadie
 *         Date: 05/05/11
 */
public class TableTest {

    Configuration config = HBaseConfiguration.create();

    @Test
    public void testCreate() throws Exception {
        Table table = new Table(config);
        table.create("olivier");
    }

    @Test
    public void testDelete() throws Exception {
        Table table = new Table(config);
        table.delete("olivier");
    }
}
