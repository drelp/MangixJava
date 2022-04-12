```shell
mvn package
export GPG_TTY=$(tty)
mvn clean deploy -P release

mvn skip test
mvn clean deploy -P release -Dmaven.test.skip=true 
mvn install -Dmaven.test.skip=true 

mvn package -Dmaven.test.skip=true
```

```shell
HttpPost X-Frame-Options: DENY
```