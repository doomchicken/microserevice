 rm -f ./jmeter/test_log.jtl  \
&& rm -f ./jmeter/jmeter.log  \
&& rm -f -r ./jmeter/test-report  \
&& mkdir ./jmeter/test-report  \
&& JVM_ARGS="-Xms8000m -Xmx8000m"  \
jmeter -n -t ./jmeter/Jmeter\ Test\ Plan.jmx -l ./jmeter/test_log.jtl -e -o ./jmeter/test-report
