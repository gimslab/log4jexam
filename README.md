# dynamic log level change at runtime

```bash
$ http -b :8080/loggers
ROOT INFO   INFO
org.apache.catalina.startup.DigesterFactory ERROR   ERROR
org.apache.catalina.util.LifecycleBase ERROR   ERROR
org.apache.coyote.http11.Http11NioProtocol WARN   WARN
org.apache.sshd.common.util.SecurityUtils WARN   WARN
org.apache.tomcat.util.net.NioSelectorPool WARN   WARN
org.eclipse.jetty.util.component.AbstractLifeCycle ERROR   ERROR
org.hibernate.validator.internal.util.Version WARN   WARN

$ http -b :8080/loggers?all
...
```

```bash
$ http -b :8080/loggers?testLog
... # check log
```

```bash
$ http -b PUT :8080/loggers/com.gimslab.logbackexam.dynamiclevelchange.pkga/level/ERROR
ROOT INFO   INFO
com.gimslab.logbackexam.dynamiclevelchange.pkga ERROR   ERROR
...
```

```bash
http -b PUT :8080/loggers/ROOT/level/OFF
ROOT OFF   OFF
com.gimslab.log4jexam.log4jexam.pkga DEBUG   DEBUG
...
```


```bash
http -b DELETE :8080/loggers/com.gimslab.logbackexam.dynamiclevelchange.pkga/level
ROOT OFF   OFF
```


