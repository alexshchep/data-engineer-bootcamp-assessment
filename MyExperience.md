#My experience and further notes

Put here general information about the steps you took, what you liked, disliked, why did you do X instead of Y and so on.

## HDP Sandbox

I started using the Sandbox and I downloaded VirtualBox on my Mac machine. I had some problems during my first installation. I went through the installation the second time in order to get it to work. 
Some things that I noticed were that sshing into the sandbox with different ports makes a slight difference between what files are available.
In the future I've used the -2222 port to work on the HDFS, Hive, and HBase, which connects to DockerSSH.
I had to run docker-deploy-hdp30.sh to make sandbox-flavor.

Here is my Sandbox Information:
== Sandbox Information ==
Platform: hdp-security
Build date: 11-29-2018
Ambari version: 2.7.1.0-169
Hadoop version: Hadoop 3.1.1.3.0.1.0-187
OS: CentOS Linux release 7.5.1804 (Core) 
====
 

## HDFS & Hive on Spark

Initially I wanted to use a scalaIDE to work on the code, but I could not find a free version that could SSH, so I ended up using Vim.
I've never worked with Scala before, so I did some tutorials, and tested Spark with Hello World.
In the sbt compilation, I checked the HBase, Scala, and hadoop version installed on the Linux VM, and used those. There were always warning about some dependencies being used over others. I was never sure whether that could create problems.

To load the files I used 
hadoop fs -put filename /user/root/, 
and to check the loaded files
hadoop fs -ls. 

I had many issues with connection refused error for Hadoop. I did not find stackoverflow as useful as it usually is. I think that is because this is a smaller niche and functions get deprecated quickly. I ended up using the API documentation more than stackoverflow.


## HBase

I spent 2 to 3 days trying to get passed 

Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/hadoop/hbase/HBaseConfiguration
	
but could not. I tried to add directories to --driver-class-path, I downloaded the hbase-common-2.0.0 and tried to add that to --jars. I've added /etc/hadoop/conf to $CLASSPATH, I've tried $ export SPARK_CLASSPATH=$SPARK_CLASSPATH:`hbase classpath`. I tried to implement https://issues.apache.org/jira/browse/HBASE-14750, https://stackoverflow.com/questions/32064607/java-lang-classnotfoundexception-org-apache-hadoop-hbase-hbaseconfiguration. export HADOOP_CLASSPATH=`/usr/bin/hbase classpath`. Ive tried to change dependencies, code, etc.. but couldnt figure it out. I tried restarting all the services too, but no luck. This was frustrating, especially since I was not able to figure it out.. I do feel like I learned about Hadoop though, so Im thankful for that. I have a better understanding about which service is used for what function.
