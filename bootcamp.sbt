name := "bootcamp"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.3.1"
val hbaseVersion = "2.0.0"
val hadoopVersion = "3.1.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.hbase" % "hbase-server" % hbaseVersion,
  "org.apache.hbase" % "hbase-client" % hbaseVersion,
  "org.apache.hbase" % "hbase-common" % hbaseVersion,
  "org.apache.hadoop" % "hadoop-common" % hadoopVersion,
  "org.apache.hadoop" % "hadoop-client" % hadoopVersion
)
