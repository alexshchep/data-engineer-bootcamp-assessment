import sys._
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import java.io.File
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.HBaseAdmin
//import org.apache.hadoop.hbase._
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.client.TableDescriptor
import org.apache.hadoop.hbase.client.TableDescriptorBuilder
//import org.apache.hadoop.hbase.HTableDescriptor

object createHBase
{
  def main(args: Array[String]){
    System.out.println("Creating Hbase Table")
    val sparkConf = new SparkConf().setAppName("HBaseCreate")
    val sc = new SparkContext(sparkConf)
    val conf = HBaseConfiguration.create()
    val hbaseConfigFolder = "/etc/hbase/conf/" 
    System.out.println("HBase folder is ......")
    System.out.println(hbaseConfigFolder)
 //   conf.addResource(new File(hbaseConfigFolder + "hbase-site.xml").toURI.toURL)
//    val connection = ConnectionFactory.createConnection(conf)
//    val admin = connection.getAdmin()
//    val table = new HTableDescriptor(TableName.valueOf("dangerous_driving"))
//    val desc = TableDescriptorBuilder.newBuilder(TableName.valueOf("dangerous_driving")).build()
//    admin.createTable(desc)
    System.out.println("Table dangerous_driving created")
}}

