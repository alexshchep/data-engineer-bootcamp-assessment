import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import java.io.File

object HdfsHive{
  def main(args: Array[String]){
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath
    val spark = org.apache.spark.sql.SparkSession
	.builder()
       // .master("local")
        .appName("Spark CSV Reader")
	.config("spark.sql.warehouse.dir", warehouseLocation)
	.enableHiveSupport()
        .getOrCreate();
    val df = spark.read
         .format("csv")
         .option("header", "true") //first line in file has headers
         .option("mode", "DROPMALFORMED")
         .load("hdfs:///user/root/drivers.csv")
    val df2 = spark.read
         .format("csv")
         .option("header", "true") //first line in file has headers
         .option("mode", "DROPMALFORMED")
         .load("hdfs:///user/root/timesheet.csv")
    print("printing df\n")
   df.show()
   df2.show()
   val dfdriver = df.as("dfdriver")
   val dftimes = df.as("dftimes")
//   val dfjoin = dfdriver.join(dftimes, col("dfdriver.driverid") === col("dftimes.driverid"), "inner").show
    // insert Hive tables
  //  df.write.mode("overwrite").saveAsTable("drivers")
  //  df2.write.mode("overwrite").saveAsTable("timesheet")
   import spark.implicits._
   import spark.sql
	System.out.println("---------------------------------------------------------")
   //spark.stop
   // val conf = new SparkConf()
   // val sc = new SparkContext(conf)
   // val sqlContext = new org.apache.spark.sql.SQLContext(sc)
 //  dfjoin = df1.join(df2, col("sql("Select d.driverId, name,  sum('hours-logged'), sum('miles-logged') from drivers d inner join timesheet t on d.driverId = t.driverid group by d,driverId").show()   
  //  spark.stop
   //  sqlContext.sql("Select * from drivers").show 
    //sqlContext.sql("CREATE TABLE IF NOT EXISTS mytable as select * from temptable")
   }}

