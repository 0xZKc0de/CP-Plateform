java -jar target/quarkus-app/quarkus-run.jar &
PID=$!
while ! curl -s http://localhost:8083 > /dev/null; do sleep 0.1; done
kill $PID 