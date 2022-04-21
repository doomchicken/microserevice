 rm -f test_log && rm -f test_output && JVM_ARGS="-Xms4000m -Xmx4000m" jmeter -n -t Spring\ Reactive.jmx -l test_log.jtl -o ./testreport
