# Setup OSFE and Run Demo #

# Setup OSFE (Section 1 of 2) #

1) download osfe-bin-1.01-with-dependencies.tar.gz
> from: http://code.google.com/p/open-source-feed-engine/downloads/list

2) Create the environment variable, OSFE\_WORK, that will point the location of the OSFE home directory.

> Example: OSFE\_WORK=~/osfe.

3) Extract osfe-bin-1.01-with-dependencies.tar.gz to a directory of your choosing (e.g. temp).

> Example: tar zxf osfe-bin-1.01-with-dependencies.tar.gz

4) Install MySQL

> You will need to download and install MySQL database,
> if you have not done so already.

5) Login into mysql and create an OSFE database:

> mysql> create database osfedb;

6) Where you extracted OSFE, go to the following subdirectory:

> /install/database/mysql/schema/ddl/ver1.0

> Run the following three mysql commands using the
> appropriate username and password:

  * mysql -u? -p? -Dosfedb < create.ddl
  * mysql -u? -p? -Dosfedb < populate.sql
  * mysql -u? -p? -Dosfedb < demodata.sql

7) Where you extracted OSFE, go to the following subdirectory:

> /install/database/mysql/config/common/

> Edit file config.properties. If necessary, modify the following
> properties to match your mysql username and password:

  * osfe.db.username=root
  * osfe.db.password=admin

# Run Demo (Section 2 of 2) #

**SETUP UP OSFE TO RUN DEMO FEEDS**

**NOTE! The following step will not work properly if you have not successfully completed steps 1 through 7.**

> This next step will create the OSFE directory structure under $OSFE\_WORK.

> Where you extracted OSFE, go to the subdirectory, osfe-examples and run script, sfe\_demo.sh.

> Example:

  * cd osfe-examples
  * chmod +x osfe\_demo.sh
  * ./osfe\_demo.sh

> If the script executed correctly, you should have the
> following subdirectories under $OSFE\_WORK:

  * /config
  * /feeds
  * /logs
  * /partnerConfig

> Congratulations! You should now be able to run some
> demo feeds using OSFE.

**What have we done?**

1) OSFE uses a MySql database to manager the life cycle of processing a feed file, so you created a database, osfedb.

2) The script loaded specific database tables with meta data that OSFE requires to run properly. Take a look at the content of the following tables:

  * t\_feed\_direction
  * t\_feed\_file\_state
  * t\_feed\_job\_state
  * t\_feed\_protocol
  * t\_feed\_role
  * t\_feed\_user

3) The script then loaded specific tables with program data to define feed definitions. Take a look at the content of the following tables:

  * t\_data\_source
  * t\_feed\_type
  * t\_group
  * t\_feed

4) OSFE uses feed documents that tell it how to run a specific type of feed and what Java classes to use.  Take a look at two different feed documents:

  * [$OSFE\_WORK/partnerConfig/feed/acme/testd/request/config.xml](http://www.qagen.com/images/osfe/delimited_config.xml.txt)
  * [$OSFE\_WORK/partnerConfig/feed/acme/testf/request/config.xml](http://www.qagen.com/images/osfe/fixed_config.xml.txt)

The document under, /testd/request/config.xml, tells OSFE how to process a delimited feed file with the following format:

```
  15020080420,150,20080420-05:04:49
  1000000,Last1,First1,A,71
  1000001,Last2,First2,B,72
  1000002,Last3,First3,C,76
  ...
  15020080420,150,20080420-05:04:49,50000
```

The document under, /testf/request/config.xml, tells OSFE how to process a fixed feed file with the following format:

```
   2822008072728220080727-08:07:05
   1000000 Last1          First1         A67 
   1000001 Last2          First2         B97 
   1000002 Last3          First3         C94 
   ...
   7922008072779220080727-08:07:06100000  
```

5) OSFE determines where to look for feeds to process by retrieving a feed definition in table t\_feed, with a given feed Id.  In table, t\_feed the column, feed\_directory contains the path where the feed directories for the given feed definition are located. The structure for inbound feeds will contain the following sub directories (archive, download, failed, incoming, preprocess, rejected, temp & workarea). OSFE will look in the inbound subdirectory for feeds to process.

The script has loaded a set of delimited and fixed feed files for OSFE to process.  Look under the following directories:

  * $OSFE\_WORK/feed/acme/qagen/testd/request/incoming
  * $OSFE\_WORK/feed/acme/qagen/textf/request/incoming

**RUN YOUR FIRST OSFE FEED**

> Processing a feed is fairly simple. You simply need to
> know the name of the feed you would like to process and
> it's feed definition Id.  Lets process a feed!

  * cd osfe-examples
  * chmod +x feed\_endine.sh
  * ./feed\_engine.sh acme\_qagen\_testd\_request acme\_qagen\_testd\_request\_20080728100700.txt

**What just happended?**

> If you have setup of OSFE correctly, OSFE processed
> a delimited feed file. The feed file contains 100,000
> rows of student test scores. For each student a grade
> must be determined and the class average must be calculated.

> OSFE used the feedId, to lookup the feed definition. The
> feed definition contains the location of the feed configuration
> document and the location of the feed file directory structure.

> The feed document contains the list of phases that OSFE will
> use to process each row of data in the feed file. One of the
> phases, GradingPhase, determines a students grade. Another phase,
> StatsPhase, calculates the class average.

> To see the source files, download osfe-1.0-src-tar.gz.
> Under directory osfe-examples, look for the following classes:

  * [com.qagen.osfe.examples.acme.phases.GradingPhase.java](http://www.qagen.com/images/osfe/GradingPhase.java.txt)
  * [com.qagen.osfe.examples.acme.phases.StatPhase.java](http://www.qagen.com/images/osfe/StatsPhase.java.txt)

> How did OSFE manage the lifecycle in the OSFE databas osfedb?
> Take a look at the following tables in osfedb:

  * t\_feed\_file
  * t\_fee\_job
  * t\_feed\_phase\_stats
  * t\_fee\_checkpoint

**PROCESS MANY FEEDS AT ONE TIME**

> OSFE can process many feeds at one time.  Run the following script:

  * cd /osfe-examples
  * chmod +x process\_feeds.sh
  * ./process\_feeds.sh

**What just happend?**

> A class, [com.qagen.osfe.examples.acme.demo.ProcessFeeds.java](http://www.qagen.com/images/osfe/ProcessFeeds.java.txt),
> retrieved all of the delimited and fixed feed files and launched
> each of them one right after the other in multiple FeedEngine
> threads. Thus, each feed was being processed and managed by OSFE
> simultaneously.  Now, take a look at the following tables in
> osfedb:

  * t\_feed\_file
  * t\_fee\_job
  * t\_feed\_phase\_stats
  * t\_fee\_checkpoint