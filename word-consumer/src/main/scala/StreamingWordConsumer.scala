import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.SparkConf

object StreamingWordConsumer {

  def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println("Usage: StreamingWordConsumer <hostname> <port>")
      System.exit(1)
    }

    val hostname = args(0)
	val port = args(1).toInt

    val ssc = new StreamingContext(new SparkConf(),Seconds(10))
    val lines = ssc.socketTextStream(hostname, port)
    val words = lines.flatMap(line => line.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey((x,y) => x+y)
    wordCounts.saveAsTextFiles("/lewis/wcountdir")
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
 }
}
