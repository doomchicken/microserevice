 rm -f test_log.jtl  \
&& rm -f jmeter.log  \
&& rm -f -r test-report  \
&& mkdir test-report  \
&& JVM_ARGS="-Xms8000m -Xmx8000m"  \
jmeter -n -t Spring\ Reactive.jmx -l test_log.jtl -e -o /Users/gregoryfavish/dev/microsrevice\ 2/test-report
