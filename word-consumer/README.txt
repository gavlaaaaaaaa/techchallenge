Application expects a stream of text being output on a specific port
TO RUN
-----------
Build with maven  - "mvn package"

Run with the following command:
spark-submit --master local[4] --class StreamingWordConsumer
/home/training/techchallenge/Spark_Attack/word-consumer/target/streamingwordconsumer-1.0.jar
<hostname> <port>

E.g:
spark-submit --master local[4] --class StreamingWordConsumer
/home/training/techchallenge/Spark_Attack/word-consumer/target/streamingwordconsumer-1.0.jar
localhost 1234


HELPER SCRIPTS
--------------
In the script directory use script publishOutput.sh as follows:
publishOutput.sh <port> <filename> 
e.g. publishOutput.sh 1234 /home/training/spark_input.txt

The script will then stream the output of the file to port 1234.
The Spark application can then consume this.
