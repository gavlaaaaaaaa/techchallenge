if [ $# -ne 2 ] 
then
	echo "Incorrect number of params: Usage - publishOutput.sh <port> <filename>"
	exit 1
fi

port=$1
filename=$2

echo "Port is: $port"
echo "Writing output of file $filename to localhost:$port"
tail -f $filename | nc -lk $port

